package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.Account;
import com.beans.Customer;
import com.utilities.DbCon;


public class AccountDao implements DaoInterface<Account> {
	
	private final String TABLE  = "accounts";
	
	private Account populateAccount(ResultSet rs) throws SQLException {
		Account account = new Account();
		account.setAccountId(rs.getString(1));
		account.setCustomerId(rs.getString(2));
		account.setType(rs.getString(3));
		account.setStatus(rs.getString(4));
		account.setBalance(rs.getDouble(5));
		account.setLastTransaction(rs.getString(6));
	
		return account;
	}

	private PreparedStatement prepareStatement(PreparedStatement ps, Account obj) throws SQLException {
		ps.setString(1, obj.getStatus());
		ps.setString(2, obj.getCustomerId());
		ps.setString(3, obj.getType());
		ps.setDouble(4, obj.getBalance());
		return ps;
	}
	


	public ArrayList<Account> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Account> result = new ArrayList<Account>();
		Connection con = DbCon.getConnection();
		try {
			String sql = "select * from " + TABLE;
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Account account = populateAccount(rs);
				result.add(account);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return result;
	}

	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account update(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//public Account updateAccountStatus(String accountId, String accountStatus)

	public Account save(Account obj) {
		Connection con = DbCon.getConnection();
		try {
			String sql = "insert into " + TABLE + 
					" (account_status, last_transaction, "
					+ "customer_id, "
					+ "account_type, balance) "
					+ "values(?,sysdate,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			prepareStatement(st,obj);
			st.executeUpdate();
		}catch(Exception e) {
			obj = null;
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return obj;
	}
	
	

	public int match(String str1, String str2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Account findByStringId(String id) {
		Account account = new Account();
		Connection con = DbCon.getConnection();
		try {
			String sql = "select * from " + TABLE + " where account_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				account = populateAccount(rs);
			}
		}catch(Exception e) {
			e.printStackTrace();
			account = null;
		}finally {
			DbCon.closeConnection();
		}
		return account;
	}
	
	public void changeAccountStatus(String accountId, String currentStatus) {
		//if currentStatus == "O" then change currentStatus to "C"
				//else change currentStatus to O  
	}
	
	public ArrayList<Account> findAllAccountsByCustomerId(String id){
		
		ArrayList<Account> accounts = new ArrayList<Account>();
		Connection con = DbCon.getConnection();
		Account account = new Account();
		try {
			String sql = "select * from " + TABLE + " where customer_id  = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				account = populateAccount(rs);
				accounts.add(account);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			DbCon.closeConnection();
		}
		return accounts;
	}

	

}
