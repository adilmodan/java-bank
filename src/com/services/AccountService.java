package com.services;

import java.util.ArrayList;
import com.dal.AccountDao;
import com.dal.CustomerDao;
import com.beans.Account;

public class AccountService implements ServiceInterface<Account> {

	private static AccountDao aService;
	
	public AccountService() {
		aService= new AccountDao();
	}
	
	public ArrayList<Account> findAll() {
		// TODO Auto-generated method stub
		return aService.findAll();
	}

	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int match(String str1, String str2) {
		// TODO Auto-generated method stub
		return 0;
	}
	//updates the accounts balance
	public Account update(Account obj) {
		// TODO Auto-generated method stub
		return aService.update(obj);
	}
	

	public Account save(Account obj) {
		// TODO Auto-generated method stub
		return aService.save(obj);
	}
	
	public Account findByStringId(String id) {
		return aService.findByStringId(id);
	}
	
	public void changeAccountStatus(String accountId, String currentStatus) {
		aService.changeAccountStatus(accountId, currentStatus);
	}
	
	public ArrayList<Account> findAllAccountsByCustomerId(String id){
		return aService.findAllAccountsByCustomerId(id);
	}

	public ArrayList<Account> findAllAccounts() {
		// TODO Auto-generated method stub
		return aService.findAll();
	}
	
}
	

