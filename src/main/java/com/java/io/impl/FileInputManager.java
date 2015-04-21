package com.java.io.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.java.io.InputManager;

/**
 * 입력을 관리하는 클래스
 * stdin, File 입력 관리
 * Singleton 구현
 * @author 심규원
 *
 */
public class FileInputManager implements InputManager{
	public FileInputManager() {
		super();
	}
	@Override
	public String[] readFile(String fileName, String path) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> resultList = new ArrayList<String>();
		
		try {
			fr = new FileReader(new File(path + "/" + fileName));
			br = new BufferedReader(fr);
			String inputLine = "";
			while((inputLine = br.readLine()) != null){
				resultList.add(inputLine);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		} 
		return resultList.toArray(new String[resultList.size()]);
	}
	@Override
	public String[] getFileNames(String path) {
		// TODO Auto-generated method stub
		File root = new File(path);
		String[] result = root.list();
		if(result == null){
			result = new String[0];
		}
		return result;
	}
}