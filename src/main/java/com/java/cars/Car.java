package com.java.cars;

import com.java.vo.CarInfo;

/**
 * Car 클래스
 * Car의 기본정보를 가지고 있는 CarInfo클래스를 필드로 가지고 있음
 * @author 심규원
 *
 */
public class Car {
	private CarInfo info;
	
	public Car(CarInfo input){
		this.info = input;
		this.info.setCarType("Car");
		this.info.setRatio(1.0);
	}
	/**
	 * CarInfo 객체를 획득
	 * @return - CarInfo 객체 리턴
	 */
	public CarInfo getCarInfo(){
		return info;
	}
	public double calcConsumption(int distance){
		return distance * (info.getMileage() * info.getRatio());
	}
}