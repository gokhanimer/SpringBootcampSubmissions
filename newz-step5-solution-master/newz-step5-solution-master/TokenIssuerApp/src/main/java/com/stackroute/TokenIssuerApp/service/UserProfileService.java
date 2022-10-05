package com.stackroute.TokenIssuerApp.service;

import com.stackroute.TokenIssuerApp.exception.BadMatchException;
import com.stackroute.TokenIssuerApp.model.UserProfile;

public interface UserProfileService {
	
	UserProfile registerUser(UserProfile user) throws BadMatchException;
	
	boolean userLogin(UserProfile user);
}
