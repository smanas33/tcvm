package com.yash.tcvm_final.dao;

import java.io.FileNotFoundException;
import java.util.List;

import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.exception.FileEmptyException;

public interface OrderDao {
	
	List<Order> getOrders() throws FileNotFoundException, FileEmptyException;

	int insertOrder(Order order) throws FileEmptyException, FileNotFoundException;

	int updateOrder(List<Order> orders);

}
