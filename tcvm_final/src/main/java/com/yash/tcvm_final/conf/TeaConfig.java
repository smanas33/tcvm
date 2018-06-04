package com.yash.tcvm_final.conf;

import com.yash.tcvm_final.enumeration.DrinkTypeEnum;

public class TeaConfig extends AbstractDrinkConfigurer {

	public static final int WATER_USE = 60;
	public static final int SUGAR_USE = 15;
	public static final int MILK_USE = 40;
	public static final int TEA_USE = 5;
	public static final int RATE = 10;

	public static final int WATER_WASTE = 5;
	public static final int SUGAR_WASTE = 2;
	public static final int MILK_WASTE = 4;
	public static final int TEA_WASTE = 1;

	private static IDrinkConfigurer drinkConfigurer;

	static {
		drinkConfigurer = new TeaConfig();
	}

	private TeaConfig() {
		super();
	}

	public void configUse() {
		setTeaUse(TEA_USE);
		setSugarUse(SUGAR_USE);
		setMilkUse(MILK_USE);
		setWaterUse(WATER_USE);

	}

	public void configWaste() {
		setTeaWaste(TEA_WASTE);
		setSugarWaste(SUGAR_WASTE);
		setMilkWaste(MILK_WASTE);
		setWaterWaste(WATER_WASTE);

	}

	public void configDrinkType() {
		setDrinkType(DrinkTypeEnum.TEA);

	}

	public void configDrinkRate() {
		setRate(RATE);

	}

	public static IDrinkConfigurer getDrinkConfigurer() {
		return drinkConfigurer;
	}

}
