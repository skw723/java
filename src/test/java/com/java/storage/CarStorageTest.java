package com.java.storage;

import org.junit.Test;

import com.java.cars.Bus;
import com.java.cars.Car;
import com.java.vo.CarInfo;

import static org.junit.Assert.*;

public class CarStorageTest {
	private CarStorage carStorage;
	
	public CarStorageTest(){
		carStorage = new CarStorage();
	}
	/**
	 * addCar(), getCar() 메소드 테스트
	 * add한 인스턴스와 get한 인스턴스가 같으면 성공
	 */
	@Test
	public void testAddCar(){
		//given
		String carNumber = "1가1111";
		CarInfo carInfo = new CarInfo();
		carInfo.setCarNumber(carNumber);
		carInfo.setMileage(15);
		Car car = new Bus(carInfo);
		//when
		carStorage.addCar(car);
		Car returnCar = carStorage.getCar(carNumber);
		//then
		assertSame(car, returnCar);
	}
}
