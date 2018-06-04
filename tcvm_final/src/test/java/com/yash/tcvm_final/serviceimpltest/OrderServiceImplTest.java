package com.yash.tcvm_final.serviceimpltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import com.yash.tcvm_final.dao.OrderDao;
import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.enumeration.DrinkTypeEnum;
import com.yash.tcvm_final.exception.FileEmptyException;
import com.yash.tcvm_final.service.OrderService;
import com.yash.tcvm_final.serviceimpl.OrderServiceImpl;

public class OrderServiceImplTest {
	
	private OrderDao orderDao;
	private OrderService orderService;

	@Before
	public void init() {
		orderDao = mock(OrderDao.class);
		orderService = new OrderServiceImpl(orderDao);
	}

	@Test(expected = NullPointerException.class)
	public void placeOrder_shouldThrowNullException_WhenOrderObjectIsNull() throws FileNotFoundException, FileEmptyException {
		Order order = null;
		orderService.placeOrder(order);
	}

	@Test
	public void placeOrder_shouldReturnOne_WhenOrderObjectIsGivenWithInputOne() throws FileNotFoundException, FileEmptyException {
		Order order = new Order(1, DrinkTypeEnum.TEA);
		when(orderDao.insertOrder(order)).thenReturn(1);
		int rowAffected = orderService.placeOrder(order);
		assertEquals(1, rowAffected);
	}

}
