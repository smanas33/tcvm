package com.yash.tcvm_final.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.yash.tcvm_final.builder.BlackCoffeeDrinkBuilder;
import com.yash.tcvm_final.builder.BlackTeaDrinkBuilder;
import com.yash.tcvm_final.builder.CoffeeDrinkBuilder;
import com.yash.tcvm_final.builder.DrinkBuilder;
import com.yash.tcvm_final.builder.TeaDrinkBuilder;
import com.yash.tcvm_final.dao.ContainerDao;
import com.yash.tcvm_final.daoimpl.ContainerDaoImpl;
import com.yash.tcvm_final.domain.Container;
import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.enumeration.DrinkTypeEnum;
import com.yash.tcvm_final.exception.ContainerUnderflowException;
import com.yash.tcvm_final.exception.FileEmptyException;
import com.yash.tcvm_final.exception.FileNullPointerException;
import com.yash.tcvm_final.report.Report;
import com.yash.tcvm_final.service.ContainerService;
import com.yash.tcvm_final.serviceimpl.ContainerServiceImpl;
import com.yash.tcvm_final.util.FileUtil;

/**
 * The class represents the menu for tea-coffee vending machine.
 * 
 * @author sahoo.manas
 * 
 */
public class TCVMMenu {

	private static Scanner userInputScanner = new Scanner(System.in);

	private final static Logger LOGGER = Logger.getLogger(TCVMMenu.class);

	private static DrinkBuilder drinkBuilder;

