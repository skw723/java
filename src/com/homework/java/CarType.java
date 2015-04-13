package com.homework.java;

/**
 * Car 종류 
 * @author 심규원
 *
 */
public enum CarType {
	Bus("11"), Truck("22");
	
	private String typeCode;
	
	private CarType(String typeCode){
		this.typeCode = typeCode;
	}
	/**
	 * Car Type의 Code를 반환
	 * @return - typeCode
	 */
	public String getTypeCode(){
		return typeCode;
	}
}
