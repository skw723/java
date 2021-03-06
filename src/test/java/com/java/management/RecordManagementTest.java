package com.java.management;

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
import com.java.storage.CarStorage;
import com.java.vo.CarInfo;
import com.java.vo.RecordInfo;

public class RecordManagementTest {
	private RecordManagement recordManagement;
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
		recordInfo[1].setDate("20150422");
	}
	@AfterClass
	public static void afterClass(){
		recordInfo = null;
	}
	/**
	 * Records 생성 테스트
	 * 성공, 실패(RecordInfo is null)인 2가지 경우 테스트	
	 */
	@Test
	public void testCreateRecords(){
		//given
		recordManagement = RecordManagement.getInstance();
		int expectedSuccess = 2;
		int expectedFail = 0;
		//when
		int actualSuccess = recordManagement.createRecords(recordInfo);
		int actualFailRecordInfoIsNull = recordManagement.createRecords(null);
		//then
		assertEquals(expectedSuccess, actualSuccess);
		assertEquals(expectedFail, actualFailRecordInfoIsNull);
	}
	/**
	 * 일자별 연료소모량 계산 테스트
	 */
	@Test
	public void testCalcDailyConsumption(){
		//given
		recordManagement = RecordManagement.getInstance();
		recordManagement.createRecords(recordInfo);
		int expected = 2;
		//when
		TreeMap<String, Double> resultMap = recordManagement.calcDailyConsumption();
		//then
		assertEquals(expected, resultMap.size());
	}
	@Test
	public void testCalcCarConsumption(){
		//given
		CarInfo carInfo = new CarInfo();
		carInfo.setCarNumber("1가1111");
		carInfo.setMileage(10);
		Car returnCar = new Bus(carInfo);
		CarStorage carStorageMock = mock(CarStorage.class);
		when(carStorageMock.getCar(anyString())).thenReturn(returnCar);
		recordManagement = RecordManagement.getInstance();
		recordManagement.createRecords(recordInfo);
		int expected = 1;
		//when
		TreeMap<String, Double> resultMap = recordManagement.calcCarConsumption();
		//then
		assertEquals(expected, resultMap.size());
	}
	@Test
	public void testClearList(){
		//given
		recordManagement = RecordManagement.getInstance();
		boolean expected = true;
		//when
		boolean actual = recordManagement.clearList();
		//then
		assertEquals(expected, actual);
	}
}
