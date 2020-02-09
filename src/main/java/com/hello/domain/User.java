package com.hello.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 20)
	private String UserID;
	
	private String UserName;
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
