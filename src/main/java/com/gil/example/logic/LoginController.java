package com.gil.example.logic;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gil.example.beans.LoginDetails;
import com.gil.example.beans.Token;
import com.gil.example.beans.UserDetails;
import com.gil.example.dao.LoginManager;
import com.gil.example.validators.TokenGenerator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Controller
public class LoginController {

	@Autowired
	LoginManager loginManager;
	 
	public Token checkCredentials(LoginDetails loginDetails) throws Exception{
		
		UserDetails userDetails = loginManager.checkCredentials(loginDetails);
		if(userDetails==null){
			System.out.println(loginDetails);
			throw new Exception("wrong details");
		}
		else{
				TokenGenerator tokenGenerator = new TokenGenerator();
				Token token = new Token();
				token.setToken(tokenGenerator.createToken(userDetails.getRole(), userDetails.getFirstName()));
					
			System.out.println("login successful");
			return token;	
		}
	}
}
