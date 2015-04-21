package com.java.io.impl;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileInputManagerTest {
	private static FileInputManager inputManager;
	private static File tmpDirectory;
	private static String tmpDirPath = "./tmp/";
	
	/**
	 * 테스트를 위한 임시파일 생성
	 * @throws IOException
	 */
	@BeforeClass
	public static void beforeClass() throws IOException{
		inputManager = new FileInputManager();
		tmpDirectory = new File(tmpDirPath);
		tmpDirectory.mkdir();
		tmpDirectory.deleteOnExit();
		setTempFiles();
	}
	@AfterClass
	public static void afterClass(){
		inputManager = null;
		tmpDirectory = null;
		tmpDirPath = null;
	}
	/**
	 * 파일의 내용을 읽어오는 테스트
	 */
	@Test
	public void testReadFile(){
		//given
		String fileName = "file1.txt";
		String nonExistFileName = "nonExist.aaa";
		String[] expecteds = {"Line1", "Line2", "Line3"};
		String[] expectedsNotRead = null;
		//when
		String[] actuals = inputManager.readFile(fileName, tmpDirPath);
		String[] actualsNotRead = inputManager.readFile(nonExistFileName, tmpDirPath);
		//then
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expectedsNotRead, actualsNotRead);
	}
	/**
	 * 해당 디렉토리의 파일명들을 읽어오는 테스트
	 */
	@Test
	public void testGetFileNames(){
		//given
		String[] expectedsSuccess = {"file1.txt", "file2.txt"};
		String[] expectedsFail = {};
		//when
		String[] actualsSuccess = inputManager.getFileNames(tmpDirPath);
		String[] actualsFail = inputManager.getFileNames(tmpDirPath + "123");
		//then
		assertArrayEquals(expectedsSuccess, actualsSuccess);
		assertArrayEquals(expectedsFail, actualsFail);
	}
	public static void setTempFiles() throws IOException {
		File tmpFile1 = new File(tmpDirPath + "file1.txt");
		File tmpFile2 = new File(tmpDirPath + "file2.txt");
		tmpFile1.createNewFile();
		tmpFile2.createNewFile();

		FileWriter fileWriter1 = new FileWriter(tmpFile1);
		fileWriter1.write("Line1\n");
		fileWriter1.write("Line2\n");
		fileWriter1.write("Line3\n");
		fileWriter1.close();

		tmpFile1.deleteOnExit();
		tmpFile2.deleteOnExit();
	}
}
