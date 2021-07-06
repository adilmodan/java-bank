package com.services;

import java.util.ArrayList;

import com.beans.User;
import com.dal.UserDao;

public class UserService implements ServiceInterface<User> {
	private static UserDao dao;
	
	public UserService() {
		dao = new UserDao();
	}

	public ArrayList<User> findAll() {
		return dao.findAll();
	}

	public User findById(int id) {
		return dao.findById(id);
	}

	public int match(String str1, String str2) {
		return dao.match(str1, str2);
	}

	public User update(User obj) {
		return dao.update(obj);
	}

	public User save(User obj) {
		return dao.save(obj);
	}

	

}
