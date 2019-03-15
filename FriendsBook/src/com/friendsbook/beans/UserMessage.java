package com.friendsbook.beans;

import java.time.LocalDateTime;

public class UserMessage {
	private int id;
	private String fromUser;
	private String toUser;
	private String msgDescription;
	private LocalDateTime timeStamp;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getMsgDescription() {
		return msgDescription;
	}

	public void setMsgDescription(String msgDescription) {
		this.msgDescription = msgDescription;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String toString() {
		return "[" + msgDescription + "]";
	}
	
	public String toString(String userId) {
		if(this.getFromUser().equalsIgnoreCase(userId))
			return "[" + fromUser + ": "+ msgDescription + "]";
		else
			return "[" + toUser + ": "+ msgDescription + "]";
	}
	
}
