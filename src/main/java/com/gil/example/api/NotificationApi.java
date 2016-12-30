package com.gil.example.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gil.example.beans.EventMaintenance;
import com.gil.example.beans.ScheduledMaintenance;
import com.gil.example.beans.UserDetails;
import com.gil.example.logic.MaintenanceController;
import com.gil.example.logic.UsersController;

@RestController
public class NotificationApi {

	@Autowired
	private MaintenanceController maintenanceController;
	
	@RequestMapping(value = "/getAllOpenEvents", method = RequestMethod.GET)
	public @ResponseBody ArrayList<EventMaintenance> getEventMaintenanceJobs() throws Exception {
		System.out.println("hey - open events");
		
		ArrayList<EventMaintenance> eventMaintenanceList = maintenanceController.getEventMaintenanceJobs();	
		if (eventMaintenanceList.size() == 0){
			System.out.println(eventMaintenanceList.size());
			return null;
		}
		
		return eventMaintenanceList;
	}
}
