package com.hello.web;

public class User {
	private String UserName;
	private String UserID;
	private String Password;
	
	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}



	public String getUserID() {
		return UserID;
	}



	public void setUserID(String userID) {
		UserID = userID;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}




	

	
	@Override
	public String toString() {
		return "User [UserName=" + UserName + ", UserID=" + UserID + ", Password=" + Password + "]";
	}
}
