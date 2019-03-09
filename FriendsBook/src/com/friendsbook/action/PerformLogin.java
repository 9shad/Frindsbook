package com.friendsbook.action;

import java.io.Console;
import java.util.Scanner;

import com.friendsbook.DAO.LoginDAO;

public class PerformLogin {

	public void login(){
		Scanner sc = new Scanner(System.in);
		Console cnsl = System.console();
		System.out.print("Enter User Id: ");
		String userId = sc.next();
		System.out.print("Enter Password: ");
		String password = cnsl.readPassword().toString();
		
		if(this.login(userId, password)){
			
		}else{
			System.out.println("Invalid Credentials, please try again!");
		}
		
	}
	
	private boolean login(String userId, String password){
		return LoginDAO.checkUserCredentials(userId, password);
	}
	
	private void showFeaturesOption(){
		System.out.println();
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
	
	
	
}
