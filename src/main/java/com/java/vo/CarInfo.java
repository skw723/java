package com.java.vo;

/**
 * Car 객체의 기본정보를 가지고 있는 Value Object
 * mileage - 연비
 * carNumber - 차량번호
 * carType - 차량 종류
 * ratio - 연비 보정율
 * @author 심규원
 *
 */
public class CarInfo {
	private double mileage;
	private String carNumber;
	private String carType;
	private double ratio;
	
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
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
