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

import com.qa.connecting.model.Order;

public class OrderDaoTest {

	static DatabaseConnection databaseConnection;
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
		sendToDB(DriverManager.getConnection("jdbc:mysql://35.226.67.80/testDB:3306", "root", "Carpet29"),CLEAR_LOCATION);
	}
	
	@AfterClass
	public static void finish() throws SQLException {
		sendToDB(DriverManager.getConnection("jdbc:mysql://35.226.67.80:3306", "root", "Carpet29"), DROP_LOCATION);
		databaseConnection.closeConnection();
	}
	
	
//	Insert into orders(fk_customer_id) values(3);
//	Insert into orders(fk_customer_id) values(2);
//	Insert into orders(fk_customer_id) values(5);
//	Insert into orders(fk_customer_id) values(6);
//	Insert into orders(fk_customer_id) values(4);
//	Insert into orders(fk_customer_id) values(7);
//	Insert into orders(fk_customer_id) values(1);
	
	@Test
	public void testReadAllOrders() throws SQLException {
		OrderDao orderdao = new OrderDao(databaseConnection);
		Order readTest = new Order(3);
		orderdao.insertOrder(readTest);

		String query = "SELECT * FROM orders";
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery(query);
		int count = 0;
		while (rs.next()) {
			count++;
		}

		assertEquals(7, count);
	}

	@Test
	public void testInsertCustomer() throws SQLException {
		OrderDao orderdao = new OrderDao(databaseConnection);
		Order insertTest = new Order(3);
		orderdao.insertOrder(insertTest);

		String query = "SELECT * FROM orders";
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery(query);
		int count = 0;
		while (rs.next()) {
			count++;
		}

		assertEquals(7, count);
	}

	@Test
	public void testUpdateCustomer() throws SQLException {
		OrderDao orderdao = new OrderDao(databaseConnection);
		Order updateTest = new Order(5);
		orderdao.insertOrder(updateTest);


		assertEquals(5, updateTest.getFkCustomerId());
	}

	@Test
	public final void testDeleteCustomer() throws SQLException {
		OrderDao orderdao = new OrderDao(databaseConnection);
		Order deleteTest = new Order(5);
		orderdao.insertOrder(deleteTest);

		String query = "SELECT * FROM orders";
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery(query);
		int count = 0;
		while (rs.next()) {
			count++;
		}

		assertEquals(8, count);
	}


}
