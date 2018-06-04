package com.yash.tcvm_final.daoimpl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.yash.tcvm_final.dao.ContainerDao;
import com.yash.tcvm_final.domain.Container;
import com.yash.tcvm_final.domain.Material;
import com.yash.tcvm_final.exception.FileEmptyException;
import com.yash.tcvm_final.util.FileUtil;

public class ContainerDaoImplTest {

	private ContainerDao containerDao;
	private FileUtil fileUtil;

	@Before
	public void init() {
		containerDao = new ContainerDaoImpl(fileUtil);
	}
	
	@Test
	public void insertContainer_ShouldReturnOne_WhenContainerObjectIsGiven() throws FileEmptyException, IOException{
		Container container = (Container) new Material(2000, 2000, 8000, 10000, 15000);
		assertEquals(1, containerDao.insertContainer(container));
	}
	
	@Test(expected = NullPointerException.class)
	public void insertContainer_shouldThrowException_WhenContainerObjectGivenIsNull() throws FileEmptyException, IOException {
		Container container = null;
		assertEquals(1, containerDao.insertContainer(container));
	}
	


}
