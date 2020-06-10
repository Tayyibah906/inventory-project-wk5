package com.qa.connecting.model;

public class Order {

	private int orderId;
	private int fkCustomerId;
	
	public Order() {
	}
	public Order(int orderId,int fkCustomerId) {
		this.fkCustomerId = fkCustomerId;
		this.orderId=orderId;
	}
	
	public Order(int orderId) {
		this.orderId=orderId;
	}
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getFkCustomerId() {
		return fkCustomerId;
	}
	public void setFkCustomerId(int fkCustomerId) {
		this.fkCustomerId = fkCustomerId;
	}
	
}
