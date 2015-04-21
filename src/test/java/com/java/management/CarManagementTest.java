package com.java.management;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Constructor;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java.vo.CarInfo;

public class CarManagementTest {
	private CarManagement carManagement;
	private static CarInfo[] carInfo;

	/**
	 * 테스트에 사용될 CarInfo[] 세팅
	 */
	@BeforeClass
	public static void beforeClass(){
		carInfo = new CarInfo[2];

		carInfo[0] = new CarInfo();
		carInfo[0].setCarNumber("1가1111");
		carInfo[0].setMileage(10);

		carInfo[1] = new CarInfo();
		carInfo[1].setCarNumber("2나2222");
		carInfo[1].setMileage(5);
	}
	@AfterClass
	public static void afterClass(){
		
	}
	/**
	 * Car 인스턴스 생성 테스트
	 * 성공, 클래스를 못찾는 경우, CarInfo가 null인 3가지 경우 테스트
	 */
	@Test
	public void testCreateCar(){
		//given
		carManagement = CarManagement.getInstance();
		String successFileName = "Bus.txt";
		String nonExistFileName = "AAA.txt";
		//when
		boolean resultSuccess = carManagement.createCar(carInfo[0], successFileName);
		boolean resultNonExistFileName = carManagement.createCar(carInfo[0], nonExistFileName);
		boolean resultCarInfoIsNull = carManagement.createCar(null, successFileName);
		//then
		assertEquals(resultSuccess, true);
		assertEquals(resultNonExistFileName, false);
		assertEquals(resultCarInfoIsNull, false);
	}
	/**
	 * 클래스의 생성자를 찾는 테스트
	 * 성공, 실패 2가지 경우 테스트
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void testFindConstructor(){
		//given
		carManagement = CarManagement.getInstance();
		String existClassName = "Bus";
		String nonExistClassName = "AAA";
		//when
		Constructor resultSuccess = carManagement.findConstructor(existClassName);
		Constructor resultFail = carManagement.findConstructor(nonExistClassName);
		//then
		assertNotNull(resultSuccess);
		assertNull(resultFail);
	}
	/**
	 * 하나의 파일에서 읽은 정보를 가지고 Car 인스턴스들 생성 테스트
	 * 성공한 경우, 클래스를 못찾는경우 2가지 경우 테스트
	 */
	@Test
	public void testCreateCars(){
		//given
		carManagement = CarManagement.getInstance();
		String existFileName = "Truck.txt";
		String FileNameNonExistClass = "AAA.txt";
		int expectedSuccess = 2;
		int expectedFail = 0;
		//when
		int actualSuccess = carManagement.createCars(carInfo, existFileName);
		int actualFail = carManagement.createCars(carInfo, FileNameNonExistClass);
		//then
		assertEquals(expectedSuccess, actualSuccess);
		assertEquals(expectedFail, actualFail);
	}
	/**
	 * 차량의 연료 소모량을 계산
	 * 차량을 찾은경우, 찾지못한 경우 2가지 테스트
	 */
	@Test
	public void testCalcCunsumption(){
		//given
		carManagement = CarManagement.getInstance();
		String fileName = "Bus.txt";
		String carNumber = carInfo[0].getCarNumber();
		String nonExistCarNumber = "1라1341";
		carManagement.createCar(carInfo[0], fileName);
		int distance = 10;
		//expected = ratio(1.0) * distance(10) * mileage(10) = 100;
		double expectedSucess = 100;
		double expectedFail = 0;
		//when
		double actualSuccess = carManagement.calcCunsuption(carNumber, distance);
		double actualFail = carManagement.calcCunsuption(nonExistCarNumber, distance);
		//then
		assertEquals(expectedSucess, actualSuccess, 0);
		assertEquals(expectedFail, actualFail, 0);
	}
	@Test 
	public void testClearList(){
		//given
		carManagement = CarManagement.getInstance();
		boolean expected = true;
		//when
		boolean actual = carManagement.clearList();
		//then
		assertEquals(expected, actual);
	}
}
