package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.beans.UserDetails;
import com.utilities.DbCon;

public class UserDetailsDao implements DaoInterface<UserDetails> {
	
	private static String TABLE = "user_details";


	public ArrayList<UserDetails> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDetails findById(int id) {
		// TODO Auto-generated method stub
		UserDetails ud = new UserDetails();
		Connection con = DbCon.getConnection();
		try {
			String sql = "select * from " + TABLE + " where user_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				ud.setId(rs.getInt(1));
				ud.setfName(rs.getString(2));
				ud.setlName(rs.getString(3));
				ud.setRole(rs.getString(4));
				ud.setLastLogin(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return ud;
	}

	public UserDetails update(UserDetails obj) {
		Connection con = DbCon.getConnection();
		try {
			String sql = "update " + TABLE + " set user_first_name = ?, user_last_name = ?, user_role = ?, user_login_timestamp = sysdate"
					+ " where user_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, obj.getfName());
			st.setString(2, obj.getlName());
			st.setString(3, obj.getRole());
			st.setInt(4, obj.getId());
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return obj;
	}

	public UserDetails save(UserDetails obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public int match(String str1, String str2) {
		// TODO Auto-generated method stub
		return 0;
	}



}
