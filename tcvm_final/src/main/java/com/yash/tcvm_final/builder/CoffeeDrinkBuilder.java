package com.yash.tcvm_final.builder;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import com.yash.tcvm_final.conf.CoffeeConfig;
import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.enumeration.DrinkTypeEnum;
import com.yash.tcvm_final.exception.ContainerUnderflowException;
import com.yash.tcvm_final.exception.FileEmptyException;
/**
 * This is a concrete class which builds the Coffee
 * 
 * @author sahoo.manas
 *
 */
public class CoffeeDrinkBuilder extends AbstractDrinkBuilder{
	
	private final static Logger LOGGER = Logger.getLogger(CoffeeDrinkBuilder.class);
	
	public CoffeeDrinkBuilder() {
		setDrinkConfigurer(CoffeeConfig.getDrinkConfigurer());
	}

	@Override
	public void process(Order order) throws ContainerUnderflowException, FileNotFoundException, FileEmptyException{
		LOGGER.info("Building Coffee inside process");
		if(order.getDrinkTypeEnum()==DrinkTypeEnum.COFFEE){
			super.process(order);
		}else{
			throw new IllegalArgumentException("Wrong Drink Type, required "+DrinkTypeEnum.COFFEE+" and found "+order.getDrinkTypeEnum());
		}
		LOGGER.info("Coffee building completed inside process");
	}
	
	public static DrinkBuilder getDrinkBuilder(){
		return new CoffeeDrinkBuilder();
	}
}
