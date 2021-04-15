package com.cg.hims.exceptions;

public class AgentNotFoundException extends Exception {
	
	public AgentNotFoundException(String message) {
			super(message);
	}


	@Override
	public String toString() {
		return "AgentNotFoundException"+ super.getMessage();
	}
}