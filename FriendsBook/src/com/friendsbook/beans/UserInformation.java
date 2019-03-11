package com.friendsbook.beans;

import java.util.List;

public class UserInformation{

	private User user;
	private List<UserPost> postsForUser;
	private List<UserFriend> userFriendList;
	private List<UserFriendRequest> friendRequestForUser;
	private List<UserNotification> notificationsForUser;
	private List<UserMessage> messagesForUser;
	
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

	public List<UserPost> getPostsForUser() {
		return postsForUser;
	}

	public void setPostsForUser(List<UserPost> postsForUser) {
		this.postsForUser = postsForUser;
	}

	public List<UserFriend> getUserFriendList() {
		return userFriendList;
	}

	public void setUserFriendList(List<UserFriend> userFriendList) {
		this.userFriendList = userFriendList;
	}

	public List<UserFriendRequest> getFriendRequestForUser() {
		return friendRequestForUser;
	}

	public void setFriendRequestForUser(List<UserFriendRequest> friendRequestForUser) {
		this.friendRequestForUser = friendRequestForUser;
	}

	public List<UserNotification> getNotificationsForUser() {
		return notificationsForUser;
	}

	public void setNotificationsForUser(List<UserNotification> notificationsForUser) {
		this.notificationsForUser = notificationsForUser;
	}

	public List<UserMessage> getMessagesForUser() {
		return messagesForUser;
	}

	public void setMessagesForUser(List<UserMessage> messagesForUser) {
		this.messagesForUser = messagesForUser;
	}

}
