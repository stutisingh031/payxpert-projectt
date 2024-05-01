package com.exception;


public class ResourceNotFoundException extends Exception {
	

private String message; 
	
	public ResourceNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	private static final long serialVersionUID = 2976458660109929224L;


}
