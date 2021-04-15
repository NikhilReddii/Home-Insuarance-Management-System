package com.cg.hims.test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.hims.application.HomeInsuranceManagementSystemApplication;
import com.cg.hims.entities.Agent;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.QuoteNotFoundException;
import com.cg.hims.repository.AgentRepository;
import com.cg.hims.repository.PolicyHolderRepository;
import com.cg.hims.repository.QuoteRepository;
import com.cg.hims.service.AgentService;

@SpringBootTest(classes = HomeInsuranceManagementSystemApplication.class)
public class AgentTest 
{

	@Autowired
	private AgentService agentService;
	@MockBean
	private AgentRepository agentRepository;
	@MockBean
	private QuoteRepository quoteRepository;
     @MockBean
     private PolicyHolderRepository policyholderRepository;
     
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

	/*
	 * check add agent
	 */
	@Test
	public void testAddAgent() throws  AgentNotFoundException, AgentException{
	   Agent agent= new Agent(5,"harsha","salesagent",68000.00);
		when(agentRepository.save(agent)).thenReturn(agent);
		assertEquals(agent,agentService.addAgent(agent));
	}


	/*
	 * check update agent
	 */
	@Test
	public void testUpdateAgent() throws AgentNotFoundException {
		Agent agent= new Agent(5,"harsha","salesagent",68000.00);
		agent.setDesignation("Agent");
		when(agentRepository.save(agent)).thenReturn(agent);
		assertEquals(agent,agentService.updateAgent(agent));
	}
	
	/*
	 * check delete agent
	 */
	@Test
	public void testDeleteAgent() throws AgentNotFoundException, AgentException {
		 Agent agent= new Agent(5,"harsha","salesagent",68000.00);
		 int id=agent.getAgentId();
	agentService.removeAgent(id);
	verify(agentRepository,times(1)).deleteById(id);
	
	}
	
	@Test
	public void testAddQuote() throws Exception{
		Quote quote = new Quote(444,"platinum",5000.00,6000.00,7000.00,8000.00,9000.00,10000.00,11000.00);
		when(quoteRepository.save(quote)).thenReturn(quote);
		assertEquals(quote,agentService.addQuote(quote));
	}
	
	@Test
	public void testUpdateQuote() throws QuoteNotFoundException {
		Quote quote = new Quote(444,"platinum",5000.00,6000.00,7000.00,8000.00,9000.00,10000.00,11000.00);
		quote.setPremiumAmount(10000);
		when(quoteRepository.save(quote)).thenReturn(quote);
		assertEquals(quote,agentService.updateQuote(quote));
	}

	@Test
	public void testDeleteQuote() throws QuoteNotFoundException {
		Quote quote = new Quote(444,"platinum",5000.00,6000.00,7000.00,8000.00,9000.00,10000.00,11000.00);
		
		int id=quote.getQuoteId();
		
		agentService.removeQuote(id);
		
		verify(quoteRepository,times(1)).deleteById(id);
	}
	@Test
	public void testDeletePolicyHolder() throws PolicyHolderNotFoundException,Exception {
		PolicyHolder ph = addPh();
		int id=ph.getPolicyHolderId();
	        agentService.deletePolicyHolder(id);
		verify(policyholderRepository,times(1)).deleteById(id);
	}
}
	
	
	
	
