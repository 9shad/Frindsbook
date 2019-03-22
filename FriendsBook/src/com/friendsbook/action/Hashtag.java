package com.friendsbook.action;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import com.friendsbook.DAO.HashTagDAO;

public class Hashtag {
	
	private List<String> getMostTrendingHashTags(){
		return HashTagDAO.getMostTrendingHashtagDAO();
	}
	
	public void showHashtags() {
		AtomicInteger index = new AtomicInteger(1);
		System.out.println();
		System.out.println("----Top three trending hashtag----");
		getMostTrendingHashTags().forEach(obj -> {System.out.println(index.getAndIncrement() +". "+obj);});
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a hashtag to display related posts: ");
		String input = sc.next();
		if(input!=null && input.charAt(0)!='#'){
			input = "#" + input;
		}
		
		//TODO: display related posts 
		
	}
	
}
