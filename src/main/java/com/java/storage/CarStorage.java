package com.java.storage;

import java.util.TreeMap;

import com.java.cars.Car;

/**
 * Car인스턴스를 저장하는 저장소
 * @author 심규원
 *
 */
public class CarStorage {
	private TreeMap<String, Car> carMap;
	
	/**
	 * 기본 생성자
	 */
	public CarStorage(){
		carMap = new TreeMap<String, Car>();
	}
	/**
	 * Car 인스턴스를 추가하는 메소드
	 * @param car - 저장할 인스턴스
	 * @return - 성공여부
	 */
	public boolean addCar(Car car){
		String key = car.getCarInfo().getCarNumber();
		carMap.put(key, car);
		return true;
	}
	/**
	 * 해당 차량번호를 가진 인스턴스를 리턴하는 메소드
	 * @param carNumber - 차량번호
	 * @return - 해당 Car의 인스턴스, 해당 인스턴스가 없는경우 null
	 */
	public Car getCar(String carNumber){
		return carMap.get(carNumber);
	}
	/**
	 * 저장소 초기화
	 */
	public void clearMap(){
		carMap.clear();
	}
}
