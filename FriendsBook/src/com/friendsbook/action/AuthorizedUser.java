package com.friendsbook.action;

import java.util.Scanner;

import com.friendsbook.beans.User;
import com.friendsbook.beans.UserInformation;

public class AuthorizedUser {
	
	private void showApplicationFeatures(String userName){
		System.out.println();
		System.out.println("######################################");
		System.out.println("\tWelcome back "+ userName +"!!");
		System.out.println("######################################");
		//System.out.println("1. Select an update and post");
		//System.out.println("2. Check Notifications");
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
			showApplicationFeatures(user.getName());

			optionSelected = sc.nextInt();

			if(optionSelected != 9 && !userInitilized){
				//TODO: fetch all user related information when userInformation object is created
				UserInformation userInfo = new UserInformation(user);
				userInitilized = true;
			}
			
			switch(optionSelected){
			case 1:
				break;
			case 2:
				break;
			case 3:
				CreatePost createPost = new CreatePost();
				createPost.createPost(user.getUserId());
				break;
			case 4:
				ShowFriendList showList = new ShowFriendList(user.getUserId());
				showList.displayFriendsAndProfile();
				break;
			case 5:
				UpdateProfile updateProfile = new UpdateProfile();
				System.out.println(updateProfile.updateProfile(user));
				break;
			case 6:
				SendMessage sendMessage = new SendMessage();
				sendMessage.sendMessage(user.getUserId());
				break;
			case 7:
				SendFriendRequest sendRequest = new SendFriendRequest();
				sendRequest.sendRequest(user.getUserId());
				break;
			case 8:
				Hashtag hashTag = new Hashtag();
				hashTag.showHashtags();
				break;
			case 9:
				user = null;
				break;
			default:
				break;
			}		
		}while(optionSelected !=9);
		
	}
}
