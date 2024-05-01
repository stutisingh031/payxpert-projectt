package com.exception;

public class FinancialRecordException extends Exception{
	
private String message; 
	
	public FinancialRecordException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	private static final long serialVersionUID = -7746570533997881519L;

}
