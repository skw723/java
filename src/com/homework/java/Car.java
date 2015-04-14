package com.homework.java;

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
	}
	/**
	 * Car의 정보를 표시
	 * @return - Car의 정보를 String으로 리턴
	 */
	public String getDetails(){
		return String.format("%-10s id:%-3d 차량번호:%-10s 연비:%-4f\n", info.getCarType(), 
				info.getId(), info.getCarNumber(), info.getMileage());
	}
	/**
	 * CarInfo 객체를 획득
	 * @return - CarInfo 객체 리턴
	 */
	public CarInfo getCarInfo(){
		return info;
	}
}