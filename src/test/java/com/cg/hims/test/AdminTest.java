package com.cg.hims.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hims.application.HomeInsuranceManagementSystemApplication;
import com.cg.hims.entities.Admin;
import com.cg.hims.entities.Agent;
import com.cg.hims.entities.Policy;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.exceptions.AdminNotFoundException;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.repository.AdminRepository;
import com.cg.hims.repository.AgentRepository;
import com.cg.hims.repository.PolicyHolderRepository;
import com.cg.hims.repository.PolicyRepository;
import com.cg.hims.service.AdminService;


@SpringBootTest(classes = HomeInsuranceManagementSystemApplication.class)
public class AdminTest {

	@Autowired
	private AdminService adminService;
	@MockBean
	private AdminRepository adminrepository;
	@MockBean
	private AgentRepository agentrepository;
	@MockBean
	private PolicyRepository pol;
	@MockBean
	private PolicyHolderRepository phr;
	LocalDate d = LocalDate.of(2023, Month.JULY, 12);
	LocalDate d1 = LocalDate.of(2020, Month.JULY, 12);
	Policy policy = new Policy("Home_Insurance",d,d1,2,"Active");
	Admin ad = new Admin("Jegan");
	public Agent addAgent() {
		Agent agent = new Agent();
		agent.setAgentId(5);
		agent.setAgentName("Harsha");
		agent.setDesignation("Sales Agent");;
		agent.setSalary(200000.0);
		return agent;
	}
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
	@Test
	public void testAddPolicy() throws PolicyNotFoundException {
		Policy p = policy;
		when(pol.save(p)).thenReturn(p);
		assertEquals(p,adminService.addPolicy(p));
	}

	@Test
	public void testUpdatePolicy() throws PolicyNotFoundException {
		Policy ph = policy;
		ph.setPolicyStatus("Closed");
		when(pol.save(ph)).thenReturn(ph);
		assertEquals(ph,adminService.updatePolicy(ph));
	}

	@Test
	public void testDeletePolicy() throws PolicyNotFoundException  {
		Policy ph = policy;
		int id=ph.getPolicyId();
		adminService.deletePolicy(id);
		verify(pol,times(1)).deleteById(id);	
	}

	/*
	 * check update agent
	 */
	@Test
	public void testUpdateAdmin() throws AdminNotFoundException {
		Admin admin = ad;
		admin.setAdminName("Jagan");
		when(adminrepository.save(admin)).thenReturn(admin);
		assertEquals(admin,adminService.updateAdmin(admin));
	}

	/*
	 * check delete agent
	 */
	@Test
	public void testDeleteAgent() throws   AdminNotFoundException {
		Agent agent = addAgent();
		int id=agent.getAgentId();
		adminService.deleteAdmin(id);
		verify(adminrepository,times(1)).deleteById(id);

	}

	@Test
	public void testDeletePolicyHolder() throws PolicyHolderNotFoundException {
		PolicyHolder ph = addPh();
		int id=ph.getPolicyHolderId();
		adminService.deletePolicyHolder(id);
		verify(phr,times(1)).deleteById(id);
	}
}
