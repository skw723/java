package com.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.java.vo.CarInfo;
import com.java.vo.RecordInfo;

public class UtilTest {
	/**
	 * CarInfo로 파싱이 가능한 데이터와 가능하지 않은 데이터를
	 * 같이 보내서 리턴되어오는 CarInfo 인스턴스 개수를 화인
	 */
	@Test
	public void testStringToCarInfo(){
		//given
		String[] data = {"가|12", "나|1.2", "XXX", "다1|"};
		int expectedValue = 2;
		//when
		CarInfo[] result = Util.StringToCarInfo(data);
		//then
		assertEquals(expectedValue, result.length);
	}
	/**
	 * RecordInfo로 파싱이 가능한 데이터와 가능하지 않은 데이터를
	 * 같이 보내서 리턴되어오는 RecordInfo 인스턴스 개수를 확인
	 */
	@Test
	public void testStringToRecordInfo(){
		//given
		String[] data = {"가|12", "나|1.2", "XXX", "다1|"};
		String fileName = "20150421";
		int expectedValue = 1;
		//when
		RecordInfo[] result = Util.StringToRecordInfo(data, fileName);
		//then
		assertEquals(expectedValue, result.length);
	}
}
