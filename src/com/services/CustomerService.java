package com.services;

import java.util.ArrayList;

import com.beans.Customer;
import com.dal.CustomerDao;

public class CustomerService implements ServiceInterface<Customer> {
	
	private static CustomerDao dao;
	
	public CustomerService() {
		dao = new CustomerDao();
	}

	public ArrayList<Customer> findAll() {
		return dao.findAll();
	}

	public Customer findById(int id) {
		return dao.findById(id);
	}
	public Customer findBySsn(String ssn) {
		return dao.findBySsn(ssn);
	}
	public Customer findByStringId(String id) {
		return dao.findByStringId(id);
	}

	public Customer update(Customer obj) {
		return dao.update(obj);
	}

	public Customer save(Customer obj) {
		return dao.save(obj);
	}
	
	public ArrayList<Customer> findAllByMatch(String match){
		return dao.findAllByMatch(match);
	}

	public void delete(String id) {
		dao.delete(id);
	}

	public int match(String str1, String str2) {
		// TODO Auto-generated method stub
		return 0;
		
	}
	public ArrayList<Customer> findByLastName(String searchString){
		return dao.findByLastName(searchString);
	}

	public Customer findCustomerByAccountId(String searchString) {
		// TODO Auto-generated method stub
		return dao.findCustomerByAccountId(searchString);
	}

	

}
