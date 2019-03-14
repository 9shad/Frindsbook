package com.friendsbook.action;

import java.util.Scanner;

import com.friendsbook.DAO.RegisterUserDAO;
import com.friendsbook.DAO.SendFriendRequestDAO;
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
			if(SendFriendRequestDAO.sendFriendRequestDAO(obj)){
				System.out.println("Friend Request sent successfully!");
			}else{
				System.out.println("Oops! something went wrong, Please try again!!");
			}
		}else{
			System.out.println("Oops!, Invalid User Id. Please try again.");
		}
	}
}
