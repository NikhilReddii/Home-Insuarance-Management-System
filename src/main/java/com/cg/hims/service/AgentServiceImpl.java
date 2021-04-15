package com.cg.hims.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
/**
 * 
 * @author Rohith
 * Class for implementing agent service layer
 *
 */


@Service
@Transactional
public class AgentServiceImpl implements AgentService{
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private PolicyHolderRepository ph;
	@Autowired
	private QuoteRepository qr;
	
	@Override
	public Agent addAgent(Agent agent) throws AgentException
	{
		try {			
			return agentRepository.save(agent);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentException(e.getMessage());
		}
		
	}

	@Override
	public Agent updateAgent(Agent agent) throws AgentNotFoundException
	{
		try {
			return agentRepository.save(agent);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}
		
		
		
	}

	@Override
	public void removeAgent(int agentId) throws AgentNotFoundException
	{
		try {
			agentRepository.deleteById(agentId);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}
	}

	@Override
	public Agent findAgentById(int agentId) throws AgentNotFoundException
	{
		try {
			Optional<Agent> optional= agentRepository.findById(agentId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Agentno");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}
	}

//	@Override
//	public List<Agent> viewAllAgents() throws AgentException
//	{
//		try {
//			return agentRepository.findAll();
//		}catch(DataAccessException e) {
//			//converting SQLException to EmployeeException
//			throw new AgentException(e.getMessage());
//		}catch(Exception e) {
//			//converting SQLException to EmployeeException
//			throw new AgentException(e.getMessage());
//		}
//	}
//	
	
//	@Override
//	public PolicyHolder addPolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException {
//		try {			
//			return iPolicyHolderRepository.save(policyHolder);
//		}catch(DataAccessException e) {
//			throw new PolicyHolderNotFoundException(e.getMessage());
//		}catch(Exception e) {
//			throw new PolicyHolderNotFoundException(e.getMessage());
//		}
//	}

//	@Override
//	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException {
//		try {			
//			return iPolicyHolderRepository.save(policyHolder);
//		}catch(DataAccessException e) {
//			throw new PolicyHolderNotFoundException(e.getMessage());
//		}catch(Exception e) {
//			throw new PolicyHolderNotFoundException(e.getMessage());
//		}
//	}

	@Override
	public void deletePolicyHolder(int policyHolderId) throws PolicyHolderNotFoundException {
		try {			
			ph.deleteById(policyHolderId);
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public PolicyHolder getPolicyHolderById(int policyHolderId) throws PolicyHolderNotFoundException {
		try {
			Optional<PolicyHolder> optional=ph.findById(policyHolderId);
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
			return ph.findAll();
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public Quote addQuote(Quote quote) throws QuoteNotFoundException {
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

	@Override
	public String removeQuote(int id) throws QuoteNotFoundException {
		try {
			qr.deleteById(id);
			return "Quote deleted";
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}	}

	@Override
	public List<Quote> showAllQuotes() throws QuoteNotFoundException {
		try {
			return qr.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}
	}
	
}
