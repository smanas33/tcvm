package com.yash.tcvm_final.conf;

import com.yash.tcvm_final.enumeration.DrinkTypeEnum;

public class BlackCoffeeConfig extends AbstractDrinkConfigurer {

	public static final int WATER_USE = 100;
	public static final int SUGAR_USE = 15;
	public static final int COFFEE_USE = 3;
	public static final int RATE = 10;

	public static final int WATER_WASTE = 12;
	public static final int SUGAR_WASTE = 2;
	public static final int COFFEE_WASTE = 0;

	private static IDrinkConfigurer drinkConfigurer;

	static {
		drinkConfigurer = new BlackCoffeeConfig();
	}

	private BlackCoffeeConfig() {
		super();
	}

	public void configUse() {
		setCoffeeUse(COFFEE_USE);
		setSugarUse(SUGAR_USE);
		setWaterUse(WATER_USE);

	}

	public void configWaste() {
		setCoffeeWaste(COFFEE_WASTE);
		setSugarWaste(SUGAR_WASTE);
		setWaterWaste(WATER_WASTE);

	}

	public void configDrinkType() {
		setDrinkType(DrinkTypeEnum.BLACK_COFFEE);

	}

	public void configDrinkRate() {
		setRate(RATE);

	}

	public static IDrinkConfigurer getDrinkConfigurer() {
		return drinkConfigurer;
	}

}
