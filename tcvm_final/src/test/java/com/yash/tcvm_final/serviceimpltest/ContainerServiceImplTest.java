package com.yash.tcvm_final.serviceimpltest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.tcvm_final.dao.ContainerDao;
import com.yash.tcvm_final.domain.Container;
import com.yash.tcvm_final.domain.Material;
import com.yash.tcvm_final.exception.FileEmptyException;
import com.yash.tcvm_final.service.ContainerService;
import com.yash.tcvm_final.serviceimpl.ContainerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ContainerServiceImplTest {

	private ContainerDao containerDao;

	private ContainerService containerService;

	@Before
	public void init() {
		containerDao = mock(ContainerDao.class);
		containerService = new ContainerServiceImpl(containerDao);
	}

	@Test(expected = NullPointerException.class)
	public void addContainer_ShouldThrowException_WhenNullContainerObjectGiven() throws FileEmptyException, IOException {
		Container container = null;
		containerService.insertContainer(container);
	}

	@Test
	public void addContainer_ContainerObjectGiven_ShouldReturnOne() throws FileEmptyException, IOException {
		Container container = (Container) new Material(2000, 2000, 8000, 10000, 15000);
		when(containerDao.insertContainer(container)).thenReturn(1);
		int rowAdded = containerService.insertContainer(container);
		assertEquals(1, rowAdded);
	}
}
