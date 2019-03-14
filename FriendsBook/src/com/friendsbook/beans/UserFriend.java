package com.friendsbook.beans;

import java.time.LocalDate;

public class UserFriend {
	private String userId;
	private String name;
	private String gender;
	private String school;
	private LocalDate birthdayDate;
	
	public UserFriend(String userId) {
		super();
		this.userId = userId;
		//TODO: generate other fields using DAO for displaying user friend profile
	}

	public UserFriend(String userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}
	
	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getSchool() {
		return school;
	}

	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}

	@Override
	public String toString() {
		return "Friend [userId= " + userId + ", name= " + name + "]";
	}
}
