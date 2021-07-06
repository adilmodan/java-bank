package com.services;
import java.util.ArrayList;

import com.beans.Account;
import com.beans.Customer;
import com.beans.UserDetails;


public class MainService {

	UserService uService;
	UserDetailsService dService;
	CustomerService cService;
	AccountService aService;
	
	public MainService(){
		uService = new UserService();
		dService = new UserDetailsService();
		cService = new CustomerService();
		aService = new AccountService();
	}
	
	public UserDetails logInService(String username, String password) {
		UserDetails ud = null;
		int match = uService.match(username, password);
		if(match != -1) {
			ud = dService.findById(match);
			dService.update(ud);
		}
		return ud;
	}
	
	public ArrayList<Customer> displayCustomerService(String match){
		return cService.findAllByMatch(match);
	}
	
	public ArrayList<Customer> findAllCustomers(){
		return cService.findAll();
	}
	
	public Customer saveCustomer(Customer obj) {
		return cService.save(obj);
	}
	
	public void deleteCustomer(String id) {
		cService.delete(id);
	}
	
	public Customer findBySsn(String ssn) {
		return cService.findBySsn(ssn);
	}
	
	public Customer updateCustomer(Customer customer) {
		return cService.update(customer);
	}
	
	public Customer findCustomerByStringId(String id) {
		return cService.findByStringId(id);
	}
	
	public Account findAccountByStringId(String id) {
		return aService.findByStringId(id);
	}
	
	public void changeAccountStatus(String accountId, String currentStatus) {
		aService.changeAccountStatus(accountId, currentStatus);
	}
	
	public ArrayList<Customer> findByLastName(String searchString){
		return cService.findByLastName(searchString);
	}
	
	public Customer findCustomerByAccountId(String searchString) {
		return cService.findCustomerByAccountId(searchString);
	}
	
	public Account saveAccount(Account obj) {
		return aService.save(obj);
	}
	
	public ArrayList<Account> findAllAccountsByCustomerId(String id){
		return aService.findAllAccountsByCustomerId(id);
	}
	
	public ArrayList<Account> findAllAccounts(){
		return aService.findAllAccounts();
	}
	
}