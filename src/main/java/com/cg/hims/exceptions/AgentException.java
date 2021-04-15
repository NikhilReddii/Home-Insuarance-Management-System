package com.cg.hims.exceptions;

public class AgentException extends Exception{
	public AgentException(String message) {
			super(message);
	}


	@Override
	public String toString() {
		return "AgentException" + super.getMessage();
	}
}
