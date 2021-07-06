package com.demo;

import com.dal.AccountDao;
import com.dal.CustomerDao;
import com.services.MainService;
import com.services.CustomerService;
import com.services.AccountService;
public class AccountDemo {
	
	public static void main(String [] args) {
		AccountDao dao  = new AccountDao();
		AccountService aService = new AccountService();
//		CustomerDao cDao = new CustomerDao();
//		String customerID = dao.findByStringId("000000006").getCustomerId();
//		System.out.println(dao.findByStringId("000000006"));
//		System.out.println(cDao.findByStringId(customerID));
		MainService mainService = new MainService();
//		
//		System.out.println(mainService.findCustomerByAccountId("000000006"));
		System.out.println(mainService.findAllAccountsByCustomerId("000000010").get(0));
		
	}

}
