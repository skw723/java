package com.java;

import java.util.TreeMap;

import com.java.io.InputManager;
import com.java.io.OutputManager;
import com.java.management.CarManagement;
import com.java.management.RecordManagement;
import com.java.vo.CarInfo;
import com.java.vo.RecordInfo;

/**
 * 실질적인 기능을 담당하는 클래스
 * main 메소드에서 위임받아 기능수행
 * @author 심규원
 *
 */
public class CarManager {
	private MenuType currentView;
	private CarManagement carManager;
	private RecordManagement recordManager;
	private InputManager inputManager;
	private OutputManager outputManager;

	/**
	 * 인스턴스 생성 시 input, output에 사용할 클래스 설정
	 * @param input - input에 사용될 클래스
	 * @param output - output에 사용될 클래스
	 */
	public CarManager(InputManager input, OutputManager output){
		currentView = MenuType.Main;
		carManager = CarManagement.getInstance();
		recordManager = RecordManagement.getInstance();
		this.inputManager = input;
		this.outputManager = output;
	}
	/**
	 * CarManager 시작 메소드
	 */
	public void startManager(){
		while(!isExit()){
			printCurrentView();
			int menuCode = 0;
			try{
				menuCode = inputManager.readInteger();
				moveMenu(menuCode);
			}catch(NumberFormatException e){
				incorrectValue();
			}
		}
		printCurrentView();
	}
	/**
	 * 메인화면 출력
	 */
	protected void printMain() {
		outputManager.printMain();
	}
	/**
	 * 차량 추가 화면 출력
	 */
	protected void printAddCar(){
		outputManager.printBeforeAddCar();
		int addedCar = addCar();
		outputManager.printAfterAddCar(addedCar);
		upMenu();
		printMain();
	}
	/**
	 * 차량을 추가하는 메소드
	 * 1. 파일 리스트를 가져옴
	 * 2. 파일 하나의 데이터를 읽어옴
	 * 3. 읽어온 데이터를 크리에이트에 전달
	 * 4. 2~3반복
	 * 5. 모든 파일 완료 후 최종적으로 추가된 차 개수 리턴
	 * @return - 추가된 차량의 개수
	 */
	protected int addCar() {
		int addedCount = 0;
		String []fileNames = inputManager.getFileNames(Main.txtListPath);
		if(fileNames == null){
			return 0;
		}
		else{
			carManager.clearList();
			for(int i=0; i<fileNames.length; i++){
				String[] strInfo = inputManager.readFile(fileNames[i], Main.txtListPath);
				CarInfo[] info = Util.StringToCarInfo(strInfo);
				addedCount += carManager.createCars(info, fileNames[i]);
			}
			return addedCount;			
		}
	}
	/**
	 * 운행기록 추가화면 출력
	 */
	protected void printAddRecord() {
		outputManager.printBeforeAddRecord();
		int addedRecord = addRecord();
		outputManager.printAfterAddRecord(addedRecord);
		upMenu();
		printMain();
	}
	/**
	 * 연료 소모량 화면 출력
	 */
	protected void printViewConsumption() {
		outputManager.printViewConsumption();
	}
	/**
	 * 종료화면 출력
	 */
	protected void printExit() {
		outputManager.printExit();
	}
	/**
	 * 이동가능한 메뉴인지 확인 후 이동하려는 메뉴로 currentView를 설정
	 * @param menuCode - 이동할 메뉴코드
	 */
	protected void moveMenu(int menuCode){
		//menuCode를 사용하여 해당화면으로 이동
		MenuType menu = MenuType.isMoveable(menuCode, currentView.getMenuCode());
		if(menu == null){
			incorrectValue();				
		}
		else if(menu == MenuType.Up){
			upMenu();
		}
		else{
			currentView = MenuType.findMenu(menuCode);			
		}
	}
	/**
	 * 현재 메뉴의 상위 메뉴로 currentView 설정
	 */
	protected void upMenu(){
		//menuCode를 사용하여 해당화면으로 이동
		currentView = MenuType.findMenu(currentView.getParentMenuCode());
	}
	/**
	 * 현재 currentView 가 Exit인지 확인
	 * @return - 확인 결과
	 */
	protected boolean isExit(){
		if(currentView == MenuType.Exit){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 메뉴 입력이 잘못된 경우 메시지 출력
	 */
	protected void incorrectValue(){
		outputManager.printIncorrectValue();
	}
	/**
	 * 현재 설정된 currentView를 출력
	 */
	protected void printCurrentView(){
		switch(currentView){
		case Main:
			printMain();
			break;
		case AddCar:
			printAddCar();
			break;
		case AddRecord:
			printAddRecord();
			break;
		case ViewConsumption:
			printViewConsumption();
			//upMenu();
			break;
		case Exit:
			printExit();
			break;
		case DailyConsumption:
			printDailyConsumption();
			break;
		case CarConsumption:
			printCarConsumption();
			break;
		case Up:
		}
	}
	/**
	 * 차량별 연료 소모량 출력
	 */
	protected void printCarConsumption() {
		// TODO Auto-generated method stub
		outputManager.printBeforeConsumption("차량별");
		TreeMap<String, Double> result = recordManager.calcCarConsumption();
		outputManager.printAfterConsumption(result);
		upMenu();
		printCurrentView();
	}
	/**
	 * 일자별 연료 소모량 출력
	 */
	protected void printDailyConsumption() {
		// TODO Auto-generated method stub
		outputManager.printBeforeConsumption("일자별");
		TreeMap<String, Double> result = recordManager.calcDailyConsumption();
		outputManager.printAfterConsumption(result);
		upMenu();
		printCurrentView();
	}

	/**
	 * 파일에서 운행기록을 읽어오는 메소드
	 * 1. 파일 리스트를 가져옴
	 * 2. 파일 하나의 데이터를 읽어옴
	 * 3. 읽어온 데이터를 크리에이트에 전달
	 * 4. 2~3반복
	 * 5. 모든 파일 완료 후 최종적으로 추가된 기록 개수 리턴
	 * @return - 추가된 운행기로 개수
	 */
	protected int addRecord() {
		// TODO Auto-generated method stub
		int addedCount = 0;
		String []fileNames = inputManager.getFileNames(Main.txtOrderPath);
		if(fileNames == null){
			return 0;
		}
		recordManager.clearList();
		for(int i=0; i<fileNames.length; i++){
			String[] strInfo = inputManager.readFile(fileNames[i], Main.txtOrderPath);
			RecordInfo[] info = Util.StringToRecordInfo(strInfo, fileNames[i]);
			addedCount += recordManager.createRecords(info);
		}
		return addedCount;
	}
}