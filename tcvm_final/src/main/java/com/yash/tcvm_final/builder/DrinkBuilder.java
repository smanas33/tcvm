package com.yash.tcvm_final.builder;

import java.io.FileNotFoundException;

import com.yash.tcvm_final.conf.IDrinkConfigurer;
import com.yash.tcvm_final.domain.Container;
import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.exception.ContainerUnderflowException;
import com.yash.tcvm_final.exception.FileEmptyException;

public interface DrinkBuilder {
	
	void setDrinkConfigurer(IDrinkConfigurer drinkConfigurer);
	void process(Order order) throws ContainerUnderflowException, FileNotFoundException, FileEmptyException;
	void updateContainer();
	
	Container getContainer();
	
	// some other builder methods will go here like
	// checkUnderflow(Order order), updateReportTracker(Order order), updateContainer() etc.

}
