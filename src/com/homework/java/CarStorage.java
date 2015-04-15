package com.homework.java;

import java.util.ArrayList;

/**
 * v0.1
 * Car 객체의 저장을 담당하는 클래스
 * array로 구현되어있음
 * 기본 저장공간 : 100
 * 저장공간이 부족하면 extend()를 통하여 저장공간 2배 확장
 * 객체 삭제 시 시프트 이동을 통하여 빈공간 제거
 * 
 * v0.2
 * array -> ArrayList 로 변경
 * 저장공간 확장을 하지 않음
 * 사용되지 않는 메소드 제거(isFull, extend)
 * 삭제 시 시프트 이동 없음
 * @author 심규원
 *
 */
public class CarStorage {
	private ArrayList<Car> carList;
	
	public CarStorage(){
		carList = new ArrayList<Car>();
	}
	public boolean addCar(Car car){
		return carList.add(car);
	}
	/**
	 * v0.1
	 * 저장된 Car객체를 삭제하는 메소드
	 * 삭제 성공 시 시프트를 통하여 빈공간 제거
	 * 삭제 실패 시 null 리턴
	 * 
	 * v0.2
	 * ArrayList로 변경에 따라 삭제 후 시프트이동이 없음
	 * @param carId - 삭제할 객체의 carId
	 * @return - 삭제 성공여부
	 */
	public Car deleteCar(int carId){
		int index = indexOf(carId);
		if(index == -1){
			return null;
		}
		else{
			Car result = carList.get(index);
			carList.remove(index);
			return result;
		}
	}
	/**
	 * 해당 index의 Car 객체를 리턴하는 메소드
	 * @param index - Car객체가 위치한 index 번호
	 * @return - 해당 Car 객체
	 */
	public Car getCar(int index){
		return carList.get(index);
	}
	/**현재 저장된 Car 객체의 개수를 리턴
	 * @return - 저장된 Car객체의 수
	 */
	public int getCarCount(){
		return carList.size();
	}
	/**
	 * carId를 가진 객체의 index를 검색하는 메소드
	 * @param carId - 검색할 carId
	 * @return - 해당 Car객체의 index(return이 -1인 경우 검색 실패)
	 */
	public int indexOf(int carId){
		for(int i=0; i<carList.size(); i++){
			if(getCar(i).getCarInfo().getId() == carId){
				return i;
			}
		}
		return -1;
	}
}
