package com.friendsbook.beans;

import java.time.LocalDateTime;

public class UserFriendRequest {
	public static final String NEW = "new";
	public static final String ACCEPTED = "accepted";
	public static final String REJECTED = "rejected";
	
	private int id;
	private int notificationId;
	private String fromUserId;
	private String toUserId;
	private LocalDateTime timeStamp;
	
	public UserFriendRequest() {
		super();
		timeStamp = LocalDateTime.now();
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public String getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
}
