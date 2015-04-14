package com.homework.java;

/**
 * Car 객체의 저장을 담당하는 클래스
 * array로 구현되어있음
 * 기본 저장공간 : 100
 * 저장공간이 부족하면 extend()를 통하여 저장공간 2배 확장
 * 객체 삭제 시 시프트 이동을 통하여 빈공간 제거
 * @author 심규원
 *
 */
public class CarStorage {
	private Car[] cars;
	private int maxCars;
	private int carCount;
	
	public CarStorage(){
		this.maxCars = 100;
		cars = new Car[maxCars];
		this.carCount = 0;
	}
	public boolean addCar(Car car){
		if(isFull()){
			extend();
		}
		cars[carCount++] = car;
		return true;
	}
	/**
	 * 저장된 Car객체를 삭제하는 메소드
	 * 삭제 성공 시 시프트를 통하여 빈공간 제거
	 * @param carId - 삭제할 객체의 carId
	 * @return - 삭제 성공여부
	 */
	public Car deleteCar(int carId){
		int index = indexOf(carId);
		if(index == -1){
			return null;			
		}
		Car result = cars[index];
		cars[index] = null;
		System.arraycopy(cars, index+1, cars, index, carCount - index);
		carCount--;
		return result;
	}
	public boolean isFull(){
		if(carCount == maxCars){
			return true;
		}
		return false;
	}
	/**
	 * 저장공간을 현재 크기으 ㅣ2배로 늘리는 메소드
	 */
	private void extend(){
		maxCars *= 2;
		Car[] newCars = new Car[maxCars];
		System.arraycopy(cars, 0, newCars, 0, carCount);
		cars = newCars;
	}
	/**
	 * 해당 index의 Car 객체를 리턴하는 메소드
	 * @param index - Car객체가 위치한 index 번호
	 * @return - 해당 Car 객체
	 */
	public Car getCar(int index){
		return cars[index];
	}
	/**현재 저장된 Car 객체의 개수를 리턴
	 * @return - 저장된 Car객체의 수
	 */
	public int getCarCount(){
		return carCount;
	}
	/**
	 * carId를 가진 객체의 index를 검색하는 메소드
	 * @param carId - 검색할 carId
	 * @return - 해당 Car객체의 index(return이 -1인 경우 검색 실패)
	 */
	public int indexOf(int carId){
		for(int i=0; i<carCount; i++){
			if(getCar(i).getCarInfo().getId() == carId){
				return i;
			}
		}
		return -1;
	}
}
