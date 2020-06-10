package com.qa.connecting.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {
	
		
	Order order = new Order(10,1);
	Order order2 = new Order(8);

	@Test
	
	public final void testOrderWithId() {
		assertEquals(10, order.getOrderId(), 0);
		assertEquals(1, order.getFkCustomerId(), 0);
	}

	@Test
	public final void testOrder() {
		assertEquals(8, order2.getOrderId(), 0);
	}

}
