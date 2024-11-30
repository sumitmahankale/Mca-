package com.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class UserCreation {
	
	@Id
	private String newUserName;
	private String newPassWord;
	private String ConfirmNewPassword;
	public String getNewUserName() {
		return newUserName;
	}
	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}
	public String getNewPassWord() {
		return newPassWord;
	}
	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}
	public String getConfirmNewPassword() {
		return ConfirmNewPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		ConfirmNewPassword = confirmNewPassword;
	}
	public UserCreation(String newUserName, String newPassWord, String confirmNewPassword) {
		super();
		this.newUserName = newUserName;
		this.newPassWord = newPassWord;
		ConfirmNewPassword = confirmNewPassword;
	}
	@Override
	public String toString() {
		return "UserCreation [newUserName=" + newUserName + ", newPassWord=" + newPassWord + ", ConfirmNewPassword="
				+ ConfirmNewPassword + "]";
	}
	public UserCreation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
