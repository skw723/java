package com.java.io;


/**
 * File 입력을 위한 인터페이스
 * @author 심규원
 *
 */
public interface FileInputManager {
	public String[] readFile(String fileName, String path);
	public String[] getFileNames(String path);
}
