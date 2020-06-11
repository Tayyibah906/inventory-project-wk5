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

import com.qa.connecting.model.Customer;

public class CustomerDaoTest {

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
		databaseConnection = new TestingDatabaseConnection("root","Carpet29");
		sendToDB(databaseConnection.getConnection(), DATA_LOCATION);
	}
	
	@After
	public void teardown() throws SQLException {
		sendToDB(DriverManager.getConnection("jdbc:mysql://35.226.67.80:3306/testDB", "root", "Carpet29"),CLEAR_LOCATION);
	}
	
	@AfterClass
	public static void finish() throws SQLException {
		sendToDB(DriverManager.getConnection("jdbc:mysql://35.226.67.80:3306", "root", "Carpet29"), DROP_LOCATION);
		databaseConnection.closeConnection();
	}
	
	
	@Test
	public final void testReadAllCustomers() throws SQLException {
		CustomerDao customerdao = new CustomerDao(databaseConnection);
		Customer readTest = new Customer(1,"Simon", "64 Zoo Lane", "0789236789", "kin@inbox.com", 20);
		customerdao.insertCustomer(readTest);

		String query = "SELECT * FROM customer";
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery(query);
		int count = 0;
		while (rs.next()) {
			count++;
		}

		assertEquals(9, count);
	}

	@Test
	public final void testInsertCustomer() throws SQLException {
		CustomerDao customerdao = new CustomerDao(databaseConnection);
		Customer insertTest = new Customer(0, "Brian", "45 zoomer street", "07987646", "brian@brains.com", 46);
		customerdao.insertCustomer(insertTest);

		String query = "SELECT * FROM customer";
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery(query);
		int count = 0;
		while (rs.next()) {
			count++;
		}
		assertEquals(14, count);

	}

	@Test
	public final void testUpdateCustomer() throws SQLException {
		CustomerDao customerdao = new CustomerDao(databaseConnection);
		Customer updateTest = new Customer(1, "Tiffany", "5 moon street", "079646", "tiff@brains.com", 23);
		customerdao.updateCustomer(updateTest);

		assertEquals(1, updateTest.getCustomerId());
		assertEquals("Tiffany", updateTest.getName());
		assertEquals("5 moon street", updateTest.getAddress());
		assertEquals("079646", updateTest.getPhoneNumber());
		assertEquals("tiff@brains.com", updateTest.getEmail());
		assertEquals(23, updateTest.getAge());
	}

	@Test
	public final void testDeleteCustomer() throws SQLException {
		CustomerDao customerdao = new CustomerDao(databaseConnection);
		Customer deleteTest = new Customer(0, "Brian", "45 zoomer street", "07987646", "brian@brains.com", 46);
		customerdao.insertCustomer(deleteTest);

		String query = "SELECT * FROM customer";
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery(query);
		int count = 0;
		while (rs.next()) {
			count++;
		}
		assertEquals(19, count);
	}

}
