package com.cg.hims.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.hims.entities.Agent;

/**
 * 
 * @author Rohith
 * Agent entity's repository
 *
 */
public interface AgentRepository extends JpaRepository<Agent,Integer> {

//	public Agent addAgent(Agent agent);
//
//	public Agent updateAgent(Agent agent) throws AgentNotFoundException;
//
//	public Agent removeAgent(int agentId) throws AgentNotFoundException;
//
//	public Agent findAgentById(int agentId) throws AgentNotFoundException;
//
//	public List<Agent> viewAllAgents();

}
