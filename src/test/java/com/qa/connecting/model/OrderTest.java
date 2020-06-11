package com.qa.connecting.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private Order order ;
	private Order order2;
	
	@Before
	public void setup() {
		order = new Order(10, 1);
		order2 = new Order(8);
	}

	@Test
	public void testOrderWithId() {
		assertEquals(10, order.getOrderId());
		assertEquals(1, order.getFkCustomerId());
	}

	@Test
	public void testOrder() {
		assertEquals(8, order2.getOrderId());
	}

}
