package com.gil.example.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gil.example.beans.EventMaintenance;
import com.gil.example.beans.ScheduledMaintenance;
import com.gil.example.beans.UserDetails;
import com.gil.example.logic.MaintenanceController;
import com.gil.example.logic.UsersController;

@RestController
public class MaintenanceApi {

	@Autowired
	private MaintenanceController maintenanceController;
	
	private List<SseEmitter> emitters = new CopyOnWriteArrayList<SseEmitter>();
	
	// Scheduled Maintenance API	
	@RequestMapping(value = "/addScheduledMaintenanceContract",headers=("content-type=multipart/*"), method = RequestMethod.POST)
	public @ResponseBody void addScheduledMaintenanceContract(@RequestPart("file") MultipartFile file,@RequestParam("fileName") String fileName ) throws IOException {
		File contract = new File("/Users/gilzausmer/Desktop/PDAC_PHP_Test_Gil_Zausmer/"+ fileName + ".txt");
		file.transferTo(contract);
	}
	
	@RequestMapping(value = "/addScheduledMaintenance", method = RequestMethod.POST)
	public @ResponseBody void addScheduledMaintenance(@RequestBody ScheduledMaintenance scheduledMaintenance) throws Exception {
		
		maintenanceController.addScheduledMaintenance(scheduledMaintenance);
	}
	
	@RequestMapping(value = "/eventMaintenance", method = RequestMethod.PUT)
	public @ResponseBody void updateEventMaintenanceStatus(@RequestBody EventMaintenance eventMaintenance ) throws Exception {
		System.out.println(eventMaintenance);
		maintenanceController.updateEventMaintenanceStatus(eventMaintenance);
		for(SseEmitter emitter: emitters){
			emitter.send(SseEmitter.event().name("spring").data(eventMaintenance.toString()));
		}
	}
	
	
	// Event Maintenance API
	@RequestMapping(value = "/addEventMaintenancePhoto",headers=("content-type=multipart/*"), method = RequestMethod.POST)
	public @ResponseBody void addEventMaintenancePhoto(@RequestPart("file") MultipartFile photo, @RequestParam("fileName") String photoName ) throws IOException {
		
		maintenanceController.addEventMaintenancePhoto(photo, photoName);
		
	}
	
	@RequestMapping(value = "/newEventNotifications")
		public SseEmitter newEventNotifications(){
		System.out.println("hello?");
		SseEmitter sseEmitter = new SseEmitter();
			emitters.add(sseEmitter);
			sseEmitter.onCompletion(() -> emitters.remove(sseEmitter));
			return sseEmitter;	
		}
	
	
	@RequestMapping(value = "/addEventMaintenance", method = RequestMethod.POST)
	public @ResponseBody void addEventMaintenance(@RequestBody EventMaintenance eventMaintenance) 
			throws Exception {
		
		maintenanceController.addEventMaintenance(eventMaintenance, eventMaintenance.getSender(),eventMaintenance.getLocation() );
		for(SseEmitter emitter: emitters){
			emitter.send(SseEmitter.event().name("spring").data(eventMaintenance.toString()));
		}
	}
	
	@RequestMapping(value = "/getAllScheduledMaintenanceJobs", method = RequestMethod.GET)
	public @ResponseBody ArrayList<ScheduledMaintenance> getScheduledMaintenanceJobs() throws Exception{
		System.out.println("hey - scheduled");
		ArrayList<ScheduledMaintenance> scheduledMaintenanceList = maintenanceController.getScheduledMaintenanceJobs();	
		return scheduledMaintenanceList;
	}
	
	@RequestMapping(value = "/getAllEventMaintenanceJobs", method = RequestMethod.GET)
	public @ResponseBody ArrayList<EventMaintenance> getEventMaintenanceJobs() throws Exception {
		System.out.println("hey - events");
		ArrayList<EventMaintenance> eventMaintenanceList = maintenanceController.getEventMaintenanceJobs();	
		return eventMaintenanceList;
	}
}
