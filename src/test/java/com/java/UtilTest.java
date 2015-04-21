package com.java;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java.vo.CarInfo;
import com.java.vo.RecordInfo;

public class UtilTest {
	private static String[] beforeCarInfo;
	private static String[] beforeRecordInfo;
	
	@BeforeClass
	public static void beforeClass(){
		beforeCarInfo = new String[]{"1가1111|10", "2나/5.5"};	
		beforeRecordInfo = new String[]{"1가1111|10", "2나|5.5"};
	}
	@AfterClass
	public static void afterClass(){
		beforeCarInfo = null;
		beforeRecordInfo = null;
	}
	/**
	 * CarInfo로 파싱이 가능한 데이터와 가능하지 않은 데이터를
	 * 보내서 리턴되어오는 CarInfo 인스턴스 개수를 화인
	 */
	@Test
	public void testStringToCarInfo(){
		//given
		int expected = 1;
		//when
		CarInfo[] actuals = Util.StringToCarInfo(beforeCarInfo);
		//then
		assertEquals(expected, actuals.length);
	}
	/**
	 * RecordInfo로 파싱이 가능한 데이터와 가능하지 않은 데이터를
	 * 보내서 리턴되어오는 RecordInfo 인스턴스 개수를 확인
	 */
	@Test
	public void testStringToRecordInfo(){
		//given
		String fileName = "20150421";
		int expected = 1;
		//when
		RecordInfo[] results = Util.StringToRecordInfo(beforeRecordInfo, fileName);
		//then
		assertEquals(expected, results.length);
	}
}
