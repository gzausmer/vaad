package com.gil.example.logic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gil.example.beans.EventMaintenance;
import com.gil.example.beans.ScheduledMaintenance;
import com.gil.example.dao.MaintenanceManager;
import com.gil.example.utils.SendEmail_MaintenanceEvent;


@Controller
public class MaintenanceController {

	@Autowired 
	MaintenanceManager maintenanceManager;
	
	@Autowired 
	SendEmail_MaintenanceEvent mailSender;
	
	public void addScheduledMaintenanceContract(MultipartFile contract, String fileName) throws IOException {
		File file = new File("/Users/gilzausmer/Desktop/PDAC_PHP_Test_Gil_Zausmer/"+ fileName + ".txt");
		contract.transferTo(file);
	}
	
	public void addScheduledMaintenance(ScheduledMaintenance scheduledMaintenance){
		maintenanceManager.persistScheduledMaintenance(scheduledMaintenance);
		
	}
	
	public void updateEventMaintenanceStatus(EventMaintenance eventMaintenance){
		//send email if notified
		maintenanceManager.mergeEventMaintenanceStatus(eventMaintenance);
	}

	public void addEventMaintenancePhoto(MultipartFile photo, String photoName) throws IOException {
		File pic = new File("/Users/gilzausmer/Desktop/PDAC_PHP_Test_Gil_Zausmer/"+ photoName + ".txt");
        photo.transferTo(pic);
	}
	
	public void addEventMaintenance(EventMaintenance eventMaintenance, String userEmail, String problemoLocation) throws AddressException, MessagingException {
		
		maintenanceManager.persistEventMaintenance(eventMaintenance);	
		mailSender.sendEmail("", userEmail, "gilzausmer.dev@gmail.com", "tAmir15d3v", problemoLocation);
	}
	
	public ArrayList<ScheduledMaintenance> getScheduledMaintenanceJobs() throws Exception{
		ArrayList<ScheduledMaintenance> scheduledMaintenanceList = maintenanceManager.findScheduledMaintenanceJobs();
		return scheduledMaintenanceList;
	}
	
	public ArrayList<EventMaintenance> getEventMaintenanceJobs() throws Exception {
		ArrayList<EventMaintenance> eventMaintenanceList = maintenanceManager.findEventMaintenanceJobs();
		return eventMaintenanceList;
	}
}