	private static void getTCVMMenu() {
		FileUtil util = new FileUtil();
		ContainerDao dao = new ContainerDaoImpl(util);
		ContainerService service = new ContainerServiceImpl(dao);
		try {
			service.insertContainer(Container.getContainer());
		} catch (FileEmptyException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String fileName = "src//main//resources//tcvmmenu//tcvmmenu.txt";

		if (isFileNameNull(fileName)) {
			LOGGER.error("File name should not be null");
			throw new FileNullPointerException("File name should not be null");
		}

		else if (isFileEmpty(fileName)) {
			LOGGER.error("File name should not empty");
			throw new FileNullPointerException("File name should not empty");
		}

		else
			getMenu(fileName);
	}

	private static boolean isFileNameNull(String fileName) {
		return null == fileName;
	}

	private static boolean isFileEmpty(String fileName) {
		return fileName.isEmpty();
	}

	private static void getMenu(String fileName) {
		String line;
		FileReader reader;
		BufferedReader bufferedReader;

		try {
			reader = new FileReader(fileName);
			bufferedReader = new BufferedReader(reader);
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();

		} catch (FileNotFoundException fileNotFoundException) {
			LOGGER.error("File not found");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	public static void chooseUserOption() {

		int operatorChoice;
		do {
			getTCVMMenu();
			System.out.println("Enter your choice: ");
			operatorChoice = userInputScanner.nextInt();
			switch (operatorChoice) {
			case 1:
				teaDrinkBuilder();
				break;
			case 2:
				blackTeaDrinkBuilder();
				break;
			case 3:
				coffeeDrinkBuilder();
				break;
			case 4:
				blackCoffeeDrinkBuilder();
				break;
			case 5:
				refillingContainer();
				break;
			case 6:
				individualSaleReportStatistics();
				break;
			case 7:
				totalSaleReportStatistics();
				break;
			case 8:
				checkContainerStatus();
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Please choose a valid option !!\n");
			}
		} while (operatorChoice != 0);

	}

	private static void checkContainerStatus() {
		System.out.println("Current container status : ");
		System.out.println("Tea    : " + Container.getContainer().getTea());
		System.out.println("Coffee : " + Container.getContainer().getCoffee());
		System.out.println("Milk   : " + Container.getContainer().getMilk());
		System.out.println("Sugar  : " + Container.getContainer().getSugar());
		System.out.println("Water  : " + Container.getContainer().getWater());
		System.out.println();
	}

	private static void totalSaleReportStatistics() {
		System.out.println("------------------");
		System.out.println("Total Sale Report ");
		System.out.println("------------------\n");
		int totalCost = (Report.getReport().getTeaCost() + Report.getReport().getBlackTeaCost()
				+ Report.getReport().getCoffeeCost() + Report.getReport().getBlackCoffeeCost());
		int totalNoOfCups = (Report.getReport().getNoOfCupsTea() + Report.getReport().getNoOfCupsBlackTea()
				+ Report.getReport().getNoOfCupsCoffee() + Report.getReport().getNoOfCupsBlackCoffee());
		System.out.println("Total no of cups sale : " + totalNoOfCups + " and total cost : " + totalCost + "\n");
	}

	private static void individualSaleReportStatistics() {
		System.out.println("----------------------");
		System.out.println("Individual Sale Report ");
		System.out.println("----------------------\n");
		System.out.println(Report.getReport());
	}

	private static void refillingContainer() {
		System.out.println("-----------------");
		System.out.println("Refilling........ ");
		System.out.println("-----------------\n");
		try {
			Thread.sleep(5000);
			Container.reset();
		} catch (InterruptedException exception) {
			LOGGER.error(exception.getMessage());
		} catch (FileEmptyException exception) {
			LOGGER.error(exception.getMessage());
		} catch (FileNotFoundException exception) {
			LOGGER.error(exception.getMessage());
		} catch (IOException exception) {
			LOGGER.error(exception.getMessage());
		}
		System.out.println("Refilling is done : " + Container.REFILLING_COUNTER + " times\n");
	}

	private static void blackCoffeeDrinkBuilder() {
		System.out.println("---------------------");
		System.out.println("Black-Coffee Selected ");
		System.out.println("---------------------\n");
		int orderQuantity = orderQuantity();
		drinkBuilder = BlackCoffeeDrinkBuilder.getDrinkBuilder();
		try {
			drinkBuilder.process(new Order(orderQuantity, DrinkTypeEnum.BLACK_COFFEE));
		} catch (ContainerUnderflowException exception) {
			LOGGER.error(exception.getMessage());
		} catch (FileNotFoundException exception) {
			LOGGER.error(exception.getMessage());
		} catch (FileEmptyException exception) {
			LOGGER.error(exception.getMessage());
		}
		System.out.println("Black-Coffee Prepared\n");
	}

	private static void coffeeDrinkBuilder() {
		System.out.println("----------------------------");
		System.out.println("Coffee Selected ");
		System.out.println("----------------------------\n");
		int orderQuantity = orderQuantity();
		drinkBuilder = CoffeeDrinkBuilder.getDrinkBuilder();
		try {
			drinkBuilder.process(new Order(orderQuantity, DrinkTypeEnum.COFFEE));
		} catch (ContainerUnderflowException exception) {
			LOGGER.error(exception.getMessage());
		} catch (FileNotFoundException exception) {
			LOGGER.error(exception.getMessage());
		} catch (FileEmptyException exception) {
			LOGGER.error(exception.getMessage());
		}
		System.out.println("Coffee Prepared\n");
	}

	private static void blackTeaDrinkBuilder() {
		System.out.println("---------------------");
		System.out.println("Black-Tea Selected ");
		System.out.println("---------------------\n");
		int orderQuantity = orderQuantity();
		drinkBuilder = BlackTeaDrinkBuilder.getDrinkBuilder();
		try {
			drinkBuilder.process(new Order(orderQuantity, DrinkTypeEnum.BLACK_TEA));
		} catch (ContainerUnderflowException exception) {
			LOGGER.error(exception.getMessage());
		} catch (FileNotFoundException exception) {
			LOGGER.error(exception.getMessage());
		} catch (FileEmptyException exception) {
			LOGGER.error(exception.getMessage());
		}
		System.out.println("Black-Tea Prepared\n");
	}

	private static void teaDrinkBuilder() {
		System.out.println("---------------------");
		System.out.println("Tea Selected ");
		System.out.println("---------------------\n");
		int orderQuantity = orderQuantity();
		drinkBuilder = TeaDrinkBuilder.getDrinkBuilder();
		try {
			drinkBuilder.process(new Order(orderQuantity, DrinkTypeEnum.TEA));
		} catch (ContainerUnderflowException exception) {
			LOGGER.error(exception.getMessage());
		} catch (FileNotFoundException exception) {
			LOGGER.error(exception.getMessage());
		} catch (FileEmptyException exception) {
			LOGGER.error(exception.getMessage());
		}
		System.out.println("Tea Prepared\n");
	}

	private static int orderQuantity() {
		System.out.println("Enter no of cups : ");
		int orderQty = userInputScanner.nextInt();
		return orderQty;
	}

}
