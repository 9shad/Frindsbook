package com.friendsbook.beans;

import java.util.List;

public class UserInformation{

	private User user;
	private List<UserPost> userPosts;
	private List<UserFriend> userFriendsList;
	private List<UserFriendRequest> userFriendRequests;
	private List<UserNotification> userNotifications;
	private List<UserMessage> userMessages;
	
	public UserInformation(User user) {
		super();
		this.user = user;
		
		/**
		 * Create DAO to intitailze user information from system as soon as user logged in
		 */
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<UserPost> getUserPosts() {
		return userPosts;
	}
	public void setUserPosts(List<UserPost> userPosts) {
		this.userPosts = userPosts;
	}
	public List<UserFriend> getUserFriendsList() {
		return userFriendsList;
	}
	public void setUserFriendsList(List<UserFriend> userFriendsList) {
		this.userFriendsList = userFriendsList;
	}
	public List<UserFriendRequest> getUserFriendRequests() {
		return userFriendRequests;
	}
	public void setUserFriendRequests(List<UserFriendRequest> userFriendRequests) {
		this.userFriendRequests = userFriendRequests;
	}
	public List<UserNotification> getUserNotifications() {
		return userNotifications;
	}
	public void setUserNotifications(List<UserNotification> userNotifications) {
		this.userNotifications = userNotifications;
	}
	public List<UserMessage> getUserMessages() {
		return userMessages;
	}
	public void setUserMessages(List<UserMessage> userMessages) {
		this.userMessages = userMessages;
	}

}
