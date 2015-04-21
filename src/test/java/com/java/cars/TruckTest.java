package com.java.cars;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.java.vo.CarInfo;

public class TruckTest {
	/**
	 * Truck 인스턴스 생성 테스트
	 */
	@Test
	public void testCreateTruc(){
		//given
		Object[] expecteds = new Object[2];
		expecteds[0] = "Truck";
		expecteds[1] = 0.9;
		//when
		CarInfo carInfo = new CarInfo();
		carInfo.setCarNumber("가1234");
		carInfo.setMileage(10);
		Truck truck = new Truck(carInfo);
		Object[] actuals = new Object[2];
		actuals[0] = truck.getCarInfo().getCarType();
		actuals[1] = truck.getCarInfo().getRatio();
		//then
		assertArrayEquals(expecteds, actuals);
	}
}
