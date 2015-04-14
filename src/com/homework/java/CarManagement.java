package com.homework.java;

/**
 * Car 객체들을 관리하는 관리클래스
 * CarStorage를 사용하여 Car목록을 관리
 * Singleton으로 구현
 * @author 심규원
 *
 */
public class CarManagement {
	private CarStorage storage;
	private int carId = 0;
	private static CarManagement instance;
	
	private CarManagement(){
		storage = new CarStorage();
	}
	/**
	 * CarManagement의 객체를 획득하는 메소드
	 * @return CarManagement의 객체를 리턴
	 */
	public static CarManagement getInstance(){
		if(instance == null){
			instance = new CarManagement();
		}
		return instance;
	}
	/**
	 * 저장된 모든 Car 객체의 getDetails() 메소드를 호출
	 * @return - 저장된 Car 객체의 리스트를 리턴
	 */
	public String[] viewAllCar(){
		int carCount = storage.getCarCount();
		String[] result = new String[carCount];
		for(int i=0; i<carCount; i++){
			result[i] = storage.getCar(i).getDetails();
		}
		return result;
	}
	public boolean createCar(CarInfo info){
		info.setId(carId++);
		return storage.addCar(new Car(info));
	}
	/**
	 * CarStorage에서 해당 carId의 Car객체를 삭제
	 * @param carId - 삭제할 Car 객체의 carId
	 * @return - 삭제 성공여부
	 */
	public boolean deleteCar(int carId){
		if(storage.deleteCar(carId) == null){
			return false;
		}
		return true;
	}
}
