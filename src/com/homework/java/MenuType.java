package com.homework.java;

/**
 * Menu enum
 * @author 심규원
 *
 */
public enum MenuType {
	Main(0), Add(1), Delete(2), ViewAll(3), Up(44), Exit(99);

	private int code;

	private MenuType(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
}