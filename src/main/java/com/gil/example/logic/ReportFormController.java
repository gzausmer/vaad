package com.gil.example.logic;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gil.example.beans.ReportFormDetails;
import com.gil.example.beans.SenderDetails;
import com.gil.example.beans.UserDetails;
import com.gil.example.utils.SendEmail_ReportForm;

@Controller
public class ReportFormController {

	@Autowired
	private SendEmail_ReportForm emailSender;
	
	public void sendReport(ReportFormDetails reportFormDetails, SenderDetails senderDetails, UserDetails userDetails) throws AddressException, MessagingException{
		emailSender.sendEmail(reportFormDetails, 
				senderDetails.getEmail(),
				userDetails.getFirstName(),
				userDetails.getEmail(),
				"gilzausmer.dev@gmail.com",
				"tAmir15d3v");
	}
};
