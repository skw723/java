package com.java.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java.cars.Bus;
import com.java.cars.Car;
import com.java.vo.CarInfo;

public class CarStorageTest {
	private static CarStorage carStorage;
	
	@BeforeClass
	public static void beforeClass(){
		carStorage = new CarStorage();
	}
	@AfterClass
	public static void afterClass(){
		carStorage = null;
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
	@Test
	public void testclearMap(){
		//given
		boolean expected = true;
		//when
		boolean actual = carStorage.clearMap();
		//then
		assertEquals(expected, actual);		
	}
}
