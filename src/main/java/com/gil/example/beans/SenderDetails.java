package com.gil.example.beans;

public class SenderDetails {
	
	
	private String email;
	
	public SenderDetails() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "UserDetails [ email=" + email + "]";
	}
	
}
