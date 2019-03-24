package com.friendsbook.beans;

public class FriendNotification extends UserNotification{

	private UserFriendRequest friendRequests;

	public UserFriendRequest getFriendRequests() {
		return friendRequests;
	}

	public void setFriendRequests(UserFriendRequest friendRequests) {
		this.friendRequests = friendRequests;
	}
	
}
