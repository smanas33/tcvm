package com.yash.tcvm_final.report;

public class ReportTracker {

	private int teaCost;
	private int blackTeaCost;
	private int coffeeCost;
	private int blackCoffeeCost;
	
	private int noOfCupsTea;
	private int noOfCupsBlackTea;
	private int noOfCupsCoffee;
	private int noOfCupsBlackCoffee;
	
	public ReportTracker() {
		super();
	}

	public ReportTracker(int teaCost, int blackTeaCost, int coffeeCost, int blackCoffeeCost, int noOfCupsTea,
			int noOfCupsBlackTea, int noOfCupsCoffee, int noOfCupsBlackCoffee) {
		super();
		this.teaCost = teaCost;
		this.blackTeaCost = blackTeaCost;
		this.coffeeCost = coffeeCost;
		this.blackCoffeeCost = blackCoffeeCost;
		this.noOfCupsTea = noOfCupsTea;
		this.noOfCupsBlackTea = noOfCupsBlackTea;
		this.noOfCupsCoffee = noOfCupsCoffee;
		this.noOfCupsBlackCoffee = noOfCupsBlackCoffee;
	}

	public int getTeaCost() {
		return teaCost;
	}

	public void setTeaCost(int teaCost) {
		this.teaCost = teaCost;
	}

	public int getBlackTeaCost() {
		return blackTeaCost;
	}

	public void setBlackTeaCost(int blackTeaCost) {
		this.blackTeaCost = blackTeaCost;
	}

	public int getCoffeeCost() {
		return coffeeCost;
	}

	public void setCoffeeCost(int coffeeCost) {
		this.coffeeCost = coffeeCost;
	}

	public int getBlackCoffeeCost() {
		return blackCoffeeCost;
	}

	public void setBlackCoffeeCost(int blackCoffeeCost) {
		this.blackCoffeeCost = blackCoffeeCost;
	}

	public int getNoOfCupsTea() {
		return noOfCupsTea;
	}

	public void setNoOfCupsTea(int noOfCupsTea) {
		this.noOfCupsTea = noOfCupsTea;
	}

	public int getNoOfCupsBlackTea() {
		return noOfCupsBlackTea;
	}

	public void setNoOfCupsBlackTea(int noOfCupsBlackTea) {
		this.noOfCupsBlackTea = noOfCupsBlackTea;
	}

	public int getNoOfCupsCoffee() {
		return noOfCupsCoffee;
	}

	public void setNoOfCupsCoffee(int noOfCupsCoffee) {
		this.noOfCupsCoffee = noOfCupsCoffee;
	}

	public int getNoOfCupsBlackCoffee() {
		return noOfCupsBlackCoffee;
	}

	public void setNoOfCupsBlackCoffee(int noOfCupsBlackCoffee) {
		this.noOfCupsBlackCoffee = noOfCupsBlackCoffee;
	}
	
}
