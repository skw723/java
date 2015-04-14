package com.homework.java;

public class MenuViewer {
	private MenuType currentView;
	private static MenuViewer instance;
	private CarManagement carMgt;
	private InputManagement inputMgt;

	private MenuViewer(){
		currentView = MenuType.Main;
		carMgt = CarManagement.getInstance();
		inputMgt = InputManagement.getInstance();
	}

	public static MenuViewer getInstance(){
		if(instance == null){
			instance = new MenuViewer();
		}
		return instance;
	}

	public void startView(){
		while(!isExit()){
			printCurrentView();
			int menuCode = 0;
			try{
				menuCode = inputMgt.readMenuCode();
				moveMenu(menuCode);
			}catch(NumberFormatException e){
				incorrectValue();
			}
		}
		printCurrentView();
	}

	private void printMain() {
		System.out.printf("\n###### menu ######\n");
		System.out.printf("		1.차량등록\n");
		System.out.printf("		2.차량삭제\n");
		System.out.printf("		3.전체보기\n");
		System.out.printf("		99.종료\n");
		System.out.printf("선택하세요 : ");
	}
	private void printAdd(){
		System.out.printf("\n###### 차량추가 ######\n");
		System.out.printf("		11.버스\n");
		System.out.printf("		22.트럭\n");
		System.out.printf("		44.상위메뉴\n");
		System.out.printf("선택하세요 : ");
	}
	private boolean createCar(int menuCode) {
		// TODO Auto-generated method stub
		if(menuCode == MenuType.Up.getMenuCode()){
			upMenu();
			return true;
		}
		CarType carType = CarType.findCarType(menuCode);
		if(carType == null){
			incorrectValue();
			return false;
		}
		else{
			CarInfo info;
			try{
				info = inputMgt.readCarInfo(carType.toString());
			}catch(NumberFormatException e){
				incorrectValue();
				return true;
			}
			if(carMgt.createCar(info)){
				System.out.println("차량 등록성공");
				return true;
			}
			else{
				System.out.println("차량 등록실패");
				return false;
			}
		}

	}

	private void printDelete() {
		System.out.println("\n삭제를 진행합니다");
		System.out.printf("삭제할 id를 입력하세요 : ");
	}
	private void printViewAll() {
		// TODO Auto-generated method stub
		System.out.println("전체보기를 선택하였습니다");
		String[] result = carMgt.viewAllCar();
		for(int i=0; i<result.length; i++){
			System.out.print(result[i]);
		}
		upMenu();
		printMain();
	}
	private void printExit() {
		// TODO Auto-generated method stub
		System.out.println("종료합니다");
		//System.out.println(carMgt.viewAllCar());
	}
	private void moveMenu(int menuCode){
		//menuCode를 사용하여 해당화면으로 이동
		MenuType menu = MenuType.findMenu(menuCode);
		if(currentView == MenuType.Add){
			createCar(menuCode);
		}
		else if(currentView == MenuType.Delete){
			deleteCar(menuCode);
		}
		else if((menu == null)
				|| (!currentView.isChildMenu(menu) && !currentView.isCurrentMenu(menu))){
				incorrectValue();				
		}
		else if(menu == MenuType.Up){
			upMenu();
		}
		else{
			currentView = MenuType.findMenu(menuCode);			
		}
	}
	private void upMenu(){
		//menuCode를 사용하여 해당화면으로 이동
		currentView = MenuType.findMenu(currentView.getParentMenuCode());
	}
	private boolean isExit(){
		if(currentView == MenuType.Exit){
			return true;
		}
		else{
			return false;
		}
	}
	private void incorrectValue(){
		System.out.println("올바르지 않은 입력입니다");
	}
	private void printCurrentView(){
		switch(currentView){
		case Main:
			printMain();
			break;
		case Add:
			printAdd();
			//createCar();
			//upMenu();
			break;
		case Delete:
			printDelete();
			break;
		case ViewAll:
			printViewAll();
			//upMenu();
			break;
		case Exit:
			printExit();
			break;
		case Up:
			break;
		}
	}

	private boolean deleteCar(int carId) {
		// TODO Auto-generated method stub
		if(carMgt.deleteCar(carId)){
			System.out.println("삭제성공");
			upMenu();
			return true;
		}
		else{
			System.out.println("삭제 실패");
			upMenu();
			return false;
		}
	}
}