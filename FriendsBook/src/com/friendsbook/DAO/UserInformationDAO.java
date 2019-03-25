package com.friendsbook.DAO;

import com.friendsbook.beans.UserFriend;
import com.friendsbook.beans.UserInformation;

public class UserInformationDAO {

	public static UserInformation initialize(UserFriend user) {
		UserInformation userInfo = new UserInformation(user);
		userInfo.setUserFriendList(FriendDAO.getFriendList(user.getUserId()));
		userInfo.setNotificationsForUser(NotificationDAO.getUnProsessedUserNotification(user.getUserId()));
		userInfo.setPostsForUser(UserPostDAO.getNewPosts(user.getUserId()));
		return userInfo;
	}
	
}
