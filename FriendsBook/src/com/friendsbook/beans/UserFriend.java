package com.friendsbook.beans;

import java.time.LocalDate;
import java.util.List;
import com.friendsbook.DAO.ShowFriendListDAO;

public class UserFriend {
	private String userId;
	private String name;
	private String gender;
	private String school;
	private LocalDate birthdayDate;
	
	public UserFriend(String userId) {
		super();
		this.userId = userId;
		List<Object> profileInfo = ShowFriendListDAO.getFriendProfile(userId);
		if(profileInfo != null){
			this.name = profileInfo.get(1).toString();
			this.gender = profileInfo.get(2).toString();
			this.school = profileInfo.get(3).toString();
			this.birthdayDate = (LocalDate) profileInfo.get(4);
		}
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
		return "Friend [name=" + name + ", gender=" + gender + ", school=" + school + ", birthdayDate="
				+ birthdayDate + "]";
	}

	
}
