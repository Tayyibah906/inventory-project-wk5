package com.qa.connecting.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	private Customer customer;

	@Before
	public void setUp() throws Exception {
		customer = new Customer("Mocha", "34 Brown street", "0795823456", "Mocha@roasted.com", 90);
		
	}

	@Test
	public void settersTest() {
		assertNotNull(customer.getCustomerId());
		assertNotNull(customer.getName());
		assertNotNull(customer.getAddress());
		assertNotNull(customer.getPhoneNumber());
		assertNotNull(customer.getEmail());
		assertNotNull(customer.getAge());

		customer.setCustomerId(0);
		assertNotNull(customer.getCustomerId());
		customer.setName(null);
		assertNotNull(customer.getName());
		customer.setAddress(null);
		assertNotNull(customer.getAddress());
		customer.setPhoneNumber(null);
		assertNotNull(customer.getPhoneNumber());
		customer.setEmail(null);
		assertNotNull(customer.getEmail());
		customer.setAge(0);
		assertNotNull(customer.getAge());
	}


	@Test
	public final void testCustomer() {
		assertEquals("Mocha", customer.getName());
		assertEquals("34 Brown street", customer.getAddress());
		assertEquals("0795823456", customer.getPhoneNumber());
		assertEquals("Mocha@roasted.com", customer.getEmail());
		assertEquals(90, customer.getAge(), 0);
	}
	
	@Test
	public final void testCustomerWithId() {
		customer = new Customer(1, "Latte", "24 coffee grounds", "07643256723", "beans@cups.com", 10);
		assertEquals(1, customer.getCustomerId(), 0);
		assertEquals("Latte", customer.getName());
		assertEquals("24 coffee grounds", customer.getAddress());
		assertEquals("07643256723", customer.getPhoneNumber());
		assertEquals("beans@cups.com", customer.getEmail());
		assertEquals(10, customer.getAge(), 0);

	}

}
