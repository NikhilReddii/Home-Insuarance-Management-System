package com.cg.hims.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.hims.entities.Policy;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Property;
import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.exceptions.PropertyNotFoundException;
import com.cg.hims.exceptions.QuoteNotFoundException;
import com.cg.hims.repository.PolicyHolderRepository;
import com.cg.hims.repository.PolicyRepository;
import com.cg.hims.repository.PropertyRepository;
import com.cg.hims.repository.QuoteRepository;
/**
 * 
 * @author Lakshman
 * Class for implementing Policy Holder service layer interface
 *
 */

@Service
@org.springframework.transaction.annotation.Transactional
public class PolicyHolderServiceImpl implements PolicyHolderService {

	@Autowired
	private PolicyHolderRepository ph;
	@Autowired
	private PolicyRepository pr;
	@Autowired
	private QuoteRepository qr;
	@Autowired
	private PropertyRepository holderProperty;

	@Override
	public String addPolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException{
		try {			
			 ph.save(policyHolder);
			 return "PolicyHolder added to database";
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException {
		try {			
			  return ph.save(policyHolder);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public PolicyHolder viewPolicyHolder(int policy_holder_id) throws PolicyHolderNotFoundException {
		
		try {
			Optional<PolicyHolder> optional= ph.findById(policy_holder_id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid PolicyHolderId");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}
	
	@Override
	public Policy viewPolicy(int policy_id) throws PolicyNotFoundException {
		try {
		Optional<Policy> optional= pr.findById(policy_id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new Exception("Invalid PolicyID");
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
	public Quote viewQuote(int quote_id) throws QuoteNotFoundException {
		try {
			Optional<Quote> optional= qr.findById(quote_id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid PolicyHolderID");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}
	}
	
	public Property viewProperty(int property_id) throws PropertyNotFoundException
	{
		try {
			Optional<Property> optional= holderProperty.findById(property_id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Property");
			}
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PropertyNotFoundException(e.getMessage());
		}
	}


	@Override
	public Quote updateQuote(Quote quote) throws QuoteNotFoundException {
		try {			
			  return qr.save(quote);
			  
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}
	}


	@Override
	public Property addProperty(Property property) throws Exception
	{	
		try {			
			return holderProperty.save(property);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public Property updateProperty(Property property) throws PropertyNotFoundException {
		try {			
			return holderProperty.save(property);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PropertyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PropertyNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<PolicyHolder> showAllPolicyHolders() throws PolicyHolderNotFoundException{
		try {
			return ph.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public void removePolicyHolder(int id) throws PolicyHolderNotFoundException {
		try {
			ph.deleteById(id);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
		
	}

	
	
}
