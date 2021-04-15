package com.cg.hims.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Manas
 *POJO class of Admin. User column is joined
 *
 */
@Entity
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="admin")
//@DiscriminatorValue(value = "Admin")
public class Admin
{
	@Id
	@Column(name="admin_id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int adminId;
	private String adminName;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
//	@OneToMany(mappedBy = "admin")
//	@JsonIgnore
//	private Set<PolicyHolder> policyholders;
//	@OneToMany(mappedBy="admin")
//	@JsonIgnore
//	private Set<Agent> agents;
////	@OneToMany(mappedBy="admin")
////	private Set<Transactions> transactions;
//	@OneToMany(mappedBy="admin")
//	@JsonIgnore
//	private Set<Policy> policydetails;
	public Admin(int adminId, String adminName, User user) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.user = user;
	}
	public Admin(String string) {
		this.adminName=string;
	}
	
	
	
}