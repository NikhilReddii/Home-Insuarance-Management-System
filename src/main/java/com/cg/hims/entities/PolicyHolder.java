package com.cg.hims.entities;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Lakshman
 * POJO Class of PolicyHolder. User,Agent,Quote,Policy,Property columns are joined.
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="policyholder")
public class PolicyHolder {
     @Id
//     @Length(max=10)
     @Column(name="policy_holder_id")
	private int policyHolderId;
     
     @Column(name="policy_holder_name")
//     @Length(max=25)
//     @NotBlank(message="Name caanot be blank")
	private String policyHolderName;
     
     @Column(name="credit_card")
//     @Length(max=20)
	private String creditCard;
     
//     @Length(max=20)
//     @NotBlank(message="DOB cannot be empty")
	private LocalDate dob;
     
//     @Length(max=20)
	private String occupation;
     
	@Column(name="annual_income")
//	@Length(max=20)
	private double annualIncome;
	
	@Column(name="is_retired")
//	@Length(max=10)
	private boolean isRetired;
	
	@Column(name="residence_type")
//	@Length(max=20)
//	@NotBlank(message="Residence type cannot be empty")
	private String residenceType;
	
//	@Length(max=20)
	private String city;
	
//	@Length(max=20)
	private String state;
	
//	@Length(max=10)
	private long zip;
	
	@Column(name="residence_use")
//	@Length(max=20)
//	@NotBlank(message="Residence use cannot be empty")
	private String  residenceUse;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
//	@Length(max=10)
	private User user;
	
	@ManyToOne(cascade= CascadeType.ALL)
//	@JsonIgnore
	@JoinColumn(name="agent_id")
	private Agent agent;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="quote_id")
	private Quote quote;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="property_id")
	private Property property;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="policy_id")
	private Policy policy;

	public PolicyHolder(int policyHolderId, String policyHolderName, User user) {
		super();
		this.policyHolderId = policyHolderId;
		this.policyHolderName = policyHolderName;
		this.user = user;
	}
	
	
}
