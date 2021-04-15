package com.cg.hims.exceptions;

public class PropertyNotFoundException extends Exception{

	public PropertyNotFoundException()
	{
		
	}
	public PropertyNotFoundException(String message)
	{
		super(message);
	}
	@Override
	public String toString() {
		return "PropertyNotFoundException: " + super.getMessage();
	}
	
}
