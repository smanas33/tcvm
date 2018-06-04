package com.yash.tcvm_final.exception;

public class ContainerUnderflowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContainerUnderflowException(){
		
	}
	
	public ContainerUnderflowException(String erorMessage){
		super(erorMessage);
		
	}
}
