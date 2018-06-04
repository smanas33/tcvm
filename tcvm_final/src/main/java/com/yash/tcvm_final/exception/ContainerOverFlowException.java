package com.yash.tcvm_final.exception;

public class ContainerOverFlowException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContainerOverFlowException(){
		
	}
	
	public ContainerOverFlowException(String erorMessage){
		super(erorMessage);
	}

}
