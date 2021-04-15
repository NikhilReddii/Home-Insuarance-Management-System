package com.cg.hims.service;

import java.util.List;


import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;
/**
 * 
 * @author Rahul
 * interface of Policy in Service layer
 *
 */

public interface PolicyService {

	public Policy addPolicy(Policy policy) throws PolicyNotFoundException;

	public Policy updatePolicy(Policy policy) throws PolicyNotFoundException;

	public Policy viewPolicy(int policy_id) throws PolicyNotFoundException;

	public void removePolicy(int policy_id) throws PolicyNotFoundException;

	public List<Policy> showAllPolicies() throws PolicyNotFoundException;

}
