package com.yash.tcvm_final.service;

import java.io.FileNotFoundException;

import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.exception.FileEmptyException;

public interface OrderService {

	public int placeOrder(Order order) throws FileNotFoundException, FileEmptyException;

}
