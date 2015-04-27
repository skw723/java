package com.java.management;

import java.lang.reflect.Constructor;
import java.util.Set;

import com.java.Main;
import com.java.cars.Car;
import com.java.storage.CarStorage;
import com.java.vo.CarInfo;

/**
 * Car 인스턴스를 관리하는 클래스
 * CarStorage를 사용하여 관리
 * @author 심규원
 *
 */
public class CarManagement {
	private CarStorage storage;
	private static CarManagement instance;
	
	/**
	 * 기본 생성자
	 */
	private CarManagement(){
		storage = new CarStorage();
	}
	public static CarManagement getInstance(){
		if(instance == null){
			instance = new CarManagement();
		}
		return instance;
	}
	/**
	 * reflection을 사용하여 Car 인스턴스 생성후
	 * 생성된 인스턴스를 저장
	 * @param info - Car정보
	 * @param fileName - 정보를 획득한 파일명
	 * @return - 성공여부
	 */
	@SuppressWarnings("rawtypes")
	public boolean createCar(CarInfo info, String fileName){
		String[] split = fileName.split("\\.");
		String className = split[0];
		Constructor cons = findConstructor(className);
		if(cons == null){
			return false;
		}
		Car carInstance = null;
		//return storage.addCar(new Car(info));
		try {
			carInstance = (Car) cons.newInstance(info);
		} catch(Exception e){
			return false;
		}
		return storage.addCar(carInstance);
	}
	/**
	 * 해당 클래스의 생성자를 찾는 메소드
	 * @param className - 생성자를 찾을 클래스명
	 * @return - 찾은 생성자 리턴, 실패 시 null
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Constructor findConstructor(String className) {
		// TODO Auto-generated method stub
		Class klass = null;
		Constructor cons = null;
		try {
			klass = Class.forName(Main.carsPackagePath + "." + className);
			Class<?>[] parameterTypes = {CarInfo.class};
			cons = klass.getConstructor(parameterTypes);
		} catch(Exception e){
			return null;
		}
		return cons;
	}
	/**
	 * 하나의 파일에서 획득한 Car정보들로 Car 인스턴스 생성
	 * 하나의 인스턴스를 생성할 때마다 createCar() 호출 
	 * @param info - 하나의 파일에서 획득한 Car정보들
	 * @param fileName - 정보를 획득한 파일명
	 * @return - 생성에 성공한 횟수
	 */
	public int createCars(CarInfo[] info, String fileName){
		int success = 0;
		for(int i=0; i<info.length; i++){
			if(createCar(info[i], fileName)){
				success++;
			}
		}
		return success;
	}
	/**
	 * 해당 차량의 연료소비량을 계산하는 메소드
	 * @param carNumber - 차량번호
	 * @param distance - 이동거리
	 * @return - 계산된 연료소비량
	 */
	public double calcCunsuption(String carNumber, int distance){
		Car car = storage.getCar(carNumber);
		if(car == null){
			return 0;			
		}
		return car.calcConsumption(distance);
	}
	/**
	 * 저장소 초기화
	 */
	public boolean clearList(){
		storage.clearMap();
		return true;
	}
	
	/**
	 * 모든 차량 번호를 리턴하는 메소드
	 * @return - 차량 번호들
	 */
	public Set<String> getCarNumbers(){
		return storage.getCarNumbers();
	}
}
