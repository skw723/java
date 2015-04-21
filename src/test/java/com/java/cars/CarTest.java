package com.java.cars;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.java.vo.CarInfo;

public class CarTest {
	/**
	 * Car 인스턴스 생성 테스트
	 */
	@Test
	public void testCreateCar(){
		//given
		Object[] expecteds = new Object[2];
		expecteds[0] = "Car";
		expecteds[1] = 1.0;
		//when
		CarInfo carInfo = new CarInfo();
		carInfo.setCarNumber("가1234");
		carInfo.setMileage(10);
		Car car = new Car(carInfo);
		Object[] actuals = new Object[2];
		actuals[0] = car.getCarInfo().getCarType();
		actuals[1] = car.getCarInfo().getRatio();
		//then
		assertArrayEquals(expecteds, actuals);
	}
	/**
	 * CarInfo가 정상적으로 리턴되는지 테스트
	 */
	@Test
	public void testGetCarInfo(){
		//given
		CarInfo carInfo = new CarInfo();
		carInfo.setCarNumber("가1234");
		carInfo.setMileage(10);
		Car car = new Car(carInfo);
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
		CarInfo carInfo = new CarInfo();
		carInfo.setCarNumber("가1234");
		carInfo.setMileage(10);
		Car car = new Car(carInfo);
		int distance = 30;
		//expected = ratio(1.0) * mileage(10) * distance(30) = 300;
		double expected = 300.0;
		//when
		double actual = car.calcConsumption(distance);
		//then
		assertEquals(expected, actual, 0);
	}
}
