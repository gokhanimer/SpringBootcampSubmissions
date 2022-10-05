package com.stackroute.TokenIssuerApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.TokenIssuerApp.model.UserProfile;

@Repository
public interface UserProfileRepo extends JpaRepository <UserProfile, String>{
	UserProfile findByUseridAndPassword(String userid, String password);
}
