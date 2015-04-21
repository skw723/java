package com.java.storage;

import java.util.ArrayList;
import java.util.TreeMap;

import com.java.management.CarManagement;
import com.java.vo.RecordInfo;

/**
 * 운행기록들을 저장하는 클래스
 * @author 심규원
 *
 */
public class RecordStorage {
	private ArrayList<RecordInfo> recordList;
	
	/**
	 * 기본 생성자
	 */
	public RecordStorage(){
		recordList = new ArrayList<RecordInfo>();
	}
	/**
	 * 저장소 초기화
	 */
	public boolean clearList(){
		recordList.clear();
		return true;
	}
	/**
	 * 운행기록을 추가하는 메소드
	 * @param info - 추가할 운행기록
	 * @return - 성공여부
	 */
	public boolean addRecord(RecordInfo info){
		return recordList.add(info);
	}
	/**
	 * 일자별 소모량 계산 
	 * CarManagement의 calcCunsumption() 메소드를 통하여 소모량 계산
	 * @return - key:일자, value:소모량 구조의 Map을 리턴
	 */
	public TreeMap<String, Double> calcDailyConsumption(){
		CarManagement carMgt = CarManagement.getInstance();
		TreeMap<String, Double> returnMap = new TreeMap<String, Double>();
		for(int i=0; i<recordList.size(); i++){
			RecordInfo info = recordList.get(i);
			String carNumber = info.getCarNumber();
			int distance = info.getDistance();
			double consumption = carMgt.calcCunsuption(carNumber, distance);
			if(returnMap.containsKey(info.getDate())){
				consumption += returnMap.get(info.getDate());
			}
			returnMap.put(info.getDate(), consumption);
		}
		return returnMap;
	}
	/**
	 * 차량별 소모량 계산
	 * CarManagement의 calcCunsumption() 메소드를 통하여 소모량 계산
	 * @return - key:차량번호, value:소모량 구조의 Map을 리턴
	 */
	public TreeMap<String, Double> calcCarConsumption(){
		CarManagement carMgt = CarManagement.getInstance();
		TreeMap<String, Double> returnMap = new TreeMap<String, Double>();
		for(int i=0; i<recordList.size(); i++){
			RecordInfo info = recordList.get(i);
			String carNumber = info.getCarNumber();
			int distance = info.getDistance();
			double consumption = carMgt.calcCunsuption(carNumber, distance);
			if(returnMap.containsKey(info.getCarNumber())){
				consumption += returnMap.get(info.getCarNumber());
			}
			returnMap.put(info.getCarNumber(), consumption);
		}
		return returnMap;
	}
}
