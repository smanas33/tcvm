package com.yash.tcvm_final.builder;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import com.yash.tcvm_final.conf.AbstractDrinkConfigurer;
import com.yash.tcvm_final.conf.BlackCoffeeConfig;
import com.yash.tcvm_final.conf.BlackTeaConfig;
import com.yash.tcvm_final.conf.CoffeeConfig;
import com.yash.tcvm_final.conf.IDrinkConfigurer;
import com.yash.tcvm_final.conf.TeaConfig;
import com.yash.tcvm_final.dao.OrderDao;
import com.yash.tcvm_final.daoimpl.OrderDaoImpl;
import com.yash.tcvm_final.domain.Container;
import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.enumeration.ContainerEnum;
import com.yash.tcvm_final.enumeration.DrinkTypeEnum;
import com.yash.tcvm_final.exception.ContainerUnderflowException;
import com.yash.tcvm_final.exception.FileEmptyException;
import com.yash.tcvm_final.report.Report;
import com.yash.tcvm_final.service.OrderService;
import com.yash.tcvm_final.serviceimpl.OrderServiceImpl;
import com.yash.tcvm_final.util.FileUtil;

/**
 * This is an abstract class for updating container and report status
 * 
 * @author sahoo.manas
 *
 */
public abstract class AbstractDrinkBuilder implements DrinkBuilder {
	private final static Logger LOGGER = Logger.getLogger(AbstractDrinkBuilder.class);
	private Container container;
	private Report report;
	private IDrinkConfigurer dConfigurer;
	FileUtil fileUtil = new FileUtil();
	OrderDao orderDao = new OrderDaoImpl(fileUtil);
	OrderService orderService = new OrderServiceImpl(orderDao);

	private int teaRequired;
	private int milkRequired;
	private int waterRequired;
	private int sugarRequired;
	private int coffeeRequired;

	public AbstractDrinkBuilder() {
		report = Report.getReport();
		container = Container.getContainer();
	}

	public void setDrinkConfigurer(IDrinkConfigurer drinkConfigurer) {
		this.dConfigurer = drinkConfigurer;
	}

	public void process(Order order) throws ContainerUnderflowException, FileNotFoundException, FileEmptyException {
		checkUnderFlow(order);
		updateContainer();
		order.setStatus(true);
		updateReportTracker(order);
		orderService.placeOrder(order);
	}

	private void checkUnderFlow(Order order) throws ContainerUnderflowException {
		LOGGER.info("checking underflow status");
		AbstractDrinkConfigurer drinkConfigurer = (AbstractDrinkConfigurer) dConfigurer;
		teaRequired = order.getQuantity() * (drinkConfigurer.getTeaUse() + drinkConfigurer.getTeaWaste());
		if (container.getTea() < teaRequired) {
			throw new ContainerUnderflowException(ContainerEnum.TEA + " Insufficient");
		}

		milkRequired = order.getQuantity() * (drinkConfigurer.getMilkUse() + drinkConfigurer.getMilkWaste());
		if (container.getMilk() < milkRequired) {
			throw new ContainerUnderflowException(ContainerEnum.MILK + "Insufficient");
		}

		waterRequired = order.getQuantity() * (drinkConfigurer.getWaterUse() + drinkConfigurer.getWaterWaste());
		if (container.getWater() < waterRequired) {
			throw new ContainerUnderflowException(ContainerEnum.WATER + " Insufficient");
		}

		sugarRequired = order.getQuantity() * (drinkConfigurer.getSugarUse() + drinkConfigurer.getSugarWaste());
		if (container.getSugar() < sugarRequired) {
			throw new ContainerUnderflowException(ContainerEnum.SUGAR + "Insufficient");
		}

		coffeeRequired = order.getQuantity() * (drinkConfigurer.getCoffeeUse() + drinkConfigurer.getCoffeeWaste());
		if (container.getCoffee() < coffeeRequired) {
			throw new ContainerUnderflowException(ContainerEnum.COFFEE + "Insufficient");
		}
		LOGGER.info("checking underflow status completed");
	}

	public Container getContainer() {
		return this.container;
	}

	public void updateContainer() {
		LOGGER.info("updating container inside updateContainer");
		container.setCoffee(container.getCoffee() - coffeeRequired);
		container.setMilk(container.getMilk() - milkRequired);
		container.setSugar(container.getSugar() - sugarRequired);
		container.setTea(container.getTea() - teaRequired);
		container.setWater(container.getWater() - waterRequired);
		LOGGER.info("container updation completed inside updateContainer");
	}

	public void updateReportTracker(Order order) {
		LOGGER.info("updating report statistics inside updateReportTracker");
		if (order.getDrinkTypeEnum() == DrinkTypeEnum.TEA) {
			report.setTeaCost(report.getTeaCost() + (order.getQuantity() * TeaConfig.RATE));
			report.setNoOfCupsTea(report.getNoOfCupsTea() + order.getQuantity());
		}
		if (order.getDrinkTypeEnum() == DrinkTypeEnum.BLACK_TEA) {
			report.setBlackTeaCost(report.getBlackTeaCost() + (order.getQuantity() * BlackTeaConfig.RATE));
			report.setNoOfCupsBlackTea(report.getNoOfCupsBlackTea() + order.getQuantity());
		}
		if (order.getDrinkTypeEnum() == DrinkTypeEnum.COFFEE) {
			report.setCoffeeCost(report.getCoffeeCost() + (order.getQuantity() * CoffeeConfig.RATE));
			report.setNoOfCupsCoffee(report.getNoOfCupsCoffee() + order.getQuantity());
		}
		if (order.getDrinkTypeEnum() == DrinkTypeEnum.BLACK_COFFEE) {
			report.setBlackCoffeeCost(report.getBlackCoffeeCost() + (order.getQuantity() * BlackCoffeeConfig.RATE));
			report.setNoOfCupsBlackCoffee(report.getNoOfCupsBlackCoffee() + order.getQuantity());
		}
		LOGGER.info("report updation completed inside updateReportTracker");
	}
}
