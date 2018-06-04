package com.yash.tcvm_final.tcvmmenutest;

import org.junit.Test;
import com.yash.tcvm_final.exception.FileNullPointerException;
import com.yash.tcvm_final.utils.TCVMMenu;;

public class TCVMMenuTest {

	@Test(expected = FileNullPointerException.class)
	public void shouldThrowFileNullPointerExcepTion_WhenNoFileNameGiven() {
		String fileName = null;
		TCVMMenu.chooseUserOption();
	}

	@Test(expected = FileNullPointerException.class)
	public void shouldThrowEmptyFileExcepTion_WhenGivenFileNameIsEmpty() {
		String fileName = "";
		TCVMMenu.chooseUserOption();
	}

	@Test
	public void shouldThrowFileNotFoundExcepTion_WhenWrongFileNameGiven() {
		String fileName = "src//main//resources//tcvmmenu//tcvmmenu.tx";
		TCVMMenu.chooseUserOption();
	}

	@Test
	public void shouldNotThrowAnyException_WhenCorrectFileNameGiven() {
		String fileName = "src//main//resources//tcvmmenu//tcvmmenu.txt";
		TCVMMenu.chooseUserOption();
	}

}
