package com.friendsbook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.friendsbook.beans.User;
import com.friendsbook.datasource.Connector;

public class UpdateProfileDAO {

	public static boolean updateUserProfileDAO(User user, String changeLog){
		//TODO: update the change log information to user post table for users friend to see the update
		Connection con = null;
		PreparedStatement ps = null;
		final String QUERY = "update useraccount set name = ?, gender = ?, school_name = ?, birthday = ? where user_id=?";
		
		try {
			con = Connector.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(QUERY);
			ps.setString(1, user.getName());
			ps.setString(2, user.getGender());
			ps.setString(3, user.getSchoolName());
			ps.setDate(4, java.sql.Date.valueOf(user.getBirthdayDate()));
			ps.setString(5, user.getUserId());
			if(ps.executeUpdate()==1){
				con.commit();
				return true;
			}
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				//con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
