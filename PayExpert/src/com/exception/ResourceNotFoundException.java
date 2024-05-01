package com.exception;

public class ResourceNotFoundException extends Exception {
	private String message;
	private static final long serialVersionUID = -1512778098554305833L;

	public ResourceNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}