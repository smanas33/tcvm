package com.yash.tcvm_final.serviceimpl;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.tcvm_final.dao.OrderDao;
import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.exception.FileEmptyException;
import com.yash.tcvm_final.service.OrderService;

public class OrderServiceImpl  implements OrderService {
	
	private OrderDao orderDao;
	
	private final static Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);
	
	public OrderServiceImpl(OrderDao orderDao){
		this.orderDao = orderDao;
	}

	public int placeOrder(Order order) throws FileNotFoundException, FileEmptyException {
		List<Order> orders = orderDao.getOrders();
		int insertedScreen = 0;
		try {
			if (isOrderNull(order)) {
				LOGGER.error("Order Object should not be null !!");
				return insertedScreen;
			}
			if (isOrderEmpty(orders)) {
				orders.add(order);
				LOGGER.info("Updating Orderlist inside orderserviceimpl");
				orderDao.updateOrder(orders);
				insertedScreen = 1;

			} else {
				LOGGER.info("inserting order inside orderserviceimpl");
				orderDao.insertOrder(order);
				insertedScreen = 1;
			}
		} catch (NullPointerException exception) {
			exception.printStackTrace();
		} 
		return insertedScreen;
	}
	
	private boolean isOrderEmpty(List<Order> orders) {
		return !orders.isEmpty();
	}

	private boolean isOrderNull(Order order) {
		return null == order;
	}
}
