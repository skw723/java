package com.java.management;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.TreeMap;

import org.junit.Test;

import com.java.cars.Bus;
import com.java.cars.Car;
import com.java.storage.CarStorage;
import com.java.vo.CarInfo;
import com.java.vo.RecordInfo;

public class RecordManagementTest {
	private RecordManagement recordManagement;
	private RecordInfo[] recordInfo;

	public RecordManagementTest(){
		setRecordInfo();
	}
	public void setRecordInfo(){
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
	/**
	 * Records 생성 테스트
	 * 성공, 실패(RecordInfo is null)인 2가지 경우 테스트	
	 */
	@Test
	public void testCreateRecords(){
		//given
		recordManagement = RecordManagement.getInstance();
		//when
		int actualSuccess = recordManagement.createRecords(recordInfo);
		int actualFailRecordInfoIsNull = recordManagement.createRecords(null);
		//then
		assertEquals(actualSuccess, 2);
		assertEquals(actualFailRecordInfoIsNull, 0);
	}
	/**
	 * 일자별 연료소모량 계산 테스트
	 */
	@Test
	public void testCalcDailyConsumption(){
		//given
		recordManagement = RecordManagement.getInstance();
		recordManagement.createRecords(recordInfo);
		//when
		TreeMap<String, Double> resultMap = recordManagement.calcDailyConsumption();
		//then
		assertEquals(2, resultMap.size());
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
		//when
		TreeMap<String, Double> resultMap = recordManagement.calcCarConsumption();
		//then
		assertEquals(1, resultMap.size());
	}
}
