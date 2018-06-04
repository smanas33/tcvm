package com.yash.tcvm_final.exception;

/**
 * This class is a custom Exception class to handle non existing file exceptions
 * 
 * @author sahoo.manas
 * 
 */
public class FileNotExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileNotExistException( ) {
		
	}

	public FileNotExistException(String erorMessage) {
		super(erorMessage);
	}
}
