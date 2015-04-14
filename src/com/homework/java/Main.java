package com.homework.java;


/**
 * main 메소드가 있는 클래스
 * MenuViewer를 호출하여 제어권을 넘김
 * @author 심규원
 *
 */
public class Main {
	private static MenuViewer mViewer;
	
	public static void main(String[] args) {
		mViewer = MenuViewer.getInstance();
		mViewer.startView();
	}
}
