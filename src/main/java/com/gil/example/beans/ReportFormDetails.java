package com.gil.example.beans;

import org.springframework.stereotype.Controller;

@Controller
public class ReportFormDetails {
	
	private String utilityOnForm;
	private String locationOnForm;
	private String textArea;
	
	
	public ReportFormDetails() {
	
	}


	public String getUtilityOnForm() {
		return utilityOnForm;
	}


	public void setUtilityOnForm(String utility) {
		this.utilityOnForm = utility;
	}


	public String getLocationOnForm() {
		return locationOnForm;
	}


	public void setLocationOnForm(String location) {
		this.locationOnForm = location;
	}


	public String getTextArea() {
		return textArea;
	}


	public void setTextArea(String message) {
		this.textArea = message;
	}


	@Override
	public String toString() {
		return "ReportFormDetails [utility=" + utilityOnForm + ", location=" + locationOnForm + ", message=" + textArea + "]";
	}
	
	
	
}
