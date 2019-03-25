package com.friendsbook.action;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import com.friendsbook.DAO.UserPostDAO;
import com.friendsbook.beans.UserPost;

public class CreatePost {
	
	public void createPost(String userId){
		UserPost post = new UserPost();
		post.setType(UserPost.POST);
		post.setUserId(userId);
		post.setTimeStamp(LocalDateTime.now());
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your post information: ");
		sc.hasNextLine();//clearing /n character
		post.setDescription(sc.nextLine());
		
		if(createPost(post)){
			System.out.println("Post created successfully!");
		}else{
			System.out.println("Oops! something went wrong, please try again.");
		}
	}

	private boolean createPost(UserPost post){
		return UserPostDAO.createPostDAO(post);
	}
	
	
	public void showMostRecentPostMenu(List<UserPost> posts) {		
		AtomicInteger index = new AtomicInteger(1);
		System.out.println();
		System.out.println("---- Most Recent Post ----");
		posts.forEach(p -> { 
			System.out.println(index.getAndIncrement() +". ["+p.getUserId()+"]: "+p.getDescription());
			p.getUserComments().forEach(c->{System.out.println("\t["+c.getUserId()+"]: "+c);});
		});

	}
	
}
