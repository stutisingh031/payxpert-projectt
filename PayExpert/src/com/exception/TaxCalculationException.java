package com.exceptions;

public class TaxCalculationException extends Exception{
private String message; 
	
	public TaxCalculationException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	private static final long serialVersionUID = 106867174289775193L;


}
