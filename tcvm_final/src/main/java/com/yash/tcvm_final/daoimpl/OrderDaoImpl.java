package com.yash.tcvm_final.daoimpl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.tcvm_final.dao.OrderDao;
import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.exception.FileEmptyException;
import com.yash.tcvm_final.util.FileUtil;

public class OrderDaoImpl implements OrderDao {
	
	private FileUtil fileUtil;
	private final static Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);

	public OrderDaoImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}


	public List<Order> getOrders() throws FileNotFoundException, FileEmptyException {
		List<Order> orderLists = new ArrayList<Order>();
		LOGGER.info("getting Order object inside orderdaoimpl");
		orderLists = fileUtil.readOrderFromJsonFile();
		return orderLists;
	}

	public int insertOrder(Order order) throws FileEmptyException, FileNotFoundException {
		int rowAffected = 0;
		rowAffected = fileUtil.writeIntoOrderJsonFile(order);
		LOGGER.info("order inserted inside orderdaoimpl");
		return rowAffected;
	}

	public int updateOrder(List<Order> orders) {
		int screenAdded = 0;
		LOGGER.info("Updating orderList inside orderdaoimpl ");
		screenAdded = fileUtil.updateListOfOrders(orders);
		return screenAdded;
	}

	
}
