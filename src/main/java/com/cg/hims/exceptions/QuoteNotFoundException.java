package com.cg.hims.exceptions;

public class QuoteNotFoundException extends Exception {

	public QuoteNotFoundException()
	{
		
	}
	public QuoteNotFoundException(String message) {
		super(message);
	}
	@Override
	public String toString() {
		return "QuoteNotFoundException " + super.toString();
	}
	

}