package com.qa.connecting.model;

public class Items {

	private int itemId;
	private String itemName;
	private int quantity;
	private double price;
	
	public Items() {
	}
	
	public Items(String itemName, int quantity, double price) {
		this.setItemName(itemName);
		this.quantity=quantity;
		this.price=price;
			
	}
	
	public Items(int itemId, String itemName, int quantity, double price) {
		this.setItemId(itemId);
		this.setItemName(itemName);
		this.quantity=quantity;
		this.price=price;
			
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

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
