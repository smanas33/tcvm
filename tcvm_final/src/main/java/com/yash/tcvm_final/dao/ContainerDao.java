package com.yash.tcvm_final.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.yash.tcvm_final.domain.Container;
import com.yash.tcvm_final.exception.FileEmptyException;

public interface ContainerDao {
	
	public int insertContainer(Container container) throws FileEmptyException, FileNotFoundException, IOException;

}
