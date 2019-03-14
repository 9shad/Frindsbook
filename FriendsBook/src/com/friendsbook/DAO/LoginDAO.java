package com.friendsbook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.friendsbook.beans.User;
import com.friendsbook.datasource.Connector;
import com.friendsbook.util.EncryptPassword;

public class LoginDAO {
	
	public static User checkUserCredentials(String userId, String password){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		final String QUERY = "select * from useraccount where user_id= ? and password = ?";
		try {
			con = Connector.getConnection();
			ps = con.prepareStatement(QUERY);
			ps.setString(1, userId);
			ps.setString(2, EncryptPassword.cryptWithMD5(password));
			rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setSchoolName(rs.getString("school_name"));
				user.setBirthdayDate(rs.getDate("birthday").toLocalDate());
				user.setAccountCreatedTimeStamp(rs.getString("account_created_on"));//change this to timestame from string later
				user.setEmail(rs.getString("email"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				//con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
