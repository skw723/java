package com.java.storage;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import com.java.vo.RecordInfo;

public class RecordStorageTest {
	private static RecordStorage recordStorage;
	@BeforeClass
	public static void beforeClass(){
		recordStorage = new RecordStorage();
	}
	@Test
	public void testAddRecord(){
		//given
		RecordInfo recordInfo = new RecordInfo();
		//when
		boolean isSuccess = recordStorage.addRecord(recordInfo);		
		//then
		assertEquals(true, isSuccess);
	}
}
