package com.java;

import com.java.io.InputManager;
import com.java.io.impl.ConsoleOutputManager;
import com.java.io.impl.DataInputManager;



/**
 * main 메소드가 있는 클래스
 * CarManager에게 제어권 위임
 * 상수 정의
 * input, ouuput 클래스를 CarManager에게 전달
 * @author 심규원
 *
 */
public class Main {
	private static CarManager carManager;
	public static final String txtListPath = "./list";
	public static final String txtOrderPath = "./order";
	public static final String carsPackagePath = "com.java.cars";
	
	public static void main(String[] args) {
		InputManager input = new DataInputManager();
		ConsoleOutputManager output = new ConsoleOutputManager();
		carManager = new CarManager(input, output);
		carManager.startManager();
	}
}