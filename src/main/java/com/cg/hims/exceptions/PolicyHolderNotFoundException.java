package com.cg.hims.exceptions;

public class PolicyHolderNotFoundException extends Exception {

	public PolicyHolderNotFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "PolicyHolderNotFoundException: " + super.toString();
	}

	
}
