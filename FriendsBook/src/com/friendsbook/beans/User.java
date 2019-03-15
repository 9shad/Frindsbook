package com.friendsbook.beans;

import java.time.LocalDate;

import com.friendsbook.util.DateAndTime;

public class User {
	private String userId;
	private String password;
	private String name;
	private String gender;
	private String schoolName;
	private LocalDate birthdayDate;
	private String email;
	private String accountCreatedTimeStamp;
	
	public User() {
		super();
		accountCreatedTimeStamp = DateAndTime.dateTimeString();
	}
	
	public User(String userId, String password, String name, String gender,
			String schoolName, LocalDate birthdayDate, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.schoolName = schoolName;
		this.birthdayDate = birthdayDate;
		this.email = email;
		this.accountCreatedTimeStamp = DateAndTime.dateTimeString();
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}
	public void setBirthdayDate(LocalDate birthdayDate) {
		this.birthdayDate = birthdayDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccountCreatedTimeStamp() {
		return accountCreatedTimeStamp;
	}
	public void setAccountCreatedTimeStamp(String accountCreatedTimeStamp) {
		this.accountCreatedTimeStamp = accountCreatedTimeStamp;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((accountCreatedTimeStamp == null) ? 0
						: accountCreatedTimeStamp.hashCode());
		result = prime * result
				+ ((birthdayDate == null) ? 0 : birthdayDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((schoolName == null) ? 0 : schoolName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accountCreatedTimeStamp == null) {
			if (other.accountCreatedTimeStamp != null)
				return false;
		} else if (!accountCreatedTimeStamp
				.equals(other.accountCreatedTimeStamp))
			return false;
		if (birthdayDate == null) {
			if (other.birthdayDate != null)
				return false;
		} else if (!birthdayDate.equals(other.birthdayDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (schoolName == null) {
			if (other.schoolName != null)
				return false;
		} else if (!schoolName.equals(other.schoolName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.userId+ " profile information:\nname=" + name + ",\n gender=" + gender + ",\n schoolName="
				+ schoolName + ",\n birthdayDate=" + birthdayDate;
	}
	
}
