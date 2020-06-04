package com.qa.connecting.model;

public class Orders {

	private int fk_customer_id;
	private int total;
	private String item_description;
	
	public Orders(int fk_customer_id, int total, String item_description) {
		this.fk_customer_id = fk_customer_id;
		this.total =total;
		this.item_description =item_description;
	}
	
	
	
	public int getFk_customer_id() {
		return fk_customer_id;
	}
	public void setFk_customer_id(int fk_customer_id) {
		this.fk_customer_id = fk_customer_id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getItem_description() {
		return item_description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
}
