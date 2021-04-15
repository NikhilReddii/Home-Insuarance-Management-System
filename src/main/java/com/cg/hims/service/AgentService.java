package com.cg.hims.service;

import java.util.List;


import com.cg.hims.entities.Agent;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.QuoteNotFoundException;
/**
 * 
 * @author Rohith
 * Interface of agent in service layer
 *
 */

public interface AgentService {

	public Agent addAgent(Agent agent) throws AgentException;

	public Agent updateAgent(Agent agent) throws AgentNotFoundException;

	public void removeAgent(int agentId) throws AgentNotFoundException;

	public Agent findAgentById(int agentId) throws AgentNotFoundException;

	//public List<Agent> viewAllAgents()throws AgentException;

	//PolicyHolder addPolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException;
	//PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException;
	public void deletePolicyHolder(int policyHolderId) throws PolicyHolderNotFoundException;
	
	PolicyHolder getPolicyHolderById(int policyHolderId) throws PolicyHolderNotFoundException;
	
	List<PolicyHolder> getAllPolicyHolders() throws PolicyHolderNotFoundException;

	public Quote addQuote(Quote quote) throws QuoteNotFoundException;

	public Quote updateQuote(Quote quote) throws QuoteNotFoundException;

	public Quote viewQuote(int id) throws QuoteNotFoundException;

	public String removeQuote(int id) throws QuoteNotFoundException;

	public List<Quote> showAllQuotes() throws QuoteNotFoundException;
}
