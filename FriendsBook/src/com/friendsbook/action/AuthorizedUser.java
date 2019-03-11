package com.friendsbook.action;

import java.util.Scanner;

import com.friendsbook.beans.User;
import com.friendsbook.beans.UserInformation;

public class AuthorizedUser {
	private void showApplicationFeatures(){
		System.out.println();
		System.out.println("1. Select an update and post");
		System.out.println("2. Check Notifications");
		System.out.println("3. Create a new post");
		System.out.println("4. View Friends List");
		System.out.println("5. Update Profile");
		System.out.println("6. Send a Message");
		System.out.println("7. Send a Friend Request");
		System.out.println("8. See Hashtag in trends");
		System.out.println("9. Logout");
		System.out.print("Please Enter your choice: ");
	}
	
	public void provideAccess(User user){

		Scanner sc = new Scanner(System.in);
		int optionSelected = 0;
		boolean userInitilized = false;
		do{
			showApplicationFeatures();
			optionSelected = sc.nextInt();
			
			if(optionSelected != 9 && !userInitilized){
				UserInformation userInfo = new UserInformation(user);
				userInitilized = true;
			}
			
			switch(optionSelected){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			default:
				break;
			}
			
			
		}while(optionSelected !=9);
		
	}
	
	
	
}