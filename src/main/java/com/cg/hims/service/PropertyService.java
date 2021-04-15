package com.cg.hims.service;

import com.cg.hims.entities.Property;
import com.cg.hims.exceptions.PropertyNotFoundException;

/**
 * 
 * @author Prathmesh
 * interfaceof property in service layer
 *
 */
public interface PropertyService {

	public Property addProperty(Property property) throws PropertyNotFoundException;

	public Property viewProperty(int id) throws PropertyNotFoundException;
	
	public Property updateProperty(Property property) throws PropertyNotFoundException;

}