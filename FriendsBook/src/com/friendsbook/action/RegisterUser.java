package com.friendsbook.action;

import java.time.LocalDate;
import java.util.Scanner;

import com.friendsbook.DAO.RegisterUserDAO;
import com.friendsbook.beans.User;
import com.friendsbook.util.EncryptPassword;

public class RegisterUser {
	
	public String registerUser(){
		Scanner sc = new Scanner(System.in);
		User user = new User();
		String result = null;
		
		System.out.println();
		System.out.print("Enter User Id: ");
		user.setUserId(sc.next());
		result = this.validateUserId(user.getUserId());
		if(result != null){
			return result;
		}
		System.out.print("Enter password: ");
		user.setPassword(sc.next());
		result = this.checkPasswordString(user.getUserId(), user.getPassword());
		if(result!=null){
			return result;
		}
		user.setPassword(EncryptPassword.cryptWithMD5(user.getPassword()));
		
		System.out.print("Enter your name: ");
		user.setName(sc.next());
		
		System.out.print("Select your gender: 1. Male, 2.Female :");
		switch(sc.nextInt()){
		case 1:
			user.setGender("male");
			break;
		case 2:
			user.setGender("female");
			break;
		default:
			return "Invalid Option selected for gender";
		}
		
		System.out.print("Enter your School Name: ");
		user.setSchoolName(sc.next());
		
		System.out.println("Enter your birth information");
		System.out.print("Enter month: (1 to 12): ");
		int month = sc.nextInt();
		if(month <1 || month >12){
			return "Invalid month!";
		}
		System.out.print("Enter day: (1 to 31): ");
		int day = sc.nextInt();
		if(day <1 && day>31){
			return "Invalid Day!";
		}else if(month ==2 && day > 28){
			return "Invalid Day!";
		}
		System.out.print("Enter year: (YYYY): ");
		int year = sc.nextInt();
		if(year > LocalDate.now().getYear()){
			return "Invalid year";
		}else if(year ==  LocalDate.now().getYear() && month > LocalDate.now().getMonthValue()){
			return "Invalid year";
		}
		//YYYY-MM-dd
		user.setBirthdayDate(LocalDate.of(year, month, day));
		
		System.out.print("Enter your email: ");
		user.setEmail(sc.next());
		
		if(this.registerUser(user)){
			return "\nYou are successfully registered";
		}else{
			return "\nOops!! something went wrong, please try again!";
		}
	}
	
	
	private boolean registerUser(User user){	
		return RegisterUserDAO.addUserToDB(user);
	}
	
	private String validateUserId(String userId){
		if(!this.checkUserIdString(userId)){
			return "User ID must contain one letter, one number and one character from {#,?,!,*}";
		}else if(RegisterUserDAO.checkUserId(userId)){
			return "User ID Already Exists, please try again!";
		}
		return null;
	}
	
	private boolean checkUserIdString(String input) {
	   // String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
		String specialChars = "#?!*";
	    char currentCharacter;
	    boolean numberPresent = false;
	    boolean characterPresent = false;
	    boolean specialCharacterPresent = false;
	 
	    for (int i = 0; i < input.length(); i++) {
	        currentCharacter = input.charAt(i);
	        if (Character.isDigit(currentCharacter)) {
	            numberPresent = true;
	        } else if (Character.isAlphabetic(currentCharacter)) {
	            characterPresent = true;
	        } else if (specialChars.contains(String.valueOf(currentCharacter))) {
	            specialCharacterPresent = true;
	        }
	    }
	    return
	      numberPresent && characterPresent && specialCharacterPresent;
	}
	
	private String checkPasswordString(String userId,String pass){
		if(userId.equals(pass) || pass.contains(userId)){
			return "Password cannot contain User Id information";
		}
		return null;
	}
	
}
