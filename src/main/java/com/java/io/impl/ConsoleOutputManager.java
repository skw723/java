package com.java.io.impl;

import java.util.Iterator;
import java.util.TreeMap;

import com.java.io.OutputManager;

/**
 * stdout으로의 출력을 담당하는 클래스
 * OutputManager 인터페이스 구현
 * @author 심규원
 *
 */
public class ConsoleOutputManager implements OutputManager{
	@Override
	public void printBeforeAddCars(){
		System.out.printf("\n차량을 등록합니다");
	}
	@Override
	public void printAfterAddCars(int addedCar){
		System.out.printf("\n%d개 차량이 등록되었습니다.\n", addedCar);
	}
	@Override
	public void printBeforeAddRecord(){
		System.out.printf("\n운행기록을 등록합니다");
	}
	@Override
	public void printAfterAddRecord(int addedRecord){
		System.out.printf("\n%d건 운행기록이 등록되었습니다.\n", addedRecord);
	}
	@Override
	public void printExit(){
		System.out.println("\n종료합니다");
	}
	@Override
	public void printAfterConsumption(TreeMap<String, Double> data){
		Iterator<String> keys = data.keySet().iterator();
		Iterator<Double> values = data.values().iterator();
		while(keys.hasNext()){
			System.out.printf("%-5s %.2f\n", keys.next(), values.next());			
		}
	}
	@Override
	public void printBeforeConsumption(String message) {
		System.out.println(message);
	}
}
