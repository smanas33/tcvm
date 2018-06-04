package com.yash.tcvm_final.exception;

/**
 * This class is a custom Exception class to handle file null pointer exceptions
 * 
 * @author sahoo.manas
 * 
 */
public class FileNullPointerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileNullPointerException( ) {
		
	}
	
	public FileNullPointerException(String erorMessage) {
		super(erorMessage);
	}
}
