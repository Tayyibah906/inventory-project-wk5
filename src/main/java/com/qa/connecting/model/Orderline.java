package com.qa.connecting.model;

public class Orderline {
	
	private int fk_order_id;
	private int fk_item_id;
	private int qty_ordered;
	private String status;
	
	
	public Orderline(int fk_order_id, int fk_item_id, int qty_ordered, String status) {
		this.fk_order_id=fk_order_id;
		this.fk_item_id=fk_item_id;
		this.qty_ordered=qty_ordered;
		this.status=status;
	}
	
	
	
	
	public int getFk_order_id() {
		return fk_order_id;
	}
	public void setFk_order_id(int fk_order_id) {
		this.fk_order_id = fk_order_id;
	}
	public int getFk_item_id() {
		return fk_item_id;
	}
	public void setFk_item_id(int fk_item_id) {
		this.fk_item_id = fk_item_id;
	}
	public int getQty_ordered() {
		return qty_ordered;
	}
	public void setQty_ordered(int qty_ordered) {
		this.qty_ordered = qty_ordered;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
