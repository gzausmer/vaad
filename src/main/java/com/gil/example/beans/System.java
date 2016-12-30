package com.gil.example.beans;

public class System {

	private String systemType;

	public System(){}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	@Override
	public String toString() {
		return "System [systemType=" + systemType + "]";
	}
	
	
}
