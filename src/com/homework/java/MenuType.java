package com.homework.java;

/**
 * MenuType관리
 * 각각의 type별로 menuCode, parentMenuCode를 관리
 * @author 심규원
 *
 */
public enum MenuType {
	Main(0, 0), Add(1, 0), Delete(2, 0), ViewAll(3, 0), Up(44, 1), Exit(99, 0);

	private int menuCode;
	private int parentCode;

	private MenuType(int menuCode, int parentCode) {
		this.menuCode = menuCode;
		this.parentCode = parentCode;
	}
	public int getMenuCode() {
		return menuCode;
	}
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