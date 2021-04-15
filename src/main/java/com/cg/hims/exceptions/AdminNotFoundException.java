package com.cg.hims.exceptions;

public class AdminNotFoundException extends Exception{


	public AdminNotFoundException()
	{
		
	}
	public AdminNotFoundException(String message) {
		super(message);
	}
	@Override
	public String toString() {
		return "AdminNotFoundException: " + super.getMessage();
	}

}
