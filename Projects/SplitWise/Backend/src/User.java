package com.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String UserName;
	private String PassWord;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public User(int userID, String userName, String passWord) {
		super(); 
		UserName = userName;
		PassWord = passWord;
	}
	@Override
	public String toString() {
		return "User [ UserName=" + UserName + ", PassWord=" + PassWord + "]";
	}
	

}
