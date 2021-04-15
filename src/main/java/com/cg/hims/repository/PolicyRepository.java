package com.cg.hims.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.hims.entities.Policy;
/**
 * 
 * @author Rahul
 * policy enitity repository
 *
 */

public interface PolicyRepository extends JpaRepository<Policy,Integer>{

//	public Policy addPolicy(Policy policy);
//
//	public Policy updatePolicy(Policy policy) throws PolicyNotFoundException;
//
//	public Policy findPolicyById(int policyId) throws PolicyNotFoundException;
//
//	public Policy removePolicy(int policyId) throws PolicyNotFoundException;
//
//	public List<Policy> showAllPolicies();

}
