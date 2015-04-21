package com.java.cars;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.java.vo.CarInfo;

public class BusTest {
	/**
	 * Bus 인스턴스 생성 테스트
	 */
	@Test
	public void testCreateBus(){
		//given
		Object[] expecteds = new Object[2];
		expecteds[0] = "Bus";
		expecteds[1] = 1.0;
		//when
		CarInfo carInfo = new CarInfo();
		carInfo.setCarNumber("가1234");
		carInfo.setMileage(10);
		Bus bus = new Bus(carInfo);
		Object[] actuals = new Object[2];
		actuals[0] = bus.getCarInfo().getCarType();
		actuals[1] = bus.getCarInfo().getRatio();
		//then
		assertArrayEquals(expecteds, actuals);
	}
}
