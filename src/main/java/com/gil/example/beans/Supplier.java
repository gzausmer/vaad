package com.gil.example.beans;

public class Supplier {

	private int id;
	private String name;
	private String profession;
	private String phone;
	private String email;
	private String company;
	private String buisness_number;
	
	public Supplier(){}

	public Supplier(int id, String name, String profession, String phone, String email, String company,
			String buisness_number) {
	
		this.id = id;
		this.name = name;
		this.profession = profession;
		this.phone = phone;
		this.email = email;
		this.company = company;
		this.buisness_number = buisness_number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBuisness_number() {
		return buisness_number;
	}

	public void setBuisness_number(String buisness_number) {
		this.buisness_number = buisness_number;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", profession=" + profession + ", phone=" + phone + ", email="
				+ email + ", company=" + company + ", buisness_number=" + buisness_number + "]";
	};
		
}
