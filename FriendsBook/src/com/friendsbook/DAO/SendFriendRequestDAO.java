package com.friendsbook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.friendsbook.beans.UserFriendRequest;
import com.friendsbook.beans.UserNotification;
import com.friendsbook.datasource.Connector;

public class SendFriendRequestDAO {
	public static boolean sendFriendRequestDAO(UserFriendRequest userRequest){
		
		Connection con = null;
		PreparedStatement ps = null;
		final String QUERY = "insert into friend_request values(?,?,?,?,?)";
		
		try {
			con = Connector.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(QUERY);
			ps.setString(1, userRequest.getFromUserId());
			ps.setString(2, userRequest.getToUserId());
			ps.setString(3, userRequest.getStatus());
			ps.setTimestamp(4, java.sql.Timestamp.valueOf(userRequest.getTimeStamp()));
			
			UserNotification userNotification = new UserNotification();
			userNotification.setNotificationType(UserNotification.FRIEND_REQUEST);
			userNotification.setUserId(userRequest.getToUserId());
			userRequest.setNotificationId(NotificationDAO.createNotificationDAO(userNotification));
			
			if(userRequest.getNotificationId() == -1){
				return false;
			}
			
			ps.setInt(5, userRequest.getNotificationId());
			
			if(ps.executeUpdate() != 1){
				con.rollback();
				return false;
			}
			
			return true;
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return false;
	}
}
