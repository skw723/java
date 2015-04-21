package com.java.io;

/**
 * 입력 기능을 담당하는 인터페이스
 * console + file 입력을 위해 2개의 인스턴스 상속
 * @author 심규원
 *
 */
public interface InputManager{
	public String[] readFile(String fileName, String path);
	public String[] getFileNames(String path);
}