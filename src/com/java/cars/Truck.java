package com.java.cars;

import com.java.vo.CarInfo;

public class Truck extends Car {
	public Truck(CarInfo input) {
		super(input);
		// TODO Auto-generated constructor stub
		super.getCarInfo().setCarType("Truck");
		super.getCarInfo().setRatio(0.9);
	}
}