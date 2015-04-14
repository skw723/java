package com.homework.java;

/**
 * CarType관리
 * 각각의 type별로 code를 관리
 * typeCode가 유효한 코드인지 확인
 * @author 심규원
 *
 */
public enum CarType {
	Bus(11), Truck(22);
	
	private int carTypeCode;
	
	private CarType(int carTypeCode){
		this.carTypeCode = carTypeCode;
	}
	public int getCarTypeCode(){
		return carTypeCode;
	}
	/**
	 * 입력된 typeCode CarType을 검색하는 메소드
	 * @param typeCode - 검색할 메뉴의 typeCode
	 * @return - 검색 성공 시 해당 객체 리턴(검색 실패 시 null)
	 */
	public static CarType findCarType(int typeCode){
		CarType[] values = CarType.values();
		for(CarType type : values){
			if(type.getCarTypeCode() == typeCode){
				return type;
			}
		}
		return null;
	}
}
