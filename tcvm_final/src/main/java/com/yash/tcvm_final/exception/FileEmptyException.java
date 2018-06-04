package com.yash.tcvm_final.exception;

/**
 * This class is a custom Exception class to handle empty file exceptions
 * 
 * @author sahoo.manas
 * 
 */
public class FileEmptyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileEmptyException() {
		
	}

	public FileEmptyException(String erorMessage) {
		super(erorMessage);
	}
}
