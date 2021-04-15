package com.cg.hims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hims.entities.PolicyHolder;
/**
 * 
 * @author Lakshman
 * Policy Holder's Entity repository
 *
 */

public interface PolicyHolderRepository extends JpaRepository<PolicyHolder,Integer> {

//	public PolicyHolder addPolicyHolder(PolicyHolder policyHolder);
//
//	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException;
//
//	public PolicyHolder findPolicyHolderById(int id) throws PolicyHolderNotFoundException;
//
//	public PolicyHolder removePolicyHolder(int id) throws PolicyHolderNotFoundException;
//
//	public List<PolicyHolder> showAllPolicyHolders();
	

}
