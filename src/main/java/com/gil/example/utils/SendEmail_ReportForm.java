package com.gil.example.utils;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;

import com.gil.example.beans.ReportFormDetails;

@Controller
public class SendEmail_ReportForm {

	private Properties mailServerProperties;
	private Session getMailSession;
	private MimeMessage generateMailMessage;
	
	public void sendEmail(ReportFormDetails reportFormDetails,
			String sender,
			String userName,
			String Emailaddress,
			String userEmail,
			String userPass) throws AddressException, MessagingException{
	// Step1

	System.out.println("\n setup Mail Server Properties");
	mailServerProperties = System.getProperties();
	mailServerProperties.put("mail.smtp.port", "587");
	mailServerProperties.put("mail.smtp.auth", "true");
	mailServerProperties.put("mail.smtp.starttls.enable", "true");
	System.out.println("Mail Server Properties have been setup successfully..");

	// Step2
	System.out.println("\n\n get Mail Session..");
	getMailSession = Session.getDefaultInstance(mailServerProperties, null);
	generateMailMessage = new MimeMessage(getMailSession);
	generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(Emailaddress));
	
	generateMailMessage.setSubject("New report from" + sender);
	String emailBody = "Hi there" + userName + "<br><br>" 
						+ sender +" sent the following report: <br>"
						+ reportFormDetails.toString();
	
	generateMailMessage.setContent(emailBody, "text/html");
	System.out.println("Mail Session has been created successfully..");

	System.out.println("\n\n Get Session and Send mail");
	Transport transport = getMailSession.getTransport("smtp");

	transport.connect("smtp.gmail.com", userEmail, userPass);
	transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
	transport.close();
}
	
}
