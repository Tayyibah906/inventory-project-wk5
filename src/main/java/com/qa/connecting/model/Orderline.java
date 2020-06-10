package com.qa.connecting.model;

public class Orderline {

	private int orderline_id;
	private int fk_order_id;
	private int fk_item_id;
	private int qty_ordered;

	public Orderline() {
	}

	public Orderline(int fk_order_id, int fk_item_id, int qty_ordered) {
		this.fk_order_id = fk_order_id;
		this.fk_item_id = fk_item_id;
		this.qty_ordered = qty_ordered;

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

	public int getOrderline_id() {
		return orderline_id;
	}

	public void setOrderline_id(int orderline_id) {
		this.orderline_id = orderline_id;
	}
}
