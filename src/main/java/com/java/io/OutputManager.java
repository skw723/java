package com.java.io;

import java.util.TreeMap;

/**
 * ouput기능을 담당하는 인터페이스
 * @author 심규원
 *
 */
public interface OutputManager {
	public void printBeforeAddCars();
	public void printAfterAddCars(int addedCar);
	public void printBeforeAddRecord();
	public void printAfterAddRecord(int addedRecord);
	public void printExit();
	public void printBeforeConsumption(String message);
	public void printAfterConsumption(TreeMap<String, Double> data);
}
