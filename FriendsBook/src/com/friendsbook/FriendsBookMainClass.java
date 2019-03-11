package com.friendsbook;

import java.util.Scanner;

import sun.text.normalizer.ICUBinary.Authenticate;

import com.friendsbook.action.AuthenticateUser;
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
			inputOption = sc.nextInt();
			switch(inputOption){
			case 1:
				new AuthenticateUser().login();
				break;
			case 2:
				System.out.println(new RegisterUser().registerUser());
				break;
			case 3:
				System.out.println("Good Bye, see you soon!!");
				break;
			default:
				System.out.println("Invalid option!, Please try again");
				break;
			}
		}while(inputOption != 3);
	}
}


