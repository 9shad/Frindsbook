package com.friendsbook.beans;

import javax.naming.SizeLimitExceededException;

public class UserComment {
	private int commentId;
	private int postId;
	private String userId;
	private String description;
	
	public UserComment(){}
	
	public UserComment(int commentId) {
		super();
		this.commentId = commentId;
		//write code to initialize object based on comment Id
	}
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
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
	public void setDescription(String description) throws SizeLimitExceededException {
		if(description.length() <= 20)
			this.description = description;
		else
			this.description = description.substring(0, 20);
			//throw new SizeLimitExceededException("Comment cannot have more than 20 characters.");
	}
	public int getCommentId() {
		return commentId;
	}

	@Override
	public String toString() {
		//return "UserComment [description=" + description + "]";
		return "\t" + description;
	}
	
	
}
