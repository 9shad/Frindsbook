package com.friendsbook.action;

import java.io.Console;
import java.util.Scanner;

import com.friendsbook.DAO.LoginDAO;
import com.friendsbook.beans.User;

public class AuthenticateUser {

	public void login(){
		Scanner sc = new Scanner(System.in);
		Console cnsl = System.console();
		System.out.print("Enter User Id: ");
		String userId = sc.next();
		System.out.print("Enter Password: ");
		String password = cnsl.readPassword().toString();
		User user = this.login(userId, password);
		if(user != null){
			
		}else{
			System.out.println("Invalid Credentials, please try again!");
		}
		
	}
	
	private User login(String userId, String password){
		return LoginDAO.checkUserCredentials(userId, password);
	}
	
	
	
	
}
