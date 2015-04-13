package com.homework.java;

/**
 * Car 관리 클래스(배열사용)
 * @author 심규원
 *
 */
public class CarManagement {
	private Car[] cars;
	private int carId = 0;
	private int maxCars;
	
	/**
	 * 생성자
	 * @param maxCars - cars 배열의 크기 
	 */
	public CarManagement(int maxCars){
		this.maxCars = maxCars;
		cars = new Car[maxCars];
	}
	
	/**
	 * 저장된 모든 Car의 정보 출력
	 */
	public String viewAllCar(){
		String result = new String();
		for(int i=0; i<maxCars; i++){
			if(cars[i] != null){
				result += cars[i].getDetails();				
			}
		}
		return result;
	}
	
	/**
	 * Car 생성
	 * create 작업 시 배열의 이동 없음(최대 maxCars만 create가능)
	 * @param carType - Car종류
	 * @param carNumber - 차량번호
	 * @param mileage - 마일리지
	 * @return
	 */
	public boolean createCar(String carType, String carNumber, double mileage){
		if(carId > maxCars){
			return false;
		}
		else{
			cars[carId] = new Car(carType, carId, mileage, carNumber);
			carId++;
			return true;
		}
	}
	
	/**
	 * Car 삭제
	 * delete 작업 시 배열의 이동 없음
	 * @param carId
	 * @return
	 */
	public boolean deleteCar(int carId){
		if(carId < 0 || carId > this.carId){
			return false;
		}
		else{
			cars[carId] = null;
			return true;
		}
	}
}
