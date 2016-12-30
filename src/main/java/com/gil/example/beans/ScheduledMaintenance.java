package com.gil.example.beans;

public class ScheduledMaintenance {

	private int id;
	private String system;
	private String priority;
	private String type;
	private String lastCheck;
	private String startOn;
	private String serviceFreqNumber;
	private String serviceFreqEach;
	private String serviceFreqTime;
	private String supplier;
	private String contract;
	private String status;
	private boolean notificationSent;

	public ScheduledMaintenance(){

	}

	public ScheduledMaintenance(int id, String system, String priority, String type, String lastCheck,
			String startOn, String serviceFreqNumber, String serviceFreqEach, String serviceFreqTime, String supplier,
			String contract, String status, boolean notificationSent) {

		this.id = id;
		this.system = system;
		this.priority = priority;
		this.type = type;
		this.lastCheck = lastCheck;
		this.startOn = startOn;
		this.serviceFreqNumber = serviceFreqNumber;
		this.serviceFreqEach = serviceFreqEach;
		this.serviceFreqTime = serviceFreqTime;
		this.supplier = supplier;
		this.contract = contract;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSystem() {
		return system;
	}


	public void setSystem(String system) {
		this.system = system;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getLastCheck() {
		return lastCheck;
	}


	public void setLastCheck(String lastCheck) {
		this.lastCheck = lastCheck;
	}


	public String getStartOn() {
		return startOn;
	}


	public void setStartOn(String startOn) {
		this.startOn = startOn;
	}


	public String getServiceFreqNumber() {
		return serviceFreqNumber;
	}


	public void setServiceFreqNumber(String serviceFreqNumber) {
		this.serviceFreqNumber = serviceFreqNumber;
	}


	public String getServiceFreqEach() {
		return serviceFreqEach;
	}


	public void setServiceFreqEach(String serviceFreqEach) {
		this.serviceFreqEach = serviceFreqEach;
	}


	public String getServiceFreqTime() {
		return serviceFreqTime;
	}


	public void setServiceFreqTime(String serviceFreqTime) {
		this.serviceFreqTime = serviceFreqTime;
	}


	public String getSupplier() {
		return supplier;
	}


	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}


	public String getContract() {
		return contract;
	}


	public void setContract(String contract) {
		this.contract = contract;
	}
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public boolean getNotificationSent() {
		return notificationSent;
	}


	public void setNotificationSent(boolean notificationSent) {
		this.notificationSent = notificationSent;
	}

	@Override
	public String toString() {
		return "ScheduledMaintenance [system=" + system + ", priority=" + priority + ", type=" + type + ", lastCheck="
				+ lastCheck + ", StartOn=" + startOn + ", serviceFreqNumber=" + serviceFreqNumber
				+ ", serviceFreqEach=" + serviceFreqEach + ", serviceFreqTime=" + serviceFreqTime + ", supplier="
				+ supplier + ", contract=" + contract + ", status=" + status + ", notificationSent=" + notificationSent +"]";
	}


}
