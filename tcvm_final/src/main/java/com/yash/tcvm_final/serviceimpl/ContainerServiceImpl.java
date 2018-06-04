package com.yash.tcvm_final.serviceimpl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.yash.tcvm_final.dao.ContainerDao;
import com.yash.tcvm_final.domain.Container;
import com.yash.tcvm_final.exception.FileEmptyException;
import com.yash.tcvm_final.service.ContainerService;

public class ContainerServiceImpl implements ContainerService {

	private ContainerDao containerDao;
	
	private final static Logger LOGGER = Logger.getLogger(ContainerServiceImpl.class);

	public ContainerServiceImpl(ContainerDao containerDao) {
		this.containerDao = containerDao;
	}

	public int insertContainer(Container container) throws FileEmptyException, IOException {
		
			int insertedContainer = 0;
			try {
				if (isContainerNull(container)) {
					LOGGER.error("Container Object should not be null !!");
					return insertedContainer;
				} else {
					LOGGER.info("inserting container inside containerserviceimpl");
					containerDao.insertContainer(container);
					insertedContainer = 1;
				}
			} catch (NullPointerException exception) {
				exception.printStackTrace();
			}
			return insertedContainer;
		}

		private boolean isContainerNull(Container container) {
			return null == container;
		}
}
