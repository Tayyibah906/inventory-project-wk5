package com.qa.connecting.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemsTest {

	private Items items;

	@Before
	public void setUp() throws Exception {
		items = new Items("SupermanComic", 200, 3);
	}

	@Test
	public final void testItems() {
		assertEquals("SupermanComic", items.getItemName());
		assertEquals(200, items.getQuantity(), 0);
		assertEquals(3, items.getPrice(), 0);
	}

	@Test
	public final void testItemsWithId() {
		items = new Items("BatmanComic", 20, 5);
		assertEquals("BatmanComic", items.getItemName());
		assertEquals(20, items.getQuantity(), 0);
		assertEquals(5, items.getPrice(), 0);
	}

}
