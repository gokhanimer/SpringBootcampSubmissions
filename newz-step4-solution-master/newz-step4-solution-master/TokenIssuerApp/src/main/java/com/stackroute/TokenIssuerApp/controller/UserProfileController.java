package com.stackroute.TokenIssuerApp.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.TokenIssuerApp.exception.BadMatchException;
import com.stackroute.TokenIssuerApp.model.UserProfile;
import com.stackroute.TokenIssuerApp.service.UserProfileService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping
public class UserProfileController {
	
	@Autowired
	UserProfileService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> saveuser(@RequestBody UserProfile user) throws BadMatchException {
		UserProfile res = service.registerUser(user);
		return new ResponseEntity<UserProfile>(res, HttpStatus.CREATED);
	}
	@PostMapping("/login")
	public ResponseEntity<?> loginuser(@RequestBody UserProfile user) {
		boolean log = service.userLogin(user);
		if (log)
		{
			String token = generateToken(user);
			HashMap map = new HashMap();
			map.put("newzToken", token);
			return new ResponseEntity<HashMap>(map, HttpStatus.OK);
		}
		else 
			return new ResponseEntity<String>("Invalid credentials", HttpStatus.UNAUTHORIZED);
}
	String generateToken(UserProfile uso) {
		
		return Jwts.builder()
				.setSubject(uso.getUserid())
				.signWith(SignatureAlgorithm.HS256, "newz")
				.compact();
	}
}
