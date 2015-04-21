package com.java.storage;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.TreeMap;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java.cars.Bus;
import com.java.cars.Car;
import com.java.vo.CarInfo;
import com.java.vo.RecordInfo;

public class RecordStorageTest {
	private static RecordStorage recordStorage;
	private static RecordInfo[] recordInfo;

	@BeforeClass
	public static void beforeClass(){
		recordInfo = new RecordInfo[2];
		recordInfo[0] = new RecordInfo();
		recordInfo[0].setCarNumber("1가1111");
		recordInfo[0].setDistance(20);
		recordInfo[0].setDate("20150421");
		recordInfo[1] = new RecordInfo();
		recordInfo[1].setCarNumber("1가1111");
		recordInfo[1].setDistance(10);
		recordInfo[1].setDate("20150421");
	}
	@AfterClass
	public static void afterClass(){
		recordStorage = null;
	}
	@Test
	public void testclearList(){
		//given
		recordStorage = new RecordStorage();
		boolean expected = true;
		//when
		boolean actual = recordStorage.clearList();
		//then
		assertEquals(expected, actual);
	}
	/**
	 * 레코드추가 테스트
	 */
	@Test
	public void testAddRecord(){
		//given
		recordStorage = new RecordStorage();
		RecordInfo recordInfo = new RecordInfo();
		//when
		boolean isSuccess = recordStorage.addRecord(recordInfo);		
		//then
		assertEquals(true, isSuccess);
	}
	@Test
	public void testCalcDailyConsumption(){
		//given
		recordStorage = new RecordStorage();
		recordStorage.calcDailyConsumption();
		recordStorage.addRecord(recordInfo[0]);
		recordStorage.addRecord(recordInfo[1]);
		int expected = 1;
		//when
		TreeMap<String, Double> resultMap = recordStorage.calcDailyConsumption();
		//then
		assertEquals(expected, resultMap.size());
	}
	@Test
	public void testCalcCarConsumption(){
		//given
		recordStorage = new RecordStorage();
		CarInfo carInfo = new CarInfo();
		carInfo.setCarNumber("1가1111");
		carInfo.setMileage(10);
		Car returnCar = new Bus(carInfo);
		CarStorage carStorageMock = mock(CarStorage.class);
		when(carStorageMock.getCar(anyString())).thenReturn(returnCar);
		recordStorage.addRecord(recordInfo[0]);
		recordStorage.addRecord(recordInfo[1]);
		int expected = 1;
		//when
		TreeMap<String, Double> resultMap = recordStorage.calcCarConsumption();
		//then
		assertEquals(expected, resultMap.size());
	}
}
