package com.friendsbook.beans;

import java.time.LocalDate;

public class UserFriend {
	private String userId;
	private String name;
	private String gender;
	private String school;
	private LocalDate birthdayDate;
	
//	public UserFriend(String userId) {
//		super();
//		this.userId = userId;
//		List<Object> profileInfo = FriendDAO.getFriendProfile(userId);
//		if(profileInfo != null){
//			this.name = profileInfo.get(1).toString();
//			this.gender = profileInfo.get(2).toString();
//			this.school = profileInfo.get(3).toString();
//			this.birthdayDate = (LocalDate) profileInfo.get(4);
//		}
//	}
	public UserFriend() {
		
	}
	
	public UserFriend(String userId, String name, String gender, String school, LocalDate birthdayDate) {
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.school = school;
		this.birthdayDate = birthdayDate;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setBirthdayDate(LocalDate birthdayDate) {
		this.birthdayDate = birthdayDate;
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
		return "Friend [name= " + name + ", gender= " + gender + ", school= " + school + ", birthdayDate= "
				+ birthdayDate + "]";
	}

	
}
