package com.stackroute.TokenIssuerApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.TokenIssuerApp.model.UserProfile;
import com.stackroute.TokenIssuerApp.repo.UserProfileRepo;
import com.stackroute.TokenIssuerApp.exception.BadMatchException;

@Service
public class UserProfileServiceImpl implements UserProfileService{

	@Autowired
	UserProfileRepo repo;
	
	@Override
	public UserProfile registerUser(UserProfile user) throws BadMatchException {
		if(user.getPassword().equals(user.getConfirmpassword())) {
			repo.save(user);
		return user;
		}else throw new BadMatchException("password does not mtach");
		
	}

	@Override
	public boolean userLogin(UserProfile upo) {
		UserProfile res = repo.findByUseridAndPassword(upo.getUserid(), upo.getPassword());
		if (res==null)
		return false;
		else
			return true;
	}

}
