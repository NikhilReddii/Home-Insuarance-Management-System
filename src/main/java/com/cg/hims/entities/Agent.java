package com.cg.hims.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * @author Rohith
 * Pojo Class of agent. User column is joined.
 *
 */
@Entity
@Table(name = "Agent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Agent {
	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="agent_Id")
	private int agentId;
	@Column(name="agent_name")
	private String agentName;
	private String designation;
	private double salary; 
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	@OneToMany(mappedBy="agent")
	@JsonIgnore
	private Set<PolicyHolder> policyHoldersList;
	@OneToMany(mappedBy = "agent")
	@JsonIgnore
    private List<Quote> quoteList;
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
//	private Admin admin;
	public Agent(int agentId, String agentName, User user) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.user = user;
	}
	public Agent(int agentId, String agentName, String designation, Double salary) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.designation = designation;
		this.salary = salary;
	}
	
}