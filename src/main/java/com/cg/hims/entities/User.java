package com.cg.hims.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author Nikhil
 * POJO Class of Users.
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="users")
public class User{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	public int userId;
	@Column(name="user_name")
	public String userName;
	public String password;
	@Column(name="first_name")
	public String firstName;
	@Column(name="last_name")
	public String lastName;
	@Column(name="email_id")
	public String emailId;
	@Column(name="contact_no")
	public long contactNo;
	public String address;
	public String userRole;
	@OneToOne(mappedBy= "user")
	@JsonIgnore
	private Admin admin;
	
	@OneToOne(mappedBy="user")
	@JsonIgnore
	private Agent agent;
	
	@OneToOne(mappedBy="user")
	@JsonIgnore
	private PolicyHolder policyHolder;
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//////	

	public User(int userId, String userName, String password, String firstName, String lastName, String emailId,
			long contactNo, String address, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.address = address;
		this.userRole = userRole;
	}


	
	

	

}
