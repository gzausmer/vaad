package com.gil.example.validators;

import java.io.UnsupportedEncodingException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenGenerator {

	public String createToken(String role, String firstname) throws UnsupportedEncodingException{
//		Key key = ;

		String compactJws = Jwts.builder()
				  .setSubject("credentials")
				  .claim("role", role)
				  .claim("firstname", firstname)
				  .signWith(SignatureAlgorithm.HS512, "Gil'sSecret".getBytes("UTF-8"))
				  .compact();
	//	System.out.println(key.toString() + key.);
		return compactJws;
	}
	
}
