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
	public void printMain() {
		System.out.printf("\n###### menu ######\n");
		System.out.printf("		1.차량입력\n");
		System.out.printf("		2.운행거리 입력\n");
		System.out.printf("		3.연료소비량 보기\n");
		System.out.printf("		99.종료\n");
		System.out.printf("선택하세요 : ");
	}
	@Override
	public void printBeforeAddCar(){
		System.out.printf("\n차량을 등록합니다");
	}
	@Override
	public void printAfterAddCar(int addedCar){
		System.out.printf("\n%d개 차량이 등록되었습니다.\n", addedCar);
	}
	@Override
	public void printBeforeAddRecord(){
		System.out.printf("\n운행기록을 등록합니다");
	}
	@Override
	public void printAfterAddRecord(int addedRecord){
		System.out.printf("\n%d일 운행기록이 등록되었습니다.\n", addedRecord);
	}
	@Override
	public void printIncorrectValue(){
		System.out.println("올바르지 않은 입력입니다");
	}
	@Override
	public void printExit(){
		System.out.println("종료합니다");
	}
	@Override
	public void printViewConsumption(){
		System.out.printf("\n###### 소비량 보기 ######\n");
		System.out.printf("		31.일별 사용량\n");
		System.out.printf("		32.차량별 사용량\n");
		System.out.printf("		33.상위메뉴\n");
		System.out.printf("선택하세요 : ");
	}
	@Override
	public void printConsumption(TreeMap<String, Double> data){
		Iterator<String> keys = data.keySet().iterator();
		Iterator<Double> values = data.values().iterator();
		while(keys.hasNext()){
			System.out.printf("%-5s %.2f\n", keys.next(), values.next());			
		}
	}
}
