package com.java;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.java.io.InputManager;
import com.java.io.OutputManager;
import com.java.io.impl.ConsoleOutputManager;
import com.java.io.impl.DataInputManager;

public class CarManagerTest {
	private CarManager carManager;
	private InputManager inputManager;
	private OutputManager outputManager;
	
	public CarManagerTest() {
		inputManager = new DataInputManager();
		outputManager = new ConsoleOutputManager();
		carManager = new CarManager(inputManager, outputManager);
	}
//	@Test
//	public void testStartManager(){
//		carManager.startManager();
//	}
//	@Test
//	public void testPrintMain(){
//		carManager.printMain();
//	}
//	@Test
//	public void testPrintAddCar(){
//		carManager.printAddCar();
//	}
//	@Test
//	public void testAddCar(){
//		assertThat(carManager.addCar(), instanceOf(Integer.class));
//	}
//	@Test
//	public void testPrintAddRecord(){
//		carManager.printAddRecord();
//	}
//	@Test
//	public void testPrintViewConsumption(){
//		carManager.printViewConsumption();
//	}
//	@Test
//	public void testPrintExit(){
//		carManager.printExit();
//	}
//	@Test
//	public void testMoveMenu(){
//		carManager.moveMenu(0);
//	}
//	@Test
//	public void testUpMenu(){
//		carManager.upMenu();
//	}
//	@Test
//	public void testIsExit(){
//		carManager.isExit();
//	}
//	@Test
//	public void testIncorrectValue(){
//		carManager.incorrectValue();
//	}
//	@Test
//	public void testPrintCurrentView(){
//		carManager.printCurrentView();
//	}
//	@Test
//	public void testPrintCarCunsumption(){
//		carManager.printCarConsumption();
//	}
//	@Test
//	public void testPrintDailyCunsumption(){
//		carManager.printDailyConsumption();
//	}
//	@Test
//	public void testAddRecord(){
//		carManager.addRecord();
//	}
}
