package com.java.cars;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java.vo.CarInfo;

public class BusTest {
	private static CarInfo expectedInfo;
	
	@BeforeClass
	public static void beforeClass(){
		expectedInfo = new CarInfo();
		expectedInfo.setCarNumber("1가1111");
		expectedInfo.setMileage(10);
		expectedInfo.setCarType("Bus");
		expectedInfo.setRatio(1.0);
	}
	@AfterClass
	public static void afterClass(){
		expectedInfo = null;
	}
	/**
	 * Bus 인스턴스 생성 테스트
	 */
	@Test
	public void testCreateBus(){
		//given
		Car expected = new Bus(expectedInfo);
		CarInfo carInfo = new CarInfo();
		carInfo.setCarNumber("1가1111");
		carInfo.setMileage(10);
		//when
		Car actual = new Bus(carInfo);
		//then
		assertEquals(expected.getCarInfo().getCarNumber(), actual.getCarInfo().getCarNumber());
		assertEquals(expected.getCarInfo().getCarType(), actual.getCarInfo().getCarType());
		assertEquals(expected.getCarInfo().getMileage(), actual.getCarInfo().getMileage(), 0);
		assertEquals(expected.getCarInfo().getRatio(), actual.getCarInfo().getRatio(), 0);
	}
}
