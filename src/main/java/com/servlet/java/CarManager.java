package com.servlet.java;

import java.util.Set;
import java.util.TreeMap;

import com.java.Main;
import com.java.Util;
import com.java.io.InputManager;
import com.java.io.OutputManager;
import com.java.management.CarManagement;
import com.java.vo.CarInfo;

/**
 * 실질적인 기능을 담당하는 클래스
 * main 메소드에서 위임받아 기능수행
 * @author 심규원
 *
 */
public class CarManager {
	private CarManagement carManagement;
	private InputManager inputManager;
	private OutputManager outputManager;
	private String realPath;

	/**
	 * 인스턴스 생성 시 input, output에 사용할 클래스 설정
	 * @param input - input에 사용될 클래스
	 * @param output - output에 사용될 클래스
	 */
	public CarManager(InputManager input, OutputManager output, String realPath){
		carManagement = CarManagement.getInstance();
		this.inputManager = input;
		this.outputManager = output;
		this.realPath = realPath;
	}
	/**
	 * 차량 추가 화면 출력
	 */
	public void procAddCars(){
		int addedCars = addCars();
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
		String []fileNames = inputManager.getFileNames(realPath + Main.txtListPath);
		carManagement.clearList();
		for(int i=0; i<fileNames.length; i++){
			String[] strInfo = inputManager.readFile(fileNames[i], realPath + Main.txtListPath);
			CarInfo[] info = Util.StringToCarInfo(strInfo);
			addedCount += carManagement.createCars(info, fileNames[i]);
		}
		return addedCount;
	}
	/**
	 * 저장된 차량 번호들을 리턴하는 메소드
	 * @return - 차량 번호들
	 */
	public String[] getCarNumbers(){
		Set<String> carNumbers = carManagement.getCarNumbers();
		return carNumbers.toArray(new String[carNumbers.size()]);
	}
	public TreeMap<String, Double> calcConsumption(String[] carNumbers, String[] distances){
		TreeMap<String, Double> resultData = new TreeMap<String, Double>();
		int count = carNumbers.length;
		for(int i=0; i<count; i++){
			String carNumber = carNumbers[i];
			int distance = 0;
			try{				
				distance = Integer.parseInt(distances[i]);
			}catch(NumberFormatException e){
				resultData.put(carNumber, (double) -1);
			}
			resultData.put(carNumber, carManagement.calcCunsuption(carNumber, distance));
		}
		return resultData;
	}
}
