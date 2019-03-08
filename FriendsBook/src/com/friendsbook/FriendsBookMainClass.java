package com.friendsbook;

import java.util.Scanner;

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
	
	public void showFeaturesOption(){
		System.out.println("1. Select an update and post");
		System.out.println("2. Check Notifications");
		System.out.println("3. Create a new post");
		System.out.println("4. View Friends List");
		System.out.println("5. Update Profile");
		System.out.println("6. Send a Message");
		System.out.println("7. Send a Friend Request");
		System.out.println("8. See Hashtag in trends");
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
				break;
			default:
				System.out.println("Invalid option selected, Please try again");
				break;
			}
		}while(inputOption != 3);
	}
}


