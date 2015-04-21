package com.java;

import org.junit.Test;

import static org.junit.Assert.*;
public class MenuTypeTest {
	/**
	 * 메뉴코드를 전달하여 동일한 메뉴가 리턴되는지 확인
	 */
	@Test
	public void testGetMenuCode(){
		//given
		int[] expecteds = {0, 99};
		//when
		int[] actuals = {
				MenuType.Main.getMenuCode(),
				MenuType.Exit.getMenuCode()
				};
		//then
		assertArrayEquals(expecteds, actuals);
	}
	/**
	 * 해당 메뉴의 부모 메뉴코드를 확인
	 */
	@Test
	public void testGetParentMenuCode(){
		//given
		int expected = 3;
		//when
		int actual = MenuType.DailyConsumption.getParentMenuCode();
		//then
		assertEquals(expected, actual);
	}
	/**
	 * 메뉴코드로 검색을 하여 해당 메뉴가 리턴되는지 확인
	 * 성공, 실패 2가지 경우 테스트
	 */
	@Test
	public void testFindMenu(){
		//given
		MenuType[] expecteds = {MenuType.AddRecord, null};
		//when
		MenuType[] actuals = new MenuType[2];
		actuals[0] = MenuType.findMenu(2);
		actuals[1] = MenuType.findMenu(9999);
		//then
		assertArrayEquals(expecteds, actuals);
	}
	/**
	 * 현재 메뉴와 이동하려는 메뉴가 부모, 자식 관계이면 이동 가능
	 * 이동가능, 이동불가능 2가지 경우 테스트
	 */
	@Test
	public void testIsMoveable(){
		//given
		MenuType[] expecteds = {MenuType.CarConsumption, null};
		//when
		MenuType[] actuals = new MenuType[2];
		actuals[0] = MenuType.isMoveable(
				MenuType.CarConsumption.getMenuCode(), 
				MenuType.CarConsumption.getParentMenuCode()
				);
		actuals[1] = MenuType.isMoveable(
				MenuType.CarConsumption.getMenuCode(), 
				MenuType.Main.getMenuCode()
				);
		//then
		assertArrayEquals(expecteds, actuals);
	}
}
