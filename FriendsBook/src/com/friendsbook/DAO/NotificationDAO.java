package com.friendsbook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.friendsbook.beans.UserNotification;
import com.friendsbook.datasource.Connector;

public class NotificationDAO {
	
	public static int createNotificationDAO(UserNotification userNotification){
		int result = -1;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		final String QUERY = "insert into user_notification values(?,?,?,?)";
		
		try {
			con = Connector.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(QUERY,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, userNotification.getNotificationType());
			ps.setString(2, userNotification.getStatus());
			ps.setString(3, userNotification.getUserId());
			ps.setTimestamp(4, java.sql.Timestamp.valueOf(userNotification.getTimeStamp()));
			
			if(ps.executeUpdate() != 1){
				con.rollback();
				return result;
			}
			
			rs = ps.getGeneratedKeys();

		    if (rs.next()) {
		        result = rs.getInt(1);
		    }
		    
		    if(result != -1){
		    	con.commit();
		    	return result;
		    }else{
		    	con.rollback();
		    }
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
