package com.friendsbook.action;

import java.time.LocalDate;
import java.util.Scanner;

import com.friendsbook.DAO.UpdateProfileDAO;
import com.friendsbook.beans.User;

public class UpdateProfile {

	public String updateProfile(User usr){
		User user = new User();
		Scanner sc = new Scanner(System.in);
		StringBuilder description = new StringBuilder();
		
		System.out.print("Do you wish to update name? [y:n] : ");
		if(sc.next().equalsIgnoreCase("y")){
			System.out.print("Enter name: ");
			sc.nextLine(); // to consume the \n character
			user.setName(sc.nextLine());
			description.append("User "+usr.getUserId() +" updated name to: "+user.getName()+"\n");
		}
		System.out.print("Do you wish to update gender? [y:n] : ");
		if(sc.next().equalsIgnoreCase("y")){
			if(usr.getGender().equals("male")){
				System.out.println("Gender updated to female");
				user.setGender("female");
			}else if(usr.getGender().equals("female")){
				System.out.println("Gender updated to male");
				user.setGender("male");
			}
			description.append("User "+usr.getUserId() +" updated gender to : "+user.getGender()+"\n");
		}
		
		System.out.print("Do you wish to update school? [y:n] : ");
		if(sc.next().equalsIgnoreCase("y")){
			System.out.print("Enter school name: ");
			user.setSchoolName(sc.next());
			description.append("User "+usr.getUserId() +" updated school to: " + user.getSchoolName()+"\n");
		}
		
		System.out.print("Do you wish to update birthday? [y:n] : ");
		if(sc.next().equalsIgnoreCase("y")){
			System.out.print("Enter month: (1 to 12): ");
			int month = sc.nextInt();
			if(month <1 || month >12){
				return "Invalid Month!";
			}
			System.out.print("Enter day: (1 to 31): ");
			int day = sc.nextInt();
			if(day <1 && day>31){
				return "Invalid Day";
			}else if(month ==2 && day > 28){
				return "Invalid Day";
			}
			System.out.print("Enter year: (YYYY): ");
			int year = sc.nextInt();
			if(year > LocalDate.now().getYear()){
				return "Invalid Year";
			}else if(year ==  LocalDate.now().getYear() && month > LocalDate.now().getMonthValue()){
				return "Invalid Year";
			}
			//YYYY-MM-DD
			user.setBirthdayDate(LocalDate.of(year, month, day));
			description.append("User "+usr.getUserId() +" updated birthdate to: " + user.getBirthdayDate()+"\n");
		}
		
		if (user.getName() != null)
			usr.setName(user.getName());
		if(user.getGender() != null)
			usr.setGender(user.getGender());
		if(user.getSchoolName() != null)
			usr.setSchoolName(user.getSchoolName());
		if(user.getBirthdayDate() != null)
			usr.setBirthdayDate(user.getBirthdayDate());
		
		if(description.length() != 0){
			if(updateProfile(usr, description.toString())){
				return "Profile updated successfully!";
			}else{
				return "Oops!! Profile Not updated, please try again";
			}
		}else{
			return null;
		}
		
	}
	
	private boolean updateProfile(User user, String changeLog){
		return UpdateProfileDAO.updateUserProfileDAO(user, changeLog);
	}
	
}
