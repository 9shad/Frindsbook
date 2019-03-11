package com.friendsbook.action;

import java.util.Scanner;

import com.friendsbook.DAO.RegisterUserDAO;
import com.friendsbook.beans.UserFriendRequest;

public class SendFriendRequest {

	public void sendRequest(String userId){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter User Id to send Request: ");
		String toUserId = sc.next();
		
		if(RegisterUserDAO.checkUserId(toUserId)){
			UserFriendRequest obj = new UserFriendRequest();
			obj.setFromUserId(userId);
			obj.setToUserId(toUserId);
			//obj.setNotificationId(notificationId);
			
		}else{
			System.out.println("Oops!, Invalid User Id. Please try again.");
		}
	}
}
