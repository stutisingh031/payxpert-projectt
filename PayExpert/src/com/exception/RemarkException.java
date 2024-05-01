package com.exception;

public class RemarkException extends Exception {
	private String message;
	public RemarkException(String message) {
		this.message = message;
	}
	private static final long serialVersionUID = -1512778098554305833L;
	public String getMessage() {
		return message;
	}
}
