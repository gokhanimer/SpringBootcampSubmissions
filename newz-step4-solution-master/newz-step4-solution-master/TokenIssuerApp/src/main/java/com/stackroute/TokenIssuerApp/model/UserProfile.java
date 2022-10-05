package com.stackroute.TokenIssuerApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserProfile {
	
	@Id
    private String userid;

    private String password; 

    private String confirmpassword;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
    
    

}
