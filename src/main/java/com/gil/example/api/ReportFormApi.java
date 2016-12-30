	package com.gil.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gil.example.beans.ReportFormDetails;
import com.gil.example.beans.SenderDetails;
import com.gil.example.beans.UserDetails;
import com.gil.example.logic.ReportFormController;
import com.gil.example.logic.UsersController;

@RestController
public class ReportFormApi {
	
	@Autowired
	private ReportFormController reportFormController;
	
	
	@RequestMapping(value = "/sendReportForm", method = RequestMethod.POST)
	public @ResponseBody void sendReportForm(@RequestBody ReportFormDetails reportFormDetails, 
			@RequestBody UserDetails userDetails, 
			@RequestBody SenderDetails senderDetails) 
			throws Exception {
		
		reportFormController.sendReport(reportFormDetails, senderDetails, userDetails);
		
	}
}
