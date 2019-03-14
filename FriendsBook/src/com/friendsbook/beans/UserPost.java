package com.friendsbook.beans;

import java.time.LocalDateTime;
import java.util.List;

import com.friendsbook.DAO.UserPostDAO;

public class UserPost {
	public static final String POST = "post";
	public static final String UPDATE = "update";
	private static int counter = 0;
	
	private int postId;
	private String type;
	private String userId;
	private String description;
	private LocalDateTime timeStamp;
	private int postCount;
	private List<UserComment> userComments;
	
	public UserPost() {
		super();
		counter = UserPostDAO.getMaxPostCountNumber();
		this.postCount = ++counter;
	}
	
	public UserPost(int postId){
		//TODO: write code to initialize single post
		//TODO: initialize respective comments
	}
	
	public int getPostId() {
		return postId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if(type.equals(POST) || type.equals(UPDATE))
			this.type = type;
		else
			throw new IllegalArgumentException();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getPostCount() {
		return postCount;
	}
	public List<UserComment> getUserComments() {
		return userComments;
	}

}
