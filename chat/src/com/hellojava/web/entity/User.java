package com.hellojava.web.entity;

import java.io.Serializable;

public class User implements Serializable{
	private int userId;
	private String userName;
	private String userPwd;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj instanceof User) {
			User u=(User)obj;
			return this.getUserName().equals(u.getUserName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.getUserName().hashCode();
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + "]";
	}
	
}
