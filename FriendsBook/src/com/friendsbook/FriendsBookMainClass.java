package com.friendsbook;

import java.util.Scanner;

import com.friendsbook.action.RegisterUser;

public class FriendsBookMainClass {

	public void showAuthenticationOption(){
		System.out.println("######################################");
		System.out.println("\tWelcome to Friends Book");
		System.out.println("######################################");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Close Application");
		System.out.print("Please Enter your choice: ");
	}
	
	public static void main(String[] args){
		FriendsBookMainClass obj = new FriendsBookMainClass();
		Scanner sc = new Scanner(System.in);
		int inputOption = 0;
		do{
			obj.showAuthenticationOption();
			switch(sc.nextInt()){
			case 1:
				break;
			case 2:
				System.out.println(new RegisterUser().registerUser());
				break;
			default:
				System.out.println("Invalid option selected, Please try again");
				break;
			}
		}while(inputOption != 3);
	}
}


