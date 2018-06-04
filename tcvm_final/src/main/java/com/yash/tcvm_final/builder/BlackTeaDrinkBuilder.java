package com.yash.tcvm_final.builder;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import com.yash.tcvm_final.conf.BlackTeaConfig;
import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.enumeration.DrinkTypeEnum;
import com.yash.tcvm_final.exception.ContainerUnderflowException;
import com.yash.tcvm_final.exception.FileEmptyException;

/**
 * This is a concrete class which builds the BlackTea
 * 
 * @author sahoo.manas
 *
 */
public class BlackTeaDrinkBuilder extends AbstractDrinkBuilder {

	private final static Logger LOGGER = Logger.getLogger(BlackTeaDrinkBuilder.class);

	public BlackTeaDrinkBuilder() {
		setDrinkConfigurer(BlackTeaConfig.getDrinkConfigurer());
	}

	@Override
	public void process(Order order) throws ContainerUnderflowException, FileNotFoundException, FileEmptyException {
		LOGGER.info("Building black-tea inside process");
		if (order.getDrinkTypeEnum() == DrinkTypeEnum.BLACK_TEA) {
			super.process(order);
		} else {
			throw new IllegalArgumentException(
					"Wrong Drink Type, required " + DrinkTypeEnum.BLACK_TEA + " and found " + order.getDrinkTypeEnum());
		}
		LOGGER.info("Black-Tea building completed inside process");
	}

	public static DrinkBuilder getDrinkBuilder() {
		return new BlackTeaDrinkBuilder();
	}

}
