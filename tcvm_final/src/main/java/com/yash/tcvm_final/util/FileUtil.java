package com.yash.tcvm_final.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.yash.tcvm_final.domain.Container;
import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.exception.FileNotExistException;

/**
 * This is file util class for writing into and reading from file are done
 * 
 * @author sahoo.manas
 * 
 */
public class FileUtil {

	private List<Container> containerList = null;
	private List<Order> orderList = null;

	public FileUtil() {
		containerList = new ArrayList<Container>();
		orderList = new ArrayList<Order>();
	}

	private static String containerFilePath = "src//main//resources//tcvmmenu//container.json";
	private static String orderFilePath = "src//main//resources//tcvmmenu//order.json";
	private final static Logger LOGGER = Logger.getLogger(FileUtil.class);

	public List<Container> readFromJsonFile() {

		Gson gson = new GsonBuilder().create();
		FileReader jsonFileReader;
		try {
			jsonFileReader = new FileReader(containerFilePath);
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(jsonFileReader);
			LOGGER.info("Reading file inside fileutil");
			String jsonfromString = bufferedReader.readLine();
			if (jsonfromString != null) {
				containerList = gson.fromJson(jsonfromString, new TypeToken<List<Container>>() {
				}.getType());
			}
		} catch (IOException e) {
			LOGGER.error("File Not exist in given path" + containerFilePath);
		}
		return containerList;
	}

	public int writeIntoJsonFile(Container container) throws IOException {
		containerList.add(container);
		Gson gson = new GsonBuilder().create();
		File file = new File(containerFilePath);

		try {
			if (isFileExist(file)) {
				file.createNewFile();
			}
			gson = new Gson();
			String jsonString = gson.toJson(containerList);
			FileWriter jsonFileWriter = new FileWriter(file);
			jsonFileWriter.write(jsonString);
			LOGGER.info("Container added successfully in " + containerFilePath);
			jsonFileWriter.close();

		} catch (FileNotExistException e) {
			LOGGER.error("File Not exist in given path" + containerFilePath);
		}
		return containerList.size();
	}

	private boolean isFileExist(File file) {
		return !file.exists();
	}

	public List<Order> readOrderFromJsonFile() {
		Gson gson = new GsonBuilder().create();
		FileReader jsonFileReader;
		try {
			jsonFileReader = new FileReader(orderFilePath);
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(jsonFileReader);
			String jsonfromString = bufferedReader.readLine();
			if (jsonfromString != null) {
				orderList = gson.fromJson(jsonfromString, new TypeToken<List<Order>>() {
				}.getType());
			}
		} catch (IOException e) {
			LOGGER.error("File Not exist in given path" + orderFilePath);
		}
		return orderList;
	}

	public int writeIntoOrderJsonFile(Order order) {
		orderList.add(order);
		Gson gson = new GsonBuilder().create();
		File file = new File(orderFilePath);

		try {
			if (isFileExist(file)) {
				file.createNewFile();
			}
			gson = new Gson();
			String jsonString = gson.toJson(orderList);
			FileWriter jsonFileWriter = new FileWriter(file, true);
			jsonFileWriter.write(jsonString);
			LOGGER.info("Order placed successfully in " + orderFilePath);
			jsonFileWriter.close();

		} catch (FileNotExistException e) {
			LOGGER.error("File Not exist in given path" + orderFilePath);
		} catch (IOException e) {
			LOGGER.error("File Not Found" + orderFilePath);
		}
		return orderList.size();
	}

	public int updateListOfOrders(List<Order> showList) {
		Gson gson = new GsonBuilder().create();
		try {
			LOGGER.info("Updating order inside fileutil");
			String jsonInString = gson.toJson(showList);
			FileWriter jsonFileWriter = new FileWriter(orderFilePath);
			jsonFileWriter.write(jsonInString);
			jsonFileWriter.close();
		} catch (ConcurrentModificationException exception) {
			LOGGER.error("Concurrent Modification");
		} catch (JsonIOException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return showList.size();
	}

}
