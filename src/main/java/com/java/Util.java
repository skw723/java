package com.java;

import java.util.ArrayList;

import com.java.vo.CarInfo;
import com.java.vo.RecordInfo;

/**
 * 파일에서 획득한 String을 VO로 변환해주는 클래스
 * @author 심규원
 *
 */
public class Util {
	/**
	 * 문자열을 CarInfo로 변환
	 * @param data - 변환할 무자열
	 * @return - 변환결관
	 */
	public static CarInfo[] StringToCarInfo(String[] data){
		ArrayList<CarInfo> resultList = new ArrayList<CarInfo>();
		for(int i=0; i<data.length; i++){
			String[] splitData = data[i].split("\\|");
			CarInfo result = new CarInfo();
			result.setCarNumber(splitData[0]);
			try{
				result.setMileage(Double.parseDouble(splitData[1]));			
			}catch(Exception e){
				continue;
			}
			resultList.add(result);
		}
		return resultList.toArray(new CarInfo[resultList.size()]);
	}
	/**
	 * 문자열을 RecordInfo로 변환
	 * @param data - 변환할 문자열
	 * @param fileName - 읽어온 파일명(운행일자)
	 * @return - 변환결과
	 */
	public static RecordInfo[] StringToRecordInfo(String[] data, String fileName){
		ArrayList<RecordInfo> resultList = new ArrayList<RecordInfo>();
		for(int i=0; i<data.length; i++){
			String[] splitData = data[i].split("\\|");
			String[] splitDate = fileName.split("\\.");
			RecordInfo result = new RecordInfo();
			result.setCarNumber(splitData[0]);
			result.setDate(splitDate[0]);
			try{
				result.setDistance(Integer.parseInt(splitData[1]));			
			}catch(Exception e){
				continue;
			}
			resultList.add(result);
		}
		return resultList.toArray(new RecordInfo[resultList.size()]);
	}
}
