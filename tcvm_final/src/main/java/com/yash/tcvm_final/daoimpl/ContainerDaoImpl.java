package com.yash.tcvm_final.daoimpl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.yash.tcvm_final.dao.ContainerDao;
import com.yash.tcvm_final.domain.Container;
import com.yash.tcvm_final.exception.FileEmptyException;
import com.yash.tcvm_final.util.FileUtil;

public class ContainerDaoImpl implements ContainerDao {

	private FileUtil fileUtil;
	private final static Logger LOGGER = Logger.getLogger(ContainerDaoImpl.class);

	public ContainerDaoImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

	public int insertContainer(Container container)
			throws FileEmptyException, IOException {
		int rowAffected = 0;
		rowAffected = fileUtil.writeIntoJsonFile(container);
		LOGGER.info("container inserted inside containerdaoimpl");
		return rowAffected;
	}

}
