package com.services;

import java.util.ArrayList;

public interface ServiceInterface<T> {
	
ArrayList<T> findAll();
	
	T findById(int id);
	
	int match(String str1, String str2);
	
	T update(T obj);
	
	T save(T obj);
	

}
