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
	private CarManagement carManagement;
	private RecordManagement recordManagement;
	private InputManager inputManager;
	private OutputManager outputManager;

	/**
	 * 인스턴스 생성 시 input, output에 사용할 클래스 설정
	 * @param input - input에 사용될 클래스
	 * @param output - output에 사용될 클래스
	 */
	public CarManager(InputManager input, OutputManager output){
		carManagement = CarManagement.getInstance();
		recordManagement = RecordManagement.getInstance();
		this.inputManager = input;
		this.outputManager = output;
	}
	/**
	 * CarManager 시작메소드
	 * 순차저긍로 차량등록, 운행기록 등록, 일자별,차량별 소모량 표시
	 */
	public void startManager(){
		procAddCars();
		procAddRecords();
		printDailyConsumption();
		printCarConsumption();
		stopManager();
	}
	/**
	 * 차량 추가 화면 출력
	 */
	private void procAddCars(){
		outputManager.printBeforeAddCars();
		int addedCars = addCars();
		outputManager.printAfterAddCars(addedCars);
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
	private int addCars() {
		int addedCount = 0;
		String []fileNames = inputManager.getFileNames(Main.txtListPath);
		carManagement.clearList();
		for(int i=0; i<fileNames.length; i++){
			String[] strInfo = inputManager.readFile(fileNames[i], Main.txtListPath);
			CarInfo[] info = Util.StringToCarInfo(strInfo);
			addedCount += carManagement.createCars(info, fileNames[i]);
		}
		return addedCount;
	}
	/**
	 * 운행기록 추가화면 출력
	 */
	private void procAddRecords() {
		outputManager.printBeforeAddRecord();
		int addedRecord = addRecords();
		outputManager.printAfterAddRecord(addedRecord);
	}
	/**
	 * 종료화면 출력
	 */
	private void stopManager() {
		outputManager.printExit();
	}
	/**
	 * 차량별 연료 소모량 출력
	 */
	private void printCarConsumption() {
		// TODO Auto-generated method stub
		outputManager.printBeforeConsumption("차량별");
		TreeMap<String, Double> results = recordManagement.calcCarConsumption();
		outputManager.printAfterConsumption(results);
	}
	/**
	 * 일자별 연료 소모량 출력
	 */
	private void printDailyConsumption() {
		// TODO Auto-generated method stub
		outputManager.printBeforeConsumption("일자별");
		TreeMap<String, Double> results = recordManagement.calcDailyConsumption();
		outputManager.printAfterConsumption(results);
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
	private int addRecords() {
		// TODO Auto-generated method stub
		int addedCount = 0;
		String []fileNames = inputManager.getFileNames(Main.txtOrderPath);
		recordManagement.clearList();
		for(int i=0; i<fileNames.length; i++){
			String[] strInfo = inputManager.readFile(fileNames[i], Main.txtOrderPath);
			RecordInfo[] info = Util.StringToRecordInfo(strInfo, fileNames[i]);
			addedCount += recordManagement.createRecords(info);
		}
		return addedCount;
	}
}