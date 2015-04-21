package com.java;

/**
 * MenuType들을 관리
 * 각각의 type별로 menuCode, parentMenuCode를 관리
 * @author 심규원
 *
 */
public enum MenuType {
	Main(0, 0), 
	AddCar(1, 0), AddRecord(2, 0), ViewConsumption(3, 0), Exit(99, 0), 
	DailyConsumption(31, 3), CarConsumption(32, 3), Up(33, 3);

	private int menuCode;
	private int parentCode;

	/**
	 * 메뉴코드 생성자
	 * @param menuCode - 현재 메뉴 코드
	 * @param parentCode - 상위 메뉴 코드
	 */
	private MenuType(int menuCode, int parentCode) {
		this.menuCode = menuCode;
		this.parentCode = parentCode;
	}
	/**
	 * 현재 메뉴코드 리턴
	 * @return - 현재 메뉴코드
	 */
	public int getMenuCode() {
		return menuCode;
	}
	/**
	 * 현재 메뉴의 상위 메뉴코드 리턴
	 * @return - 현재 메뉴의 상위 메뉴코드
	 */
	public int getParentMenuCode(){
		return parentCode;
	}
	/**
	 * 입력받은 menuCode를 가진 MenuType이 있는지 검색
	 * @param menuCode - 검색할 menucode
	 * @return - 검색된 MenuType 객체(검색 실패 시 null)
	 */
	public static MenuType findMenu(int menuCode){
		MenuType[] values = MenuType.values();
		for(MenuType type : values){
			if(type.getMenuCode() == menuCode){
				return type;
			}
		}
		return null;
	}
	public static MenuType isMoveable(int menuCode, int parentCode){
		MenuType[] values = MenuType.values();
		for(MenuType type : values){
			if(type.getMenuCode() == menuCode && type.getParentMenuCode() == parentCode){
				return type;
			}
		}
		return null;
	}
}