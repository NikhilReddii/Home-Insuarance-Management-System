package com.cg.hims.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hims.entities.Property;
import com.cg.hims.exceptions.PropertyNotFoundException;
import com.cg.hims.repository.PropertyRepository;
/**
 * 
 * @author Prathmesh
 * class for implementing property service layer interface
 *
 */
@Service
@Transactional
public class PropertyServiceImpl implements PropertyService{
	@Autowired
	private PropertyRepository holderProperty;
	public Property addProperty(Property property) throws PropertyNotFoundException
	{	
		try {			
			return holderProperty.save(property);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PropertyNotFoundException(e.getMessage());
		}
	}

	public Property viewProperty(int id) throws PropertyNotFoundException
	{
		try {
			Optional<Property> optional= holderProperty.findById(id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Property");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PropertyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PropertyNotFoundException(e.getMessage());
		}
	}

	@Override
	public Property updateProperty(Property property) throws PropertyNotFoundException {
		try {			
			return holderProperty.save(property);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PropertyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PropertyNotFoundException(e.getMessage());
		}
	}
}