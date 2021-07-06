package com.dal;
import java.util.ArrayList;

public interface DaoInterface<T> {
	
	ArrayList<T> findAll();
	
	T findById(int id);
		
	T update(T obj);
	
	T save(T obj);
	
	int match(String str1, String str2);
	
	
}