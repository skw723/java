package com.java.io.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class DataInputManagerTest {
	private DataInputManager inputManager;
	private static File tmpDirectory;
	private static String tmpDirPath = "./tmp/";
	@Rule
	public final TextFromStandardInputStream systemInMock
    = emptyStandardInputStream();

	public DataInputManagerTest(){
		inputManager = new DataInputManager();
	}
	/**
	 * 파일 read 테스트를 위한 임시 파일 생성
	 * @throws IOException 
	 */
	@BeforeClass
	public static void beforeClass() throws IOException{
		tmpDirectory = new File(tmpDirPath);
		tmpDirectory.mkdir();
		tmpDirectory.deleteOnExit();
		setTempFiles();
	}	
	@Test
	public void testReadString(){
		//given
		systemInMock.provideText("StringInputTest");;
		inputManager = new DataInputManager();
		//when
		String actualString = inputManager.readString();
		//then
		assertEquals("StringInputTest", actualString);
	}
	@Test
	public void testReadInteger(){
		//given
				systemInMock.provideText("1");
				inputManager = new DataInputManager();
				//when
				int actualInteger = inputManager.readInteger();
				//then
				assertEquals(1, actualInteger);
	}
	/**
	 * 파일의 내용을 읽어오는 테스트
	 */
	@Test
	public void testReadFile(){
		//given
		String fileName = "file1.txt";
		String nonExistFileName = "nonExist.aaa";
		String[] expecteds = {"임시파일123", "testFile", "테스트파일"};
		String[] expectedsNotRead = null;
		//when
		String[] actuals = inputManager.readFile(fileName, tmpDirPath);
		String[] actualsNotRead = inputManager.readFile(nonExistFileName, tmpDirPath);

		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expectedsNotRead, actualsNotRead);
	}
	/**
	 * 해당 디렉토리의 파일명들을 읽어오는 테스트
	 */
	@Test
	public void testGetFileNames(){
		//given
		String[] expecteds = {"file1.txt", "file2.txt"};
		//when
		String[] actuals = inputManager.getFileNames(tmpDirPath);
		//then
		assertArrayEquals(expecteds, actuals);
	}
	public static void setTempFiles() throws IOException {
		File tmpFile1 = new File(tmpDirPath + "file1.txt");
		File tmpFile2 = new File(tmpDirPath + "file2.txt");
		tmpFile1.createNewFile();
		tmpFile2.createNewFile();

		FileWriter fileWriter1 = new FileWriter(tmpFile1);
		fileWriter1.write("임시파일123\n");
		fileWriter1.write("testFile\n");
		fileWriter1.write("테스트파일\n");
		fileWriter1.close();

		tmpFile1.deleteOnExit();
		tmpFile2.deleteOnExit();
	}
}
