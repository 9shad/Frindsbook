package com.friendsbook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.friendsbook.beans.UserFriendRequest;
import com.friendsbook.datasource.Connector;

public class ShowFriendListDAO {	
	public static List<String> getFriendList(String userId){
		List<String> friendList = new ArrayList<String>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		final String QUERY = "select from_userid, to_userid from friend_request where status = ? and (from_userid = ? or to_userid = ?)";
		
		try {
			con = Connector.getConnection();
			ps = con.prepareStatement(QUERY);
			ps.setString(1, UserFriendRequest.ACCEPTED);
			ps.setString(2, userId);
			ps.setString(3, userId);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				if(rs.getString("from_userid").equals(userId)){
					friendList.add(rs.getString("to_userid"));
				}else{
					friendList.add(rs.getString("from_userid"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return friendList;
	}
	
	public static List<Object> getFriendProfile(String userId){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object> profileInfo = null;
		final String QUERY = "select user_id, name, gender, school_name, birthday from useraccount where user_id = ?";
		
		try {
			con = Connector.getConnection();
			ps = con.prepareStatement(QUERY);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			if(rs.next()){
				profileInfo = new ArrayList<>();
				profileInfo.add(rs.getString("user_id"));
				profileInfo.add(rs.getString("name"));
				profileInfo.add(rs.getString("gender"));
				profileInfo.add(rs.getString("school_name"));
				profileInfo.add(rs.getDate("birthday").toLocalDate());
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return profileInfo;
	}
}
