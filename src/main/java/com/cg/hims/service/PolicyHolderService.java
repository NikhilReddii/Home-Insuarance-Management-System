package com.cg.hims.service;

import java.util.List;

import com.cg.hims.entities.Policy;

import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Property;
import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.exceptions.PropertyNotFoundException;
import com.cg.hims.exceptions.QuoteNotFoundException;
/**
 * 
 * @author Lakshman
 * interface of Policy Holder in service layer
 *
 */

public interface PolicyHolderService {

	public String addPolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException;

	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException;

	public PolicyHolder viewPolicyHolder(int policy_holder_id) throws PolicyHolderNotFoundException;
	
	public Policy viewPolicy(int policy_id) throws PolicyNotFoundException;
	
	public Property viewProperty(int property_id) throws PropertyNotFoundException;
	
	public Quote viewQuote(int quote_id) throws QuoteNotFoundException;
	
	public Quote updateQuote(Quote quote) throws QuoteNotFoundException;
	
	public Property addProperty(Property property) throws Exception;

	public void removePolicyHolder(int id) throws PolicyHolderNotFoundException;

	public Property updateProperty(Property property) throws PropertyNotFoundException;
	
	public List<PolicyHolder> showAllPolicyHolders() throws PolicyHolderNotFoundException;


}
