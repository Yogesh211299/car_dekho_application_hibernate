package com.jspiders.cardekho_case_study3.dto;

import java.util.Scanner;

import com.jspiders.cardekho_case_study3.dao.CarOperation;

public class CarDekhoMenu extends CarOperation   {
	 private static CarOperation carOper= new CarOperation();
	static boolean flag=true;
	public static void main(String[] args) {
		CarDekhoMenu carDekhoMenu=new CarDekhoMenu();
		while(flag) {
		carDekhoMenu.menu();
		}
	}
	public  void menu() {
		System.out.println("==============MENU============");
		System.out.println("1.Add Car Details.\n2.Search Car Details.\n3.update Car Details\n4.delete Car details\n5.Exit\n");
	Scanner inp = new Scanner(System.in);
	int choice=inp.nextInt();
	switch (choice) {
	case 1:
		    carOper.addCar(); break;
	case 2:
		carOper.searchCarDetails();
		break;
	case 3:
		carOper.updateCarDetails();
		break;
	case 4:
		carOper.deleteCarDetails();				
	     break;
	case 5: System.out.println("------Thank you------ ");
		inp.close();
		System.exit(0);
		break;

	default:
		System.out.println("invalid choice");
		System.out.println("try again ");
		
	}


}
}
