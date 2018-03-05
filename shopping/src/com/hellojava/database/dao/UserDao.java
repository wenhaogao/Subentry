package com.hellojava.database.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gellojava.web.entity.User;
import com.hellojava.database.DBManager;

public class UserDao extends DBManager{
	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User loadUserByName(User user) throws SQLException{
		User u=null;
		Connection conn=this.openConnection();
		String sql="select * from users where userName=? and userPwd=?";
		Object[] obs= {user.getUserName(),user.getUserPwd()};
		ResultSet rs=this.query(conn, sql, obs);
		if(rs.next()) {
			u=new User();
			u.setUserId(rs.getInt("userId"));
			u.setUserName(rs.getString("userName"));
			u.setUserPwd(rs.getString("userPwd"));
		}
		this.closeConnection();
		return u;
	}
}
