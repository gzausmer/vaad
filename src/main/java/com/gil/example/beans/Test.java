package com.gil.example.beans;

public class Test {

	private String assetType;
	
	private String owner_name;
	
	private String number;

	

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Test [assetType=" + assetType + ", owner_name=" + owner_name + ", number=" + number + "]";
	}
	
}
