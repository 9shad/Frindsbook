package com.friendsbook.action;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.friendsbook.beans.UserPost;

public class CreatePost {
	
	
	public void createPost(String userId){
		Scanner sc = new Scanner(System.in);
		UserPost post = new UserPost();
		post.setType(UserPost.POST);
		post.setUserId(userId);
		post.setTimeStamp(LocalDateTime.now());
		
		System.out.print("Enter your post information: ");
		post.setDescription(sc.nextLine());
		
		if(createPost(post)){
			System.out.println("Post created successfully");
		}else{
			System.out.println("Oops! something went wrong, please try again.");
		}
		
		sc.close();
	}

	private boolean createPost(UserPost post){
		
		
		return false;
	}
	
}
