package com.yash.tcvm_final.exception;

public class NegativeOrderException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NegativeOrderException() {
		
	}

	public NegativeOrderException(String erorMessage) {
		super(erorMessage);
	}

}
