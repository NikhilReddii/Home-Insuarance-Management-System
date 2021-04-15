package com.cg.hims.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * @author Prathmesh
 * POJO class of Property
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name="Property")
public class Property implements Serializable {
	@Id
	@Column(name="property_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int propertyId;
	@Column(name="market_value")
	private long marketValue;
	@Column(name="year_built")
	private int yearBuilt;
	@Column(name="square_footage")
	private int squareFootage;
	@Column(name="has_swimming_pool")
	private boolean hasSwimmingPool;

	
	
	
	
	
	
	
}
