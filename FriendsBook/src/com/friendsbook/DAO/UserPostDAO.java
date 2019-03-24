package com.friendsbook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.friendsbook.beans.UserHashtag;
import com.friendsbook.beans.UserPost;
import com.friendsbook.datasource.Connector;

public class UserPostDAO {
	
	public static boolean createPostDAO(UserPost post){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		final String QUERY = "insert into user_post(post_type,user_id,description,timestamp) values (?,?,?,?)";
		int postId = -1;
		List<UserHashtag> tags = new ArrayList<>();
		try {
			con = Connector.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(QUERY,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, post.getType());
			ps.setString(2, post.getUserId());
			ps.setString(3, post.getDescription());
			ps.setTimestamp(4, Timestamp.valueOf(post.getTimeStamp()));
			//ps.setInt(5, post.getPostCount());
			
			if(ps.executeUpdate() == 1){
				
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
			        postId = rs.getInt(1);
			    }
				if(postId != -1 && post.getDescription().contains("#")){
					String[] temp = post.getDescription().split(" "); //we can also use subsring to get index of # and next space for getting hashtag
					for(int i=0;i<temp.length;i++) {
			        	if(temp[i].startsWith("#")) {
			        		UserHashtag hashTag = new UserHashtag(temp[i],postId);
			        		tags.add(hashTag);
			        	}
			        }
					if(tags.size() == 0) {
						con.commit();
						return true;
					}else if(HashTagDAO.createHashTagDAO(tags)) {
			        	con.commit();
				    	return true;
			        }else {
			        	con.rollback();
			        }
				}
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
				ps.close();
				//con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/*public static int getMaxPostCountNumber(){
		Connection con = null;
		Statement s = null;
		ResultSet rs;
		final String QUERY = "select max(post_number) from post";
		try {
			con = Connector.getConnection();
			s = con.createStatement();
			
			rs = s.executeQuery(QUERY);
			
			if(rs.next()){
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}*/
}
