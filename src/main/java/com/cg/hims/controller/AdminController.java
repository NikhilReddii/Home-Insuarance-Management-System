package com.cg.hims.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.hims.entities.Admin;
import com.cg.hims.entities.Agent;
import com.cg.hims.entities.Policy;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.exceptions.AdminNotFoundException;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * @author Manas
 * 
 *
 */

@Api
@RestController

@RequestMapping("/hims/admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
//	@Autowired
//	private RestTemplate restTemplate;
	
	@ApiOperation(value = "Get PolicyHolders",
			response = PolicyHolder.class,
			
			tags = "get-all PolicyHolders",			
			httpMethod = "GET")
	@GetMapping("/policyholders/getallpolicyholders")
	public ResponseEntity<List<PolicyHolder>> getAllPolicyHolders() throws PolicyHolderNotFoundException{
		try {
			List<PolicyHolder> PolicyHolderList = adminService.getAllPolicyHolders();
			return new ResponseEntity<>(PolicyHolderList, HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

//	@PostMapping("/policyholders/addpolicyholder")
//	public ResponseEntity<PolicyHolder> addPolicyHolder(@RequestBody PolicyHolder pHolder) throws PolicyHolderNotFoundException {
//		try {
//			PolicyHolder policyHolder=adminService.addPolicyHolder(pHolder);
//			return new ResponseEntity<>(policyHolder, HttpStatus.OK);
//		}catch(PolicyHolderNotFoundException e) {
//			throw new PolicyHolderNotFoundException(e.getMessage());
//		}catch(ResponseStatusException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}catch(Exception e) {
//			throw e;
//		}
//	}

	@ApiOperation(value = "Update PolicyHolder",
			response = PolicyHolder.class,
			consumes = "PolicyHolder Object",
			tags = "update-policyHolder record-by admin",
			httpMethod = "PUT")
	@PutMapping("/policyholders/updatepolicyholder")
	public ResponseEntity<PolicyHolder> updatePolicyHolder(@RequestBody PolicyHolder pHolder) throws PolicyHolderNotFoundException {
		try {
			PolicyHolder policyHolder=adminService.updatePolicyHolder(pHolder);
			return new ResponseEntity<>(policyHolder, HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@ApiOperation(value = "Get PolicyHolder",
			response = PolicyHolder.class,
			consumes = "policyHolderId",
			tags = "get-policyHolder by Id",			
			httpMethod = "GET")
	@GetMapping("/policyholders/getpolicyholderbyid/{policyHolderId}")
	public ResponseEntity<PolicyHolder> getPolicyHolderById(@PathVariable Integer policyHolderId) throws PolicyHolderNotFoundException
	{
		try {
			PolicyHolder policyHolder=adminService.getPolicyHolderById(policyHolderId);
			return new ResponseEntity<>(policyHolder, HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@ApiOperation(value = "Delete PolicyHolder",
			response = String.class,
			consumes = "policyHolderId",
			tags = "delete-policyHolder record",
			httpMethod = "DELETE")
	@DeleteMapping("/policyholders/deletepolicyholder/{policyHolderId}")
	public ResponseEntity<String> deletePolicyHolder(@PathVariable Integer policyHolderId) throws PolicyHolderNotFoundException
	{
		try {
			adminService.deletePolicyHolder(policyHolderId);
			return new ResponseEntity<>("PolicyHolder Deleted", HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//	@GetMapping("/transactions/getalltransactions")
	//	public ResponseEntity<List<Transactions>> getAllTransactions() throws TransactionNotFoundException
	//	{
	//		try {
	//			List<Transactions> Tlist = adminService.getAllTransactions();
	//			return new ResponseEntity<>(Tlist,HttpStatus.OK);
	//		}catch(TransactionNotFoundException e) {
	//			throw new TransactionNotFoundException(e.getMessage());
	//		}catch(ResponseStatusException e) {
	//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	//		}catch(Exception e) {
	//			throw e;
	//		}
	//	}
	//	
	//	@GetMapping("/transactions/getalltransactionsbypolicyholderid/{policyHolderId}")
	//	public ResponseEntity<List<Transactions>> getAllTransactionsByPolicyHolderId(@PathVariable Integer policyHolderId) throws TransactionNotFoundException
	//	{
	//		try {
	//			List<Transactions> Tlist = adminService.getAllTransactionsByPolicyHolderId(policyHolderId);
	//			return new ResponseEntity<>(Tlist,HttpStatus.OK);
	//		}catch(TransactionNotFoundException e) {
	//			throw new TransactionNotFoundException(e.getMessage());
	//		}catch(ResponseStatusException e) {
	//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	//		}catch(Exception e) {
	//			throw e;
	//		}
	//	}
	//	
	//	@GetMapping("/transactions/getalltransactionsbypolicyid/{policyId}")
	//	public ResponseEntity<List<Transactions>> getAllTransactionsByPolicyId(@PathVariable Integer policyId) throws TransactionNotFoundException
	//	{
	//		try {
	//			List<Transactions> Tlist = adminService.getAllTransactionsByPolicyId(policyId);
	//			return new ResponseEntity<>(Tlist,HttpStatus.OK);
	//		}catch(TransactionNotFoundException e) {
	//			throw new TransactionNotFoundException(e.getMessage());
	//		}catch(ResponseStatusException e) {
	//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	//		}catch(Exception e) {
	//			throw e;
	//		}
	//	}

	@ApiOperation(value = "Get Policies",
			response = Policy.class,
		
			tags = "get-all policies",			
			httpMethod = "GET")
	@GetMapping("/policy/getallpolicies")
	public ResponseEntity<List<Policy>> getAllPolicies() throws PolicyNotFoundException
	{
		try {
			List<Policy> Plist=adminService.getAllPolicies();
			return new ResponseEntity<List<Policy>>(Plist,HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new PolicyNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@ApiOperation(value = "Get Policy",
			response = Policy.class,
			consumes = "policyId",
			tags = "get-policy by Id",			
			httpMethod = "GET")
	@GetMapping("/policy/getpolicybyid/{policyId}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable Integer policyId) throws PolicyNotFoundException
	{
		try {
			Policy policy=adminService.getPolicyById(policyId);
			return new ResponseEntity<>(policy,HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new PolicyNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Add Policy",
			response = Policy.class,
			consumes = "Policy Object",
			tags = "post-policy record",
			httpMethod = "POST")
	@PostMapping("/policy/addpolicy")
	public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy) throws PolicyNotFoundException {
		try {
			Policy plcy=adminService.addPolicy(policy);
			return new ResponseEntity<>(plcy, HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new PolicyNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@ApiOperation(value = "Update Policy",
			response = Policy.class,
			consumes = "Policy Object",
			tags = "update-Policy record",
			httpMethod = "PUT")
	@PutMapping("/policy/updatepolicy")
	public ResponseEntity<Policy> updatePolicy(@RequestBody Policy policy) throws PolicyNotFoundException {
		try {
			Policy plcy=adminService.updatePolicy(policy);
			return new ResponseEntity<>(plcy, HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new PolicyNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@ApiOperation(value = "Delete Policy",
			response = String.class,
			consumes = "policyId",
			tags = "delete-policy record",
			httpMethod = "DELETE")
	@DeleteMapping("/policy/deletepolicy/{policyId}")
	public ResponseEntity<String> deletePolicy(@PathVariable Integer policyId) throws PolicyNotFoundException
	{
		try {
			adminService.deletePolicy(policyId);
			return new ResponseEntity<>("Policy Deleted",HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new PolicyNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@ApiOperation(value = "Get Admins",
			response = Admin.class,
			
			tags = "get-all admins",			
			httpMethod = "GET")
	@GetMapping("/getalladmins")
	public ResponseEntity<List<Admin>> getAllAdmins() throws AdminNotFoundException
	{
		try {
			List<Admin> Alist=adminService.getAllAdmins();
			return new ResponseEntity<>(Alist,HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new AdminNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@ApiOperation(value = "Get Admin",
			response = Admin.class,
			consumes = "adminId",
			tags = "get-admin by Id",			
			httpMethod = "GET")
	@GetMapping("/getadminbyid/{adminId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Integer adminId) throws AdminNotFoundException
	{
		try {
			Admin Adn=adminService.getAdminById(adminId);
			return new ResponseEntity<>(Adn,HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new AdminNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

//	@PostMapping("/addadmin")
//	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws AdminNotFoundException {
//		try {
//			Admin Adn=adminService.addAdmin(admin);
//			return new ResponseEntity<>(Adn, HttpStatus.OK);
//		}catch(AdminNotFoundException e) {
//			throw new AdminNotFoundException(e.getMessage());
//		}catch(ResponseStatusException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}catch(Exception e) {	
//			throw e;
//		}
//	}

	@ApiOperation(value = "Update Admin",
			response = Admin.class,
			consumes = "Admin Object",
			tags = "update-admin record",
			httpMethod = "PUT")
	@PutMapping("/updateadmin")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) throws AdminNotFoundException {
		try {
			Admin Adn=adminService.updateAdmin(admin);
			return new ResponseEntity<>(Adn, HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new AdminNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@ApiOperation(value = "Delete Admin",
			response = String.class,
			consumes = "adminId",
			tags = "delete-admin record",
			httpMethod = "DELETE")
	@DeleteMapping("/deleteadmin/{adminId}")
	public ResponseEntity<String> deleteAdmin(@PathVariable Integer adminId) throws AdminNotFoundException
	{
		try {
			adminService.deleteAdmin(adminId);
			return new ResponseEntity<>("Admin Deleted",HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new AdminNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@ApiOperation(value = "Get Agents",
			response = Agent.class,
			
			tags = "get-all agents",			
			httpMethod = "GET")
	@GetMapping("/agent/getallagents")
	public ResponseEntity<List<Agent>> getAllAgents() throws AgentException
	{
		try {
			List<Agent> Alist=adminService.getAllAgents();
			return new ResponseEntity<List<Agent>>(Alist,HttpStatus.OK);
		}catch(AgentException e) {
			throw new AgentException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@ApiOperation(value = "Get Agent",
			response = Agent.class,
			consumes = "agent_id",
			tags = "get-agent by Id",			
			httpMethod = "GET")
	@GetMapping("/agent/getagentbyid/{agentId}")
	public ResponseEntity<Agent> getAgentById(@PathVariable Integer agentId) throws AgentNotFoundException
	{
		try {
			Agent agn=adminService.getAgentById(agentId);
			return new ResponseEntity<Agent>(agn,HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new AgentNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

//	@PostMapping("/agent/addagent")
//	public ResponseEntity<Agent> addAgent(@RequestBody Agent agent) throws AgentNotFoundException
//	{
//		try {
//			Agent agn=adminService.addAgent(agent);
//			return new ResponseEntity<>(agn,HttpStatus.OK);
//		}catch(AgentNotFoundException e) {
//			throw new AgentNotFoundException(e.getMessage());
//		}catch(ResponseStatusException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}catch(Exception e) {
//			throw e;
//		}
//	}

	@ApiOperation(value = "Update Agent",
			response = Agent.class,
			consumes = "Agent Object",
			tags = "update-agent record-by admin",
			httpMethod = "PUT")
	@PutMapping("/agent/updateagent")
	public ResponseEntity<Agent> updateAgent(@RequestBody Agent agent) throws AgentNotFoundException
	{
		try {
			Agent agn=adminService.updateAgent(agent);
			return new ResponseEntity<>(agn,HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new AgentNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@ApiOperation(value = "Delete Agent",
			response = String.class,
			consumes = "agent_id",
			tags = "delete-agent record",
			httpMethod = "DELETE")
	@DeleteMapping("/agent/deleteagent/{agentId}")
	public ResponseEntity<String> deleteAgent(@PathVariable Integer agentId) throws AgentNotFoundException
	{
		try {
			adminService.deleteAgent(agentId);
			return new ResponseEntity<>("Agent Deleted",HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new AgentNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
