package com.qa.connecting.dao;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.connecting.model.Items;

public class ItemsDaoTest {

	static TestingDatabaseConnection databaseConnection;
	static final String SCHEMA_LOCATION = "src\\test\\resources\\Schema.sql";
	static final String DATA_LOCATION = "src\\test\\resources\\Data.sql";
	static final String CLEAR_LOCATION = "src\\test\\resources\\ClearDB.sql";
	static final String DROP_LOCATION = "src\\test\\resources\\DropDB.sql";

	private static void sendToDB(Connection connection, String fileLocation) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
			String string;
			while ((string = br.readLine()) != null) {
				try (Statement statement = connection.createStatement();) {
					statement.executeUpdate(string);
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public static void intialise() throws SQLException {
		sendToDB(DriverManager.getConnection("jdbc:mysql://35.226.67.80:3306", "root", "Carpet29"), SCHEMA_LOCATION);
	}

	@Before
	public void setup() throws SQLException {
		databaseConnection = new TestingDatabaseConnection("root", "Carpet29");
		sendToDB(databaseConnection.getConnection(), DATA_LOCATION);
	}

	@After
	public void teardown() throws SQLException {
		sendToDB(DriverManager.getConnection("jdbc:mysql://35.226.67.80:3306/testDB", "root", "Carpet29"),
				CLEAR_LOCATION);
	}

	@AfterClass
	public static void finish() throws SQLException {
		sendToDB(DriverManager.getConnection("jdbc:mysql://35.226.67.80:3306", "root", "Carpet29"), DROP_LOCATION);
		databaseConnection.closeConnection();
	}

	@Test
	public final void testReadAllCustomers() throws SQLException {
		ItemsDao itemsdao = new ItemsDao(databaseConnection);
		Items readTest = new Items(2, "The Wind in the Willows", 90, 9.99);
		itemsdao.insertItems(readTest);

		String query = "SELECT * FROM items";
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery(query);
		int count = 0;
		while (rs.next()) {
			count++;
		}

		assertEquals(7, count);
	}

	@Test
	public final void testInsertCustomer() throws SQLException {
		ItemsDao itemsdao = new ItemsDao(databaseConnection);
		Items insertTest = new Items("Pan returns", 13, 9.50);
		itemsdao.insertItems(insertTest);

		String query = "SELECT * FROM items";
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery(query);
		int count = 0;
		while (rs.next()) {
			count++;
		}
		assertEquals(8, count);

	}

	@Test
	public final void testUpdateCustomer() throws SQLException {
		ItemsDao itemsdao = new ItemsDao(databaseConnection);
		Items updateTest = new Items(2, "The Wind", 99, 1.99);
		itemsdao.insertItems(updateTest);

		assertEquals(2, updateTest.getItemId());
		assertEquals("The Wind", updateTest.getItemName());
		assertEquals(99, updateTest.getQuantity());
		assertEquals(1.99, updateTest.getPrice(), 0);

	}

	@Test
	public final void testDeleteCustomer() throws SQLException {
		ItemsDao itemsdao = new ItemsDao(databaseConnection);
		Items deleteTest = new Items(1, "The Great Gatsby", 200, 29.99);
		itemsdao.insertItems(deleteTest);

		String query = "SELECT * FROM items";
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery(query);
		int count = 0;
		while (rs.next()) {
			count++;
		}
		assertEquals(9, count);
	}

}
