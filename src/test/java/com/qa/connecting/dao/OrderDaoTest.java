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

	static TestingDatabaseConnection databaseConnection;
	static final String SCHEMA_LOCATION = "src\\test\\resources\\Schema.sql";
	static final String DATA_LOCATION = "src\\test\\resources\\Data.sql";
	static final String CLEAR_LOCATION = "src\\test\\resources\\ClearDB.sql";
	static final String DROP_LOCATION = "src\\test\\resources\\DropDB.sql";

	private OrderDao orderdao;
	
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
		orderdao = new OrderDao(databaseConnection);
	}

	@After
	public void teardown() throws SQLException {
		sendToDB(DriverManager.getConnection("jdbc:mysql://35.226.67.80:3306/testDB", "root", "Carpet29"),
				CLEAR_LOCATION);
		sendToDB(DriverManager.getConnection("jdbc:mysql://35.226.67.80:3306", "root", "Carpet29"), DROP_LOCATION);
	}

	@AfterClass
	public static void finish() throws SQLException {
		databaseConnection.closeConnection();
	}

	@Test
	public final void testReadAllOrders() throws SQLException {
		OrderDao orderdao = new OrderDao(databaseConnection);
		Order readTest = new Order(4, 2);
		orderdao.insertOrder(readTest);

		String query = "SELECT * FROM orders";
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery(query);
		int count = 0;
		while (rs.next()) {
			count++;
		}

		assertEquals(4, count);
	}

	@Test
	public final void testInsertOrder() throws SQLException {
		Order insertTest = new Order(3);
		orderdao.insertOrder(insertTest);

		String query = "SELECT * FROM orders";
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery(query);
		int count = 0;
		while (rs.next()) {
			count++;
		}

		assertEquals(5, count);
	}

	@Test
	public final void testUpdateOrder() throws SQLException {
		Order order = new Order(2,4);
		orderdao.updateOrder(order);

		ResultSet resultSet =databaseConnection.getStatement().executeQuery("SELECT fk_customer_id from orders where order_id = " + 2 );
		resultSet.next();
		assertEquals(4, resultSet.getInt("fk_customer_id"));
	}

	@Test
	public final void testDeleteOrder() throws SQLException {
		OrderDao orderdao = new OrderDao(databaseConnection);
		Order deleteTest = new Order(1);
		orderdao.insertOrder(deleteTest);

		String query = "SELECT * FROM orders";
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery(query);
		int count = 0;
		while (rs.next()) {
			count++;
		}

		assertEquals(5, count);
	}

}
