package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.Customer;
import com.utilities.DbCon;

public class CustomerDao implements DaoInterface<Customer> {
	
	private static String TABLE = "customers";
	
	private Customer populateCustomer(ResultSet rs) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getString(1));
		customer.setStatus(rs.getString(2));
		customer.setLastUpdated(rs.getString(3));
		customer.setSsn(rs.getString(4));
		customer.setFirstName(rs.getString(5));
		customer.setLastName(rs.getString(6));
		customer.setDob(rs.getString(7));
		customer.setAddress1(rs.getString(8));
		customer.setAddress2(rs.getString(9));
		customer.setCity(rs.getString(10));
		customer.setState(rs.getString(11));
		customer.setZip(rs.getString(12));
		return customer;
	}
	
	private PreparedStatement prepareStatement(PreparedStatement ps, Customer obj) throws SQLException {
		ps.setString(1, obj.getStatus());
		ps.setString(2, obj.getSsn());
		ps.setString(3, obj.getFirstName());
		ps.setString(4, obj.getLastName());
		ps.setString(5, obj.getDob());
		ps.setString(6, obj.getAddress1());
		ps.setString(7, obj.getAddress2());
		ps.setString(8, obj.getCity());
		ps.setString(9, obj.getState());
		ps.setString(10, obj.getZipCode());
		return ps;
	}

	public ArrayList<Customer> findAll() {
		ArrayList<Customer> result = new ArrayList<Customer>();
		Connection con = DbCon.getConnection();
		try {
			String sql = "select * from " + TABLE;
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Customer customer = populateCustomer(rs);
				result.add(customer);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return result;
	}
	
	public ArrayList<Customer> findAllByMatch(String match){
		ArrayList<Customer> result = new ArrayList<Customer>();
		Connection con = DbCon.getConnection();
		try {
			String sql = "select * from " + TABLE + " where customer_status = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, match);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Customer customer = populateCustomer(rs);
				result.add(customer);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return result;
	}

	public Customer findById(int id) {
		Customer customer = new Customer();
		Connection con = DbCon.getConnection();
		try {
			String sql = "select * from " + TABLE + " where customer_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id+"");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				customer = populateCustomer(rs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return customer;
	}
	
	public Customer findBySsn(String ssn) {
		Customer customer = new Customer();
		Connection con = DbCon.getConnection();
		try {
			String sql = "select * from " + TABLE + " where customer_ssn = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, ssn);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				customer = populateCustomer(rs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return customer;
	}
	
	public Customer findByStringId(String id) {
		Customer customer = new Customer();
		Connection con = DbCon.getConnection();
		try {
			String sql = "select * from " + TABLE + " where customer_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				customer = populateCustomer(rs);
			}
		}catch(Exception e) {
			e.printStackTrace();
			customer = null;
		}finally {
			DbCon.closeConnection();
		}
		return customer;
	}

	public Customer update(Customer obj) {
		Connection con = DbCon.getConnection();
		try {
			String sql = "update " + TABLE + 
					" set customer_status = ?, customer_lastupdated = sysdate, "
					+ "customer_ssn = ?, customer_first = ?, customer_last = ?, customer_dob = ?, "
					+ "customer_address1 = ?, customer_address2 = ?, customer_city = ?, customer_state = ?, customer_zipcode = ? "
					+ "where customer_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			prepareStatement(st,obj);
			st.setString(11, obj.getId()+"");
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return obj;
	}

	public Customer save(Customer obj) {
		Connection con = DbCon.getConnection();
		try {
			String sql = "insert into " + TABLE + 
					"  (customer_status, customer_lastupdated, "
					+ "customer_ssn, customer_first, customer_last, customer_dob, "
					+ "customer_address1, customer_address2, customer_city, customer_state, customer_zipcode) "
					+ "values(?,sysdate,?,?,?,?,?,?,?,?,?)";
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

	public void delete(String id) {
		Connection con = DbCon.getConnection();
		try {
			String sql = "update " + TABLE + " set customer_status = ?, customer_lastupdated = sysdate where customer_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			String updateStatus = "I";
			st.setString(1, updateStatus);
			st.setString(2, id);
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
	}

	public int match(String str1, String str2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ArrayList<Customer> findByLastName(String searchString){
		ArrayList<Customer> result = new ArrayList<Customer>();
		Connection con = DbCon.getConnection();
		try {
			String newString = "%"+searchString.toUpperCase()+"%";
			String sql = "select * from " + TABLE + " where UPPER(customer_last) like ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, newString );
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Customer customer = populateCustomer(rs);
				result.add(customer);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return result;
	}

	public Customer findCustomerByAccountId(String searchString) {
		Customer customer = new Customer();
		Connection con = DbCon.getConnection();
		try {
			String sql = "select * from " + TABLE + " where customer_id in (select customer_id from accounts where account_id = ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, searchString);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				customer = populateCustomer(rs);
			}
		}catch(Exception e) {
			e.printStackTrace();
			customer = null;
		}finally {
			DbCon.closeConnection();
		}
		return customer;
	}
	

}
