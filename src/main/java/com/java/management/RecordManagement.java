package com.java.management;

import java.util.TreeMap;

import com.java.storage.RecordStorage;
import com.java.vo.RecordInfo;


/**
 * 운행기록을 관리하는 클래스
 * RecordStorage를 통해 관리
 * singleton 구현
 * @author 심규원
 *
 */
public class RecordManagement {
	private RecordStorage storage;
	private static RecordManagement instance;

	/**
	 * 기본 생성자
	 */
	private RecordManagement(){
		storage = new RecordStorage();
	}
	public static RecordManagement getInstance(){
		if(instance == null){
			instance = new RecordManagement();
		}
		return instance;
	}
	/**
	 * 하나의 파일에서 획득한 운행기록을 저장
	 * @param info - 획득한 RecordInfo들 
	 * @return - 성공 횟수
	 */
	public int createRecords(RecordInfo[] info){
		int addedCount = 0;
		if(info == null){
			return addedCount;
		}
		for(int i=0; i<info.length; i++){
			storage.addRecord(info[i]);
			addedCount++;
		}
		return addedCount;
	}
	/**
	 * 일자별 연료 소모량을 계산하는 메소드
	 * @return - key:일자, value:소모량 구조의 Map을 리턴
	 */
	public TreeMap<String, Double> calcDailyConsumption(){
		return storage.calcDailyConsumption();
	}
	/**
	 * 차량별로 연료 소모량을 계산하는 메소드
	 * @return - key:차량번호, value:소모량 구조의 Map을 리턴
	 */
	public TreeMap<String, Double> calcCarConsumption(){
		return 	storage.calcCarConsumption();
	}
	/**
	 * 저장소 초기화
	 */
	public boolean clearList(){
		storage.clearList();
		return true;
	}
}