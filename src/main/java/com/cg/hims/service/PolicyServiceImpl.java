package com.cg.hims.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.repository.PolicyRepository;
/**
 * 
 * @author Rahul
 * class for implementing policy service layer interface
 *
 */


@Service
@Transactional
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository pr;

	@Override
	public Policy addPolicy(Policy policy) throws PolicyNotFoundException {
		try {			
			return pr.save(policy);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public Policy updatePolicy(Policy policy) throws PolicyNotFoundException {
		try {			
			return pr.save(policy);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public Policy viewPolicy(int policy_id) throws PolicyNotFoundException {
		try {
			Optional<Policy> optional= pr.findById(policy_id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid PolicyHolderID");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public void removePolicy(int policyId) throws PolicyNotFoundException {
		try {			
			pr.deleteById(policyId);;
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<Policy> showAllPolicies() throws PolicyNotFoundException {
		try {			
			return pr.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}
	}
	
	
}
