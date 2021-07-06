package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.beans.User;
import com.utilities.DbCon;

public class UserDao implements DaoInterface<User> {
	
	private static String TABLE = "user_login";

	public ArrayList<User> findAll() {
		ArrayList<User> result = new ArrayList<User>();
		Connection con = DbCon.getConnection();
		try {
			String sql = "select * from " + TABLE;
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				User account = new User();
				account.setId(rs.getInt(1));
				account.setUsername(rs.getString(2));
				account.setPassword(rs.getString(3));
				result.add(account);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return result;
	}

	public User findById(int id) {
		User account = new User();
		Connection con = DbCon.getConnection();
		try {
			String sql = "select * from " + TABLE + " where user_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				account.setId(rs.getInt(1));
				account.setUsername(rs.getString(2));
				account.setPassword(rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return account;
	}

	public User update(User obj) {
		Connection con = DbCon.getConnection();
		try {
			String sql = "update " + TABLE + " set username = ?, user_password = ? where user_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, obj.getUsername());
			st.setString(2, obj.getPassword());
			st.setInt(3, obj.getId());
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return obj;
	}

	public User save(User obj) {
		Connection con = DbCon.getConnection();
		try {
			String sql = "insert into " + TABLE + " (username, user_password) values(?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, obj.getUsername());
			st.setString(2, obj.getPassword());
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return obj;
	}

	public int match(String str1, String str2) {
		int match = -1;
		Connection con = DbCon.getConnection();
		try {
			String sql = "select user_id from " + TABLE + " where username = ? and user_password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, str1);
			ps.setString(2, str2);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				match = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return match;
	}

	

}