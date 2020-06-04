package com.qa.connecting.model;

public class Items {

	private String item;
	private int quantity;
	private double price;
	private int year_published;
	
	public Items(String item, int quantity, double price, int year_published) {
		this.item = item;
		this.quantity=quantity;
		this.price=price;
		this.year_published=year_published;
			
	}
	

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear_published() {
		return year_published;
	}

	public void setYear_published(int year_published) {
		this.year_published = year_published;
	}

}
