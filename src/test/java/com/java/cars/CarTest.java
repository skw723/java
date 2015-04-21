package com.java.cars;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java.vo.CarInfo;

public class CarTest {
	private static CarInfo expectedInfo;

	@BeforeClass
	public static void beforeClass(){
		expectedInfo = new CarInfo();
		expectedInfo.setCarNumber("1가1111");
		expectedInfo.setMileage(10);
		expectedInfo.setCarType("Car");
		expectedInfo.setRatio(1.0);
	}
	@AfterClass
	public static void afterClass(){
		expectedInfo = null;
	}
	/**
	 * Car 인스턴스 생성 테스트
	 */
	@Test
	public void testCreateCar(){
		//given
		Car expected = new Car(expectedInfo);
		CarInfo carInfo = new CarInfo();
		carInfo.setCarNumber("1가1111");
		carInfo.setMileage(10);
		//when
		Car actual = new Car(carInfo);
		//then
		assertEquals(expected.getCarInfo().getCarNumber(), actual.getCarInfo().getCarNumber());
		assertEquals(expected.getCarInfo().getCarType(), actual.getCarInfo().getCarType());
		assertEquals(expected.getCarInfo().getMileage(), actual.getCarInfo().getMileage(), 0);
		assertEquals(expected.getCarInfo().getRatio(), actual.getCarInfo().getRatio(), 0);
	}
	/**
	 * CarInfo가 정상적으로 리턴되는지 테스트
	 */
	@Test
	public void testGetCarInfo(){
		//given
		Car car = new Car(expectedInfo);
		//when
		CarInfo actual = car.getCarInfo();
		//then
		assertThat(actual, notNullValue());
	}
	/**
	 * 연료 소모량계산 테스트
	 */
	@Test
	public void testCalcConsumption(){
		//given
		Car car = new Car(expectedInfo);
		int distance = 30;
		//expected = ratio(1.0) * mileage(10) * distance(30) = 300;
		double expected = 300.0;
		//when
		double actual = car.calcConsumption(distance);
		//then
		assertEquals(expected, actual, 0);
	}
}
