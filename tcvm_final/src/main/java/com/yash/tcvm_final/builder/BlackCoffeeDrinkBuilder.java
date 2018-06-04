package com.yash.tcvm_final.builder;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import com.yash.tcvm_final.conf.BlackCoffeeConfig;
import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.enumeration.DrinkTypeEnum;
import com.yash.tcvm_final.exception.ContainerUnderflowException;
import com.yash.tcvm_final.exception.FileEmptyException;

/**
 * This is a concrete class which builds the BlackCoffee
 * 
 * @author sahoo.manas
 *
 */
public class BlackCoffeeDrinkBuilder extends AbstractDrinkBuilder {

	private final static Logger LOGGER = Logger.getLogger(BlackCoffeeDrinkBuilder.class);

	public BlackCoffeeDrinkBuilder() {
		setDrinkConfigurer(BlackCoffeeConfig.getDrinkConfigurer());
	}

	@Override
	public void process(Order order) throws ContainerUnderflowException, FileNotFoundException, FileEmptyException {
		LOGGER.info("Building black-coffee inside process");
		if (order.getDrinkTypeEnum() == DrinkTypeEnum.BLACK_COFFEE) {
			super.process(order);
		} else {
			throw new IllegalArgumentException("Wrong Drink Type, required " + DrinkTypeEnum.BLACK_COFFEE
					+ " and found " + order.getDrinkTypeEnum());
		}
		LOGGER.info("Black-Coffee building completed inside process");
	}

	public static DrinkBuilder getDrinkBuilder() {
		return new BlackCoffeeDrinkBuilder();
	}
}
