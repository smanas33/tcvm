package com.yash.tcvm_final.daoimpl;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import com.yash.tcvm_final.dao.OrderDao;
import com.yash.tcvm_final.domain.Order;
import com.yash.tcvm_final.enumeration.DrinkTypeEnum;
import com.yash.tcvm_final.exception.FileEmptyException;
import com.yash.tcvm_final.util.FileUtil;

public class OrderDaoImplTest {

	private OrderDao orderDao;
	private FileUtil fileUtil;

	@Before
	public void init() {
		orderDao = new OrderDaoImpl(fileUtil);
	}

	@Test(expected = FileNotFoundException.class)
	public void getOrders_ShouldThrowException_WhenJSONFileForOrderNotFoundInProvidedPath()
			throws FileNotFoundException, FileEmptyException {
		orderDao.getOrders();
	}

	@Test(expected = FileEmptyException.class)
	public void getOrders_ShouldThrowException_WhenJSONFileForOrderIsEmpty()
			throws FileNotFoundException, FileEmptyException {
		orderDao.getOrders();

	}

	@Test
	public void insertOrder_ShouldReturnOne_WhenOrderObjectIsGiven() throws FileEmptyException, FileNotFoundException {
		Order order = new Order(5, DrinkTypeEnum.COFFEE);
		assertEquals(1, orderDao.insertOrder(order));
	}

	@Test
	public void getOrders_shouldReturnSizeOfOrdersList_WhenListOfOrderObjectAreInJSONFile()
			throws FileNotFoundException, FileEmptyException {
		assertEquals(2, orderDao.getOrders().size());
	}

	@Test(expected = NullPointerException.class)
	public void insertOrder_shouldThrowException_WhenOrderObjectGivenIsNull()
			throws FileNotFoundException, FileEmptyException {
		Order order = null;
		assertEquals(1, orderDao.insertOrder(order));
	}

}