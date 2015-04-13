package com.homework.java;

import java.util.Scanner;

/**
 * Main클래스로 stdin, stdout 담당
 * @author 심규원
 *
 */
public class Main {
	private static Scanner stdin;
	private static boolean isRunning;
	private static MenuType currentMenu;
	private static CarManagement carMgt;
	
	public static void main(String[] args) {
		//초기화
		stdin = new Scanner(System.in);
		isRunning = true;
		currentMenu = MenuType.Main;
		carMgt = new CarManagement(100);
		
		//초기 메뉴 출력
		printMenu(currentMenu);
		while(isRunning){
			//input에 해당하는 메뉴or동작 수행
			String inputValue = stdin.nextLine();
			selectMenu(currentMenu, inputValue);
		}
	}

	/**
	 * 화면에 메뉴를 출력하는 함수
	 * @param menu - 화면에 출력 할 MenuType
	 */
	private static void printMenu(MenuType menu) {
		// TODO Auto-generated method stub
		switch(menu){
		case Main:
			printMain();
			currentMenu = MenuType.Main;
			break;
		case Add:
			printAdd();
			currentMenu = MenuType.Add;
			break;
		case Delete:
			printDelete();
			currentMenu = MenuType.Delete;
			break;
		case ViewAll:
			printViewAll();
			printMenu(MenuType.Main);
			break;
		case Exit:
			printExit();
			currentMenu = MenuType.Exit;
			break;
		default:
			printMenu(currentMenu);
		}
	}

	/**
	 * Exit 메뉴 출력
	 */
	private static void printExit() {
		System.out.println("\n\n프로그램을 종료합니다");
	}

	/**
	 * Delete 메뉴 출력
	 */
	private static void printDelete() {
		System.out.println("\n\n삭제를 진행합니다");
		System.out.printf("삭제할 id를 입력하세요 : ");
	}

	/**
	 * Add 메뉴 출력
	 */
	private static void printAdd() {
		System.out.printf("\n\n###### 차량추가 ######\n");
		System.out.printf("    11.버스\n");
		System.out.printf("    22.트럭\n");
		System.out.printf("    44.상위메뉴\n");
		System.out.printf("선택하세요 : ");
	}

	/**
	 * Main 메뉴 출력
	 */
	private static void printMain() {
		System.out.printf("\n\n###### menu ######\n");
		System.out.printf("    1.차량등록\n");
		System.out.printf("    2.차량삭제\n");
		System.out.printf("    3.전체보기\n");
		System.out.printf("    99.종료\n");
		System.out.printf("선택하세요 : ");
	}

	/**
	 * ViewAll 메뉴 출력
	 */
	private static void printViewAll() {
		// TODO Auto-generated method stub
		System.out.println("전체보기를 선택하였습니다");
		System.out.println(carMgt.viewAllCar());
	}

	/**
	 * 사용자의 Input으로 화면이동 or 작업 수행
	 * @param menu - 현재 화면에 출력된 MenuType
	 * @param inputValue - 사용자에게 입력받은 input
	 */
	private static void selectMenu(MenuType menu, String inputValue) {
		// TODO Auto-generated method stub
		int inputCode;
		//input이 숫자가 아닌경우 예외처리
		try{
			inputCode = Integer.parseInt(inputValue);			
		}catch(NumberFormatException e){
			System.out.printf("잘못된 입력입니다");
			printMenu(currentMenu);
			return ;
		}
		
		//현재 화면 menu와 입력값 inputCode활용
		switch(menu){
		case Main:
			if(MenuType.Add.getCode() == inputCode){
				printMenu(MenuType.Add);
			}
			else if(MenuType.Delete.getCode() == inputCode){
				printMenu(MenuType.Delete);
			}
			else if(MenuType.ViewAll.getCode() == inputCode){
				printMenu(MenuType.ViewAll);
			}
			else if(MenuType.Exit.getCode() == inputCode){
				isRunning = false;
				printMenu(MenuType.Exit);
			}
			else{
				printMenu(currentMenu);
			}
			break;
		case Add:
			if(MenuType.Up.getCode() == inputCode){
				printMenu(MenuType.Main);
			}
			else{
				//Car 생성 
				if(createCar(inputValue)){
					System.out.printf("차량이 추가되었습니다");
					printMenu(MenuType.Add);
				}
				else{
					System.out.printf("차량 추가에 실패했습니다");
					printMenu(currentMenu);
				}
			}
			break;
		case Delete:
			deleteCar(inputCode);
			printMenu(MenuType.Main);
			break;
		}
	}

	/**
	 * Car를 삭제하는 함수
	 * @param carId - 삭제할 Car의 ID
	 * @return - 삭제 성공여부
	 */
	private static boolean deleteCar(int carId) {
		// TODO Auto-generated method stub
		if(carMgt.deleteCar(carId)){
			System.out.printf("차량이 삭제되었습니다");
			return true;
		}
		else{
			System.out.printf("차량 삭제에 실패했습니다");
			return false;
		}
	}

	/**
	 * Car를 생성하는 함수
	 * @param inputValue - 사용자의 입력값(CarType)
	 * @return - 생성 성공여부
	 */
	private static boolean createCar(String inputValue) {
		// TODO Auto-generated method stub
		String carType = null;
		String carNumber = null;
		double mileage = 0.0;
		//inputValue로 CarType 획득
		if(CarType.Bus.getTypeCode().equals(inputValue)){
			carType = CarType.Bus.toString();
			System.out.print("버스를 등록합니다. 차량번호를 입력하세요 : ");
		}
		else if(CarType.Truck.getTypeCode().equals(inputValue)){
			carType = CarType.Truck.toString();
			System.out.print("트럭을 등록합니다. 차량번호를 입력하세요 : ");
		}
		else{
			System.out.print("존재하지 않는 차량 종류입니다");
			return false;
		}
		carNumber = stdin.nextLine();
		System.out.print("연비를 입력하세요 : ");
		mileage = Double.parseDouble(stdin.nextLine());
		return carMgt.createCar(carType, carNumber, mileage);
	}
}
