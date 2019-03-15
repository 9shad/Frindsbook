package com.friendsbook.action;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import com.friendsbook.DAO.ShowFriendListDAO;
import com.friendsbook.beans.UserFriend;

public class ShowFriendList {
	public void displayFriendList(String userId){
		List<String> friendList = ShowFriendListDAO.getFriendList(userId);
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			AtomicInteger counter = new AtomicInteger(0);
			System.out.println("\n------Friend List-----");
			friendList.forEach(obj -> {System.out.println(counter.incrementAndGet() +". "+obj);});
			System.out.println(counter.incrementAndGet()+". Go Back");
			System.out.print("Enter your choice to: ");
			option = sc.nextInt();
			if(option >=1 && option < counter.get()) {
				UserFriend friendProfile = new UserFriend(friendList.get(option-1));
				System.out.println("------Profile Information-----");
				System.out.println(friendProfile);
			}
		}while(option <= friendList.size());
	}
	
}
