package com.yash.tcvm_final.domain;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.yash.tcvm_final.dao.ContainerDao;
import com.yash.tcvm_final.daoimpl.ContainerDaoImpl;
import com.yash.tcvm_final.exception.FileEmptyException;
import com.yash.tcvm_final.service.ContainerService;
import com.yash.tcvm_final.serviceimpl.ContainerServiceImpl;
import com.yash.tcvm_final.util.FileUtil;

public class Container extends Material{
	
	public static final int TEA_CONTAINER_MAX_CAPACITY = 2000;
	public static final int COFFEE_CONTAINER_MAX_CAPACITY = 2000;
	public static final int SUGAR_CONTAINER_MAX_CAPACITY = 8000;
	public static final int WATER_CONTAINER_MAX_CAPACITY = 15000;
	public static final int MILK_CONTAINER_MAX_CAPACITY = 10000;
	
	public static int REFILLING_COUNTER = 0;
	private static FileUtil util = new FileUtil();
	private static ContainerDao dao = new ContainerDaoImpl(util);
	private static ContainerService service = new ContainerServiceImpl(dao);
	
	static Container container;
	
	static{
		container =  new Container();
	}

	private Container(){
		this(TEA_CONTAINER_MAX_CAPACITY, COFFEE_CONTAINER_MAX_CAPACITY, SUGAR_CONTAINER_MAX_CAPACITY, MILK_CONTAINER_MAX_CAPACITY, WATER_CONTAINER_MAX_CAPACITY);
	}
	
	private Container(Integer tea, Integer coffee, Integer sugar, Integer milk, Integer water){
		super(tea, coffee, sugar, milk, water);
	}
	
	public static void reset() throws FileEmptyException, FileNotFoundException, IOException{
		container.setTea(TEA_CONTAINER_MAX_CAPACITY);
		container.setCoffee(COFFEE_CONTAINER_MAX_CAPACITY);
		container.setSugar(SUGAR_CONTAINER_MAX_CAPACITY);
		container.setWater(WATER_CONTAINER_MAX_CAPACITY);
		container.setMilk(MILK_CONTAINER_MAX_CAPACITY);
		service.insertContainer(container);
		REFILLING_COUNTER++;
	}
	
	public static Container getContainer() {
		return container;
	}

	@Override
	public String toString() {
		StringBuilder sb =  new StringBuilder();
		sb.append("Container[\r\n")
		.append("Tea : "+getTea()+"\r\n")
		.append("Coffee : "+getCoffee()+"\r\n")
		.append("Water : "+getWater()+"\r\n")
		.append("Milk : "+getMilk()+"\r\n")
		.append("Sugar : "+getSugar()+"\r\n")
		.append("]");
		
		return sb.toString();
		
		
	}
	
	
}
