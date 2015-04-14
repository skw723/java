package com.homework.java;

import java.util.Scanner;

/**
 * stdin을 관리하는 클래스
 * Singleton 구현
 * @author 심규원
 *
 */
public class InputManagement {
	private Scanner stdin;
	private static InputManagement instance;

	private InputManagement() {
		super();
		stdin = new Scanner(System.in);
	}
	/**
	 * InputManagement 의 객체를 획득하는 메소드
	 * @return - InputMagagement의 객체
	 */
	public static InputManagement getInstance(){
		if(instance == null){
			instance = new InputManagement();
		}
		return instance;
	}
	/**
	 * String으로 한줄을 입력받음
	 * @return - 입력받은 String
	 */
	public String readString(){
		return stdin.nextLine();
	}
	/**
	 * menuCode를 입력받음
	 * @return - Integer형으로 리턴
	 * @throws NumberFormatException
	 */
	public int readMenuCode() throws NumberFormatException{
		return Integer.parseInt(stdin.nextLine());
	}
	/**
	 * Double형으로 입력받음
	 * @return Double형으로 리턴
	 * @throws NumberFormatException
	 */
	public Double readDouble() throws NumberFormatException{
		return Double.parseDouble(stdin.nextLine());
	}
	/**
	 * Car 객체를 생성하는데 필요한 CarInfo 를 입력받음
	 * @param carType - 입력받을 Car의 CarType
	 * @return - 입력받은 CarInfo의 객체
	 * @throws NumberFormatException
	 */
	public CarInfo readCarInfo(String carType) throws NumberFormatException{
		CarInfo result = new CarInfo();
		
		result.setCarType(carType);
		System.out.printf("%s를 등록합니다. 차량번호를 입력하세요 : ", carType);
		result.setCarNumber(readString());
		System.out.print("연비를 입력하세요 : ");
		result.setMileage(readDouble());
		
		return result;
	}
}