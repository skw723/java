package com.java.cars;

import com.java.vo.CarInfo;

public class Taxi extends Car {
	public Taxi(CarInfo input) {
		super(input);
		// TODO Auto-generated constructor stub
		super.getCarInfo().setCarType("Taxi");
		super.getCarInfo().setRatio(0.8);
	}
}