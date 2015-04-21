package com.java.cars;

import com.java.vo.CarInfo;

public class Bus extends Car {
	public Bus(CarInfo input) {
		super(input);
		// TODO Auto-generated constructor stub
		super.getCarInfo().setCarType("Bus");
		super.getCarInfo().setRatio(1.0);
	}
}