	package com.gil.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gil.example.beans.UserDetails;
import com.gil.example.logic.UsersController;
import com.gil.example.utils.SendEmail_MaintenanceEvent;

@RestController
public class UsersApi {
	
	@Autowired
	private UsersController usersController;
		
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public @ResponseBody void createUser(@RequestBody UserDetails userDetails) 
			throws Exception {
		
		usersController.createUser(userDetails);
	}
}
