package com.java;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java.io.impl.ConsoleOutputManager;
import com.java.io.impl.FileInputManager;


public class CarManagerTest {
	private static CarManager carManager;
	@BeforeClass
	public static void beforeClass(){
		carManager = new CarManager(new FileInputManager(), new ConsoleOutputManager());
	}
	@AfterClass
	public static void afterClass(){
		carManager = null;
	}
	/**
	 * 최대 대기시간 3초
	 */
	@Test(timeout = 3000)
	public void testStartManager(){
		carManager.startManager();
	}
}