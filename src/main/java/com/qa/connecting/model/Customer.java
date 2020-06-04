package com.qa.connecting.model;

public class Customer {

	private String name;
	private String address;
	private String phone_number;
	private String email;
	private int age;

	public Customer(String name, String address, String phone_number, String email, int age) {
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.email = email;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
