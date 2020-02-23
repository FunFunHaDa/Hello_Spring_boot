package com.hello.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 20)
	private String userID;

	private String UserName;
	private String UserEmail;

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		this.UserEmail = userEmail;
	}

	private String Password;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String UserID) {
		this.userID = UserID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public void update(User newUser) {
		// TODO Auto-generated method stub
		
		this.Password = newUser.Password;
		this.UserEmail = newUser.UserEmail;
		this.UserName = newUser.UserName;
		this.userID = newUser.userID;
		System.out.println("update" +newUser);
	}

	@Override
	public String toString() {
		return "User [UserName=" + UserName + ", UserID=" + userID + ", UserEmail=" + UserEmail + ", Password="
				+ Password + "]";
	}
}
