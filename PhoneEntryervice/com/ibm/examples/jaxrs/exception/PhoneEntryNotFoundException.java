package com.ibm.examples.jaxrs.exception;

public class PhoneEntryNotFoundException extends RuntimeException {
   
	public PhoneEntryNotFoundException() {
		
	}
	private static final long serialVersionUID = 1L;
	
	String message;

	public PhoneEntryNotFoundException(String message) {
		super();
		this.message = message;
	}

}
