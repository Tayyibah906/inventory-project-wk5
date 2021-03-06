package com.qa.connecting.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	private Customer customer;

	@Before
	public void setUp() throws Exception {
		customer = new Customer("Mocha", "34 Brown street", "0795823456", "Mocha@roasted.com", 90);
		customer.setCustomerId(23);
	}

	@Test
	public void settersTest() {


		customer.setCustomerId(20);
		assertEquals(20, customer.getCustomerId());
		customer.setName("mark");
		assertEquals("mark", customer.getName());
		customer.setAddress("43 rose avenue");;
		assertEquals("43 rose avenue",customer.getAddress());
		customer.setPhoneNumber("0798543");
		assertEquals("0798543", customer.getPhoneNumber());
		customer.setEmail("mark@mopbox.com");
		assertEquals("mark@mopbox.com", customer.getEmail());
		customer.setAge(220);
		assertEquals(220, customer.getAge());
	}


	@Test
	public  void testCustomer() {
		assertEquals("Mocha", customer.getName());
		assertEquals("34 Brown street", customer.getAddress());
		assertEquals("0795823456", customer.getPhoneNumber());
		assertEquals("Mocha@roasted.com", customer.getEmail());
		assertEquals(90, customer.getAge(), 0);
	}
	
	@Test
	public  void testCustomerWithId() {
		customer = new Customer(1, "Latte", "24 coffee grounds", "07643256723", "beans@cups.com", 10);
		assertEquals(1, customer.getCustomerId(), 0);
		assertEquals("Latte", customer.getName());
		assertEquals("24 coffee grounds", customer.getAddress());
		assertEquals("07643256723", customer.getPhoneNumber());
		assertEquals("beans@cups.com", customer.getEmail());
		assertEquals(10, customer.getAge(), 0);

	}

}
