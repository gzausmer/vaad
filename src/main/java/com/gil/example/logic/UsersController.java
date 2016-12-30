package com.gil.example.logic;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.gil.example.beans.UserDetails;
import com.gil.example.dao.UsersManager;
import com.gil.example.utils.SendEmail_MaintenanceEvent;


@Controller
public class UsersController {
	
	@Autowired
	private SendEmail_MaintenanceEvent emailSender;
	
	@Autowired
	private UsersManager usersManager;
	
	
	public void createUser(UserDetails userDetails) throws ApplicationException, AddressException, MessagingException 
	{
		emailSender.sendEmail(userDetails.getFirstName(), userDetails.getEmail(),"gilzausmer.dev@gmail.com" , "tAmir15d3v", "");
		System.out.println(userDetails.toString());
		
		usersManager.persistUser(userDetails);

	}
	
	
}
