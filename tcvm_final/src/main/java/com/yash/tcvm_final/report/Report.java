package com.yash.tcvm_final.report;

public class Report extends ReportTracker {
	public static final int TEA_COST = 0;
	public static final int BLACK_TEA_COST = 0;
	public static final int COFFEE_COST = 0;
	public static final int BLACK_COFFEE_COST = 0;
	
	public static final int NO_OF_CUPS_TEA = 0;
	public static final int NO_OF_CUPS_BLACK_TEA = 0;
	public static final int NO_OF_CUPS_COFFEE = 0;
	public static final int NO_OF_CUPS_BLACK_COFFEE = 0;
	
	static Report report;
	
	static{
		report =  new Report();
	}

	private Report(){
		this(TEA_COST, BLACK_TEA_COST, COFFEE_COST, BLACK_COFFEE_COST, NO_OF_CUPS_TEA, NO_OF_CUPS_BLACK_TEA, NO_OF_CUPS_COFFEE, 
				NO_OF_CUPS_BLACK_COFFEE);
	}

	public Report(int teaCost, int blackTeaCost, int coffeeCost, int blackCoffeeCost, int noOfCupsTea,
			int noOfCupsBlackTea, int noOfCupsCoffee, int noOfCupsBlackCoffee) {
		super(teaCost, blackTeaCost, coffeeCost, blackCoffeeCost, noOfCupsTea, noOfCupsBlackTea, 
				noOfCupsCoffee,noOfCupsBlackCoffee);
	}

	public static Report getReport() {
		return report;
	}

	@Override
	public String toString() {
		StringBuilder sb =  new StringBuilder();
		sb.append("Total no of cups of Tea is "+getNoOfCupsTea()+" and total Cost          : "+getTeaCost()+"\r\n")
		.append("Total no of cups of Black-Tea is "+getNoOfCupsBlackTea()+" and total Cost    : "+getBlackTeaCost()+"\r\n")
		.append("Total no of cups of Coffee is "+getNoOfCupsCoffee()+" and total Cost       : "+getCoffeeCost()+"\r\n")
		.append("Total no of cups of Black-Coffee is "+getNoOfCupsBlackCoffee()+" and total Cost : "+getBlackCoffeeCost()+"\r\n");
		
		return sb.toString();
		
		
	}
}
