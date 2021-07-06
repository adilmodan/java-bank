package com.beans;

public class UserDetails {
	private String fName, lName, role, lastLogin;
	private int id;
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public int getId() {
		return id;
	}
	
	public  void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return"Details : [ID: "  + id + ", First Name:  " + fName + ", Last Name: " 
				+ lName + ", Role: " + role + ", Last Login: " + lastLogin + "]"; 
	}
	
	
}
