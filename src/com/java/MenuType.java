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
	/**
	 * 입력받은 menuType이 자식 Menu인지 확인
	 * @param childMenu - 확인할 자식 Menu
	 * @return - 확인결과
	 */
	public boolean isChildMenu(MenuType childMenu){
		if(this.menuCode == childMenu.getParentMenuCode()){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 입력받은 menuType이 동일한 메뉴인지 확인
	 * menu의 name을 비교
	 * @param obj - 확인할 Menu
	 * @return - 확인결과
	 */
	public boolean isCurrentMenu(MenuType obj){
		if(this == obj){
			return true;
		}
		return this.toString().equals(obj.toString());
	}
}