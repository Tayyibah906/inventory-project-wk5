package com.qa.connecting.model;

public class Customer {

	private int customerId;
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	private int age;
	
	public Customer() {
	}

	public Customer(String name, String address, String phoneNumber, String email, int age) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.age = age;
	}
	
	public Customer(int customerId, String name, String address, String phoneNumber, String email, int age) {
		this.customerId=customerId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.age = age;
	}
	
	


	@Override
	public String toString() {
		return "Customer [customer_id=" + customerId + ", name=" + name + ", address=" + address + ", phone_number="
				+ phoneNumber + ", email=" + email + ", age=" + age + "]";
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
