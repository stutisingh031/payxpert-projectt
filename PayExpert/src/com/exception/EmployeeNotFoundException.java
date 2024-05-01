package com.exception;

public class EmployeeNotFoundException  extends Exception{
private String message; 
	
	public EmployeeNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	private static final long serialVersionUID = 106867174289775193L;


}
