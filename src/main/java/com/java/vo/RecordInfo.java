package com.java.vo;

/**
 * 운행기록 정볼르 관리하는 클래스
 * date - 운행일자
 * distance - 운행거리
 * carNumber - 차량번호
 * @author 심규원
 *
 */
public class RecordInfo {
	private String date;
	private int distance;
	private String carNumber;
	
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
}
