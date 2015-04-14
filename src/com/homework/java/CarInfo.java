package com.homework.java;

/**
 * Car 객체의 기본정보를 가지고 있는 Value Object
 * @author 심규원
 *
 */
public class CarInfo {
	private int id;
	private double mileage;
	private String carNumber;
	private String carType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
}
