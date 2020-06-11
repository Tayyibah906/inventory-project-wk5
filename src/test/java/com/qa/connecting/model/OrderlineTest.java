package com.qa.connecting.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderlineTest {

	Orderline orderline = new Orderline(10, 20, 30);

	@Test
	public final void testOrderline() {
		assertEquals(10, orderline.getFk_order_id());
		assertEquals(20, orderline.getFk_item_id());
		assertEquals(30, orderline.getQty_ordered());
	}

}
