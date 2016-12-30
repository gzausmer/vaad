package com.gil.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gil.example.beans.LoginDetails;
import com.gil.example.beans.Test;
import com.gil.example.beans.Token;
import com.gil.example.beans.UserDetails;
import com.gil.example.logic.LoginController;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;
import java.util.List;

@RestController
public class LoginApi {

	
	@Autowired
	private LoginController loginController;
	
		
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	 public @ResponseBody Token login(@RequestBody LoginDetails loginDetails) 
			throws Exception {
		
		
		Token token = loginController.checkCredentials(loginDetails);
		return token;
					
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	 public void test(@RequestBody List<Test> tests) 
			throws Exception {
		System.out.println(tests);
					
	}
	
}
