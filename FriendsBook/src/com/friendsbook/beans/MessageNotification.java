package com.friendsbook.beans;

public class MessageNotification extends UserNotification{

	private UserMessage userMessage;

	public UserMessage getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
	}
	
}
