package com.cg.hims.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.hims.entities.Agent;
import com.cg.hims.entities.Policy;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Admin;
import com.cg.hims.exceptions.AdminNotFoundException;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.repository.AdminRepository;
import com.cg.hims.repository.AgentRepository;
import com.cg.hims.repository.PolicyHolderRepository;
import com.cg.hims.repository.PolicyRepository;
/**
 * 
 * @author Manas
 * Class for implementing Admin service layer interface
 *
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private PolicyHolderRepository policyHolderRepository;
//	@Autowired
//	private TransactionRepository transactionRepository;
	@Autowired
	private PolicyRepository policyRepository;
	@Autowired
	private AdminRepository adminRepository;
	
	
	@Override
	public Agent addAgent(Agent agent) throws AgentException 
	{
		try {			
			return agentRepository.save(agent);
		}catch(DataAccessException e) {
			throw new AgentException(e.getMessage());
		}catch(Exception e) {
			throw new AgentException(e.getMessage());
		}
	}

	@Override
	public Agent updateAgent(Agent agent) throws AgentNotFoundException {
		try {			
			return agentRepository.save(agent);
		}catch(DataAccessException e) {
			throw new AgentNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new AgentNotFoundException(e.getMessage());
		}
	}

	@Override
	public void deleteAgent(int agentId) throws AgentNotFoundException {
		try {			
			agentRepository.deleteById(agentId);
		}catch(DataAccessException e) {
			throw new AgentNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new AgentNotFoundException(e.getMessage());
		}
	}

	@Override
	public Agent getAgentById(int agentId) throws AgentNotFoundException {
		try {			
			Optional<Agent> optional=agentRepository.findById(agentId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Agent Id");
			}
		}catch(DataAccessException e) {
			throw new AgentNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new AgentNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<Agent> getAllAgents() throws AgentException 
	{
		try {			
			return agentRepository.findAll();
		}catch(DataAccessException e) {
			throw new AgentException(e.getMessage());
		}catch(Exception e) {
			throw new AgentException(e.getMessage());
		}
	}

	@Override
	public PolicyHolder addPolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException {
		try {			
			return policyHolderRepository.save(policyHolder);
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException {
		try {			
			return policyHolderRepository.save(policyHolder);
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public void deletePolicyHolder(int policyHolderId) throws PolicyHolderNotFoundException {
		try {			
			policyHolderRepository.deleteById(policyHolderId);
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public PolicyHolder getPolicyHolderById(int policyHolderId) throws PolicyHolderNotFoundException {
		try {
			Optional<PolicyHolder> optional=policyHolderRepository.findById(policyHolderId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid PolicyHolder Id");
			}
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<PolicyHolder> getAllPolicyHolders() throws PolicyHolderNotFoundException {
		try {			
			return policyHolderRepository.findAll();
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

//	@Override
//	public List<Transactions> getAllTransactions() throws TransactionNotFoundException {
//		try {	
//			return transactionRepository.findAll();
//		}catch(DataAccessException e) {
//			throw new TransactionNotFoundException(e.getMessage());
//		}catch(Exception e) {
//			throw new TransactionNotFoundException(e.getMessage());
//		}
//	}
//
//	@Override
//	public List<Transactions> getAllTransactionsByPolicyHolderId(Integer policyHolderId) throws TransactionNotFoundException {
//		try {			
//			List<Transactions> Tlist=transactionRepository.findAll().stream().filter(e->e.getPolicyHolderId()==policyHolderId).collect(Collectors.toList());
//			return Tlist;
//		}catch(DataAccessException e) {
//			throw new TransactionNotFoundException(e.getMessage());
//		}catch(Exception e) {
//			throw new TransactionNotFoundException(e.getMessage());
//		}
//	}
//
//	@Override
//	public List<Transactions> getAllTransactionsByPolicyId(Integer policyId) throws TransactionNotFoundException {
//		try {			
//			List<Transactions> Tlist=transactionRepository.findAll().stream().filter(e->e.getPolicyId()==policyId).collect(Collectors.toList());
//			return Tlist;
//		}catch(DataAccessException e) {
//			throw new TransactionNotFoundException(e.getMessage());
//		}catch(Exception e) {
//			throw new TransactionNotFoundException(e.getMessage());
//		}
//	}

	@Override
	public Policy addPolicy(Policy policy) throws PolicyNotFoundException {
		try {			
			return policyRepository.save(policy);
		}catch(DataAccessException e) {
			
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public Policy updatePolicy(Policy policy) throws PolicyNotFoundException {
		try {			
			return policyRepository.save(policy);
		}catch(DataAccessException e) {
			
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public void deletePolicy(int policyId) throws PolicyNotFoundException {
		try {
			policyRepository.deleteById(policyId);
		}catch(DataAccessException e) {
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public Policy getPolicyById(int policyId) throws PolicyNotFoundException {
		try {
			Optional<Policy> optional= policyRepository.findById(policyId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new PolicyNotFoundException("Invalid Policy Id");
			}
		}catch(DataAccessException e) {
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<Policy> getAllPolicies() throws PolicyNotFoundException {
		try {
			return policyRepository.findAll();
		}catch(DataAccessException e) {
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyNotFoundException(e.getMessage());
		}
		}

//	@Override
//	public Admin addAdmin(Admin admin) throws AdminNotFoundException {
//		try {			
//			return adminRepository.save(admin);
//		}catch(DataAccessException e) {
//			
//			throw new AdminNotFoundException(e.getMessage());
//		}catch(Exception e) {
//			
//			throw new AdminNotFoundException(e.getMessage());
//		}
//	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException {
		try {			
			return adminRepository.save(admin);
		}catch(DataAccessException e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}
	}

	@Override
	public void deleteAdmin(int adminId) throws AdminNotFoundException {
		try {
			adminRepository.deleteById(adminId);
		}catch(DataAccessException e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}
		
	}

	@Override
	public Admin getAdminById(int adminId) throws AdminNotFoundException {
		try {
			Optional<Admin> optional= adminRepository.findById(adminId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new PolicyNotFoundException("Invalid Admin Id");
			}
		}catch(DataAccessException e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<Admin> getAllAdmins() throws AdminNotFoundException {
		try {
			return adminRepository.findAll();
		}catch(DataAccessException e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}
	}
}


