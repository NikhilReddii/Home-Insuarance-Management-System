package com.cg.hims.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author JayaPriyadarshini,Jadhav
 * POJO Class of Quote. Agent column is joined.
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
@Table(name="Quote")
public class Quote implements Serializable {
	@Id
	@Column(name="quote_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int quoteId;
	@Column(name="premium_type")
	private String premiumType;
	@Column(name="premium_amount")
	private double premiumAmount;
	@Column(name="dwelling_coverage")
	private double dwellingCoverage;
	@Column(name="detached_structured_coverage")
	private double detachedStructureCoverage;
	@Column(name="personal_property_coverage")
	private double personalPropertyCoverage;
	@Column(name="additional_living_expense")
	private double additionalLivingExpense;
	@Column(name="medical_expense")
	private double medicalExpense;
	@Column(name="deducible_amount")
	private double deducibleAmount;
	//	@OneToMany(mappedBy="Quote")
	//	private List<Transactions> TransactionsList;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="agent_id")
	@JsonIgnore
	private Agent agent;
	public Quote(int quoteId, String premiumType, double premiumAmount, double dwellingCoverage,
			double detachedStructureCoverage, double personalPropertyCoverage, double additionalLivingExpense,
			double medicalExpense, double deducibleAmount) {
		super();
		this.quoteId = quoteId;
		this.premiumType = premiumType;
		this.premiumAmount = premiumAmount;
		this.dwellingCoverage = dwellingCoverage;
		this.detachedStructureCoverage = detachedStructureCoverage;
		this.personalPropertyCoverage = personalPropertyCoverage;
		this.additionalLivingExpense = additionalLivingExpense;
		this.medicalExpense = medicalExpense;
		this.deducibleAmount = deducibleAmount;
	}
	
	
}






