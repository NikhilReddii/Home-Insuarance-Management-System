package com.cg.hims.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.hims.entities.Property;
/**
 * 
 * @author Prathmesh
 * Property entity repository
 *
 */

public interface PropertyRepository extends JpaRepository<Property,Integer> {
//
//	public Property addProperty(Property property);
//
//	public Property viewProperty();

}
