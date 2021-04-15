package com.cg.hims.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.hims.application.HomeInsuranceManagementSystemApplication;
import com.cg.hims.entities.Policy;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Property;
import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.QuoteNotFoundException;
import com.cg.hims.repository.PolicyHolderRepository;
import com.cg.hims.repository.PolicyRepository;
import com.cg.hims.repository.PropertyRepository;
import com.cg.hims.repository.QuoteRepository;
import com.cg.hims.service.PolicyHolderService;

@SpringBootTest(classes = HomeInsuranceManagementSystemApplication.class)
public class PolicyHolderTest {
	@Autowired
	private PolicyHolderService phs;
	@MockBean
	private PolicyHolderRepository pr;
	@MockBean
	private PropertyRepository property;
	@MockBean
	private QuoteRepository qs;
	@MockBean
	private PolicyRepository por;



	public PolicyHolder addPh() {
		LocalDate d = LocalDate.of(2020, Month.APRIL,12);
		PolicyHolder ph = new PolicyHolder();
		ph.setPolicyHolderId(555);
		ph.setPolicyHolderName("Harsha");
		ph.setCreditCard("Visa");
		ph.setDob(d);
		ph.setOccupation("Designer");
		ph.setAnnualIncome(200000.0);
		ph.setRetired(false);
		ph.setResidenceType("Single");
		ph.setCity("Chennai");
		ph.setState("TN");
		ph.setZip(600006);
		ph.setResidenceUse("For 5 years");
		return ph;
	}

	public Property addProperty()
	{
		Property p =new Property();
		p.setPropertyId(23);
		p.setHasSwimmingPool(true);
		p.setMarketValue(100000L);
		p.setSquareFootage(500);
		p.setYearBuilt(1994);
		return p;

	}

	@Test
	public void testAddProperty() throws Exception{
		Property p=addProperty();
		when(property.save(p)).thenReturn(p);
		assertEquals(p,phs.addProperty(p));
		assertFalse(p.getSquareFootage()==150);

	}
	@Test
	public void testUpdateProperty() throws Exception  {
		Property p = addProperty();
		p.setYearBuilt(1995);
		when(property.save(p)).thenReturn(p);
		assertEquals(p,phs.updateProperty(p));
		assertFalse(p.getYearBuilt()==2000);
	}

	@Test
	public void testDeletePolicyHolder() throws PolicyHolderNotFoundException,Exception {
		PolicyHolder ph = addPh();
		int id=ph.getPolicyHolderId();
		phs.removePolicyHolder(id);
		verify(pr,times(1)).deleteById(id);
	}

	@Test
	public void testDelete()throws PolicyHolderNotFoundException,Exception
	{
		PolicyHolder ph=addPh();
		phs.removePolicyHolder(ph.getPolicyHolderId());
		assertThrows(PolicyHolderNotFoundException.class,()->phs.viewPolicyHolder(ph.getPolicyHolderId()));
		PolicyHolder ph1 =addPh();
		Optional<PolicyHolder>optional=pr.findById(ph1.getPolicyHolderId());
		if(optional.isPresent())
		{
			assertDoesNotThrow(()->{optional.get();});
		}

	}

//	@Test
//	public void testUpdatePolicyHolder() throws PolicyHolderNotFoundException,Exception  {
//		PolicyHolder ph = addPh();
//		ph.setPolicyHolderName("Kunal");
//		when(pr.save(ph)).thenReturn(ph);
//		assertEquals("PolicyHolder updated",phs.updatePolicyHolder(ph));
//		assertFalse(ph.getPolicyHolderName()=="rahul");
//	}

	@Test
	public void testAddPolicyHolder() throws PolicyHolderNotFoundException,Exception  {
		PolicyHolder ph = addPh();
		when(pr.save(ph)).thenReturn(ph);
		assertEquals("PolicyHolder added to database",phs.addPolicyHolder(ph));
		assertFalse(ph.getAnnualIncome()==100000.00);
	}

	@Test
	public void testGetPolicyHolderById()throws PolicyHolderNotFoundException,Exception{
		PolicyHolder ph=addPh();
		int id=ph.getPolicyHolderId();
		Optional<PolicyHolder>optional=pr.findById(id);
		if(optional.isPresent())
		{
			when(optional.get()).thenReturn(optional.get());
			assertEquals(optional.get(),phs.viewPolicyHolder(id));
		}
	}

	@Test
	public void testGetProperty()throws Exception
	{
		Property p=addProperty();
		int id=p.getPropertyId();
		Optional<Property>optional=property.findById(id);
		if(optional.isPresent())
		{
			when(optional.get()).thenReturn(optional.get());
			assertEquals(optional.get(),phs.viewProperty(id));
		}
	}
	@Test
	public void testGetQuote()throws Exception
	{
		Quote quote = new Quote(444,"platinum",5000.00,6000.00,7000.00,8000.00,9000.00,10000.00,11000.00);
		int id=quote.getQuoteId();
		Optional<Quote>optional=qs.findById(id);
		if(optional.isPresent())
		{
			when(optional.get()).thenReturn(optional.get());
			assertEquals(optional.get(),phs.viewQuote(id));
		}
	}

	@Test
	public void testUpdateQuote()throws Exception
	{
		Quote quote = new Quote(444,"platinum",5000.00,6000.00,7000.00,8000.00,9000.00,10000.00,11000.00);
		quote.setPremiumType("bronze");
		when(qs.save(quote)).thenReturn(quote);
		assertEquals(quote,phs.updateQuote(quote));
		assertFalse(quote.getPremiumType()=="silver");
	}

	@Test
	public void testGetPolicy()throws Exception
	{
		LocalDate d = LocalDate.of(2003, Month.APRIL,12);
		LocalDate d1 = LocalDate.of(2009, Month.APRIL,12);
		Policy p= new Policy(124,"home_insurance",d1,d,6,"expired");
		int id=p.getPolicyId();
		Optional<Policy>optional=por.findById(id);
		if(optional.isPresent())
		{
			when(optional.get()).thenReturn(optional.get());
			assertEquals(optional.get(),phs.viewPolicy(id));
		}
	}


}
