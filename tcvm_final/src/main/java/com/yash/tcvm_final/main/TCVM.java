package com.yash.tcvm_final.main;

import com.yash.tcvm_final.exception.ContainerUnderflowException;
import com.yash.tcvm_final.utils.TCVMMenu;

/**
 * This is main class, where this app gets initialize
 * 
 * @author sahoo.manas
 *
 */
public class TCVM {

	public static void main(String[] args) throws ContainerUnderflowException {
		TCVMMenu.chooseUserOption();
	}
}
