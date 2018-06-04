package com.yash.tcvm_final.builder;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import com.yash.tcvm_final.conf.TeaConfig;
import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.enumeration.DrinkTypeEnum;
import com.yash.tcvm_final.exception.ContainerUnderflowException;
import com.yash.tcvm_final.exception.FileEmptyException;
/**
 * This is a concrete class which builds the Tea
 * 
 * @author sahoo.manas
 *
 */
public class TeaDrinkBuilder extends AbstractDrinkBuilder {
	
	private final static Logger LOGGER = Logger.getLogger(TeaDrinkBuilder.class);
	
	public TeaDrinkBuilder() {
		setDrinkConfigurer(TeaConfig.getDrinkConfigurer());
	}

	@Override
	public void process(Order order) throws ContainerUnderflowException, FileNotFoundException, FileEmptyException {
		LOGGER.info("Building Tea inside process");
		if(order.getDrinkTypeEnum()==DrinkTypeEnum.TEA) {
			super.process(order);
		}else{
			throw new IllegalArgumentException("Wrong Drink Type, required "+DrinkTypeEnum.TEA+" and found "+order.getDrinkTypeEnum());
		}
		LOGGER.info("Tea building completed inside process");
	}
	
	public static DrinkBuilder getDrinkBuilder() {
		return new TeaDrinkBuilder();
	}
}
