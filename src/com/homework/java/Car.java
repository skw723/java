package com.homework.java;

/**
 * Car 클래스
 * @author 심규원
 *
 */
public class Car {
	private int id;
	private double mileage;
	private String carNumber;
	private String carType;
	
	/**
	 * Car 생성자
	 * @param carType - Car종류
	 * @param id - CarId
	 * @param mileage - 연비
	 * @param carNumber - 차량번호
	 */
	public Car(String carType, int id, double mileage, String carNumber){
		this.carType = carType;
		this.id = id;
		this.mileage = mileage;
		this.carNumber = carNumber;
	}
	
	/**
	 * Car정보를 출력하는 함수(carType, id, carNumber, mileage)
	 */
	public String getDetails(){
		return String.format("%-10s id:%-3d 차량번호:%-10s 연비:%-4f\n", carType, id, carNumber, mileage);
	}
}
