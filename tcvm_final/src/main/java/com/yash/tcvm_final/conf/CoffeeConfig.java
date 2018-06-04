package com.yash.tcvm_final.conf;

import com.yash.tcvm_final.enumeration.DrinkTypeEnum;

public class CoffeeConfig extends AbstractDrinkConfigurer {

	public static final int WATER_USE = 20;
	public static final int SUGAR_USE = 15;
	public static final int MILK_USE = 80;
	public static final int COFFEE_USE = 4;
	public static final int RATE = 15;

	public static final int WATER_WASTE = 3;
	public static final int SUGAR_WASTE = 2;
	public static final int MILK_WASTE = 8;
	public static final int COFFEE_WASTE = 1;

	private static IDrinkConfigurer drinkConfigurer;

	static {
		drinkConfigurer = new CoffeeConfig();
	}

	private CoffeeConfig() {
		super();
	}

	public void configUse() {
		setCoffeeUse(COFFEE_USE);
		setSugarUse(SUGAR_USE);
		setMilkUse(MILK_USE);
		setWaterUse(WATER_USE);

	}

	public void configWaste() {
		setCoffeeWaste(COFFEE_WASTE);
		setSugarWaste(SUGAR_WASTE);
		setMilkWaste(MILK_WASTE);
		setWaterWaste(WATER_WASTE);

	}

	public void configDrinkType() {
		setDrinkType(DrinkTypeEnum.COFFEE);

	}

	public void configDrinkRate() {
		setRate(RATE);

	}

	public static IDrinkConfigurer getDrinkConfigurer() {
		return drinkConfigurer;
	}
}
