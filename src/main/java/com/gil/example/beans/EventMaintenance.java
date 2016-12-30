package com.gil.example.beans;

public class EventMaintenance {

	private int id;
	private String building;
	private String location;
	private String natureOfProblem;
	private String description;
	private String photo;
	private String status;
	private String sender;
	private boolean notificationSent;

	public EventMaintenance(){

	}

	public EventMaintenance(int id, String building, String location, String natureOfProblem, String description,
			String photo, String status, String sender, boolean notificationSent) {

		this.id = id;
		this.building = building;
		this.location = location;
		this.natureOfProblem = natureOfProblem;
		this.description = description;
		this.photo = photo;
		this.status = status;
		this.sender = sender;
		this.notificationSent = notificationSent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNatureOfProblem() {
		return natureOfProblem;
	}

	public void setNatureOfProblem(String natureOfProblem) {
		this.natureOfProblem = natureOfProblem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public boolean getNotificationSent() {
		return notificationSent;
	}

	public void setNotificationSent(boolean notificationSent) {
		this.notificationSent = notificationSent;
	}

	@Override
	public String toString() {
		return "EventMaintenance [building=" + building + ", location=" + location + ", natureOfProblem="
				+ natureOfProblem + ", description=" + description + ", photo=" + photo + ", status=" + status +", sender=" + sender +", notificationSent=" + notificationSent + "]";
	}

}
