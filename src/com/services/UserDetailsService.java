package com.services;

import java.util.ArrayList;
import com.beans.UserDetails;
import com.dal.UserDetailsDao;

public class UserDetailsService implements ServiceInterface<UserDetails> {
	private static UserDetailsDao dao;
	
	public UserDetailsService() {
		dao = new UserDetailsDao();
	}

	public ArrayList<UserDetails> findAll() {
		return dao.findAll();
	}

	public UserDetails findById(int id) {
		return dao.findById(id);
	}

	public int match(String str1, String str2) {
		return dao.match(str1, str2);
	}

	public UserDetails update(UserDetails obj) {
		return dao.update(obj);
	}

	public UserDetails save(UserDetails obj) {
		return dao.save(obj);
	}



}
