package com.qa.connecting.dao;

import static org.junit.Assert.assertEquals;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.connecting.Utils.DBConstants;
import com.qa.connecting.Utils.TestUtils;
import com.qa.connecting.model.Order;

public class OrderDaoTest {

	private static TestingDatabaseConnection databaseConnection;

	private static OrderDao orderdao;

	@BeforeClass
	public static void intialise() throws SQLException {
		orderdao = new OrderDao(databaseConnection);

	}

	@Before
	public void setup() throws SQLException {
		TestUtils.sendToDB(DriverManager.getConnection(DBConstants.URL, DBConstants.USER, DBConstants.PASSWORD),
				TestUtils.SCHEMA_LOCATION);
		databaseConnection = new TestingDatabaseConnection(DBConstants.USER, DBConstants.PASSWORD);
		TestUtils.sendToDB(databaseConnection.getConnection(), TestUtils.DATA_LOCATION);
		orderdao = new OrderDao(databaseConnection);
	}

	@After
	public void teardown() throws SQLException {
		TestUtils.sendToDB(DriverManager.getConnection(DBConstants.URL + DBConstants.DB_NAME + DBConstants.DB_OPTIONS,
				DBConstants.USER, DBConstants.PASSWORD), TestUtils.CLEAR_LOCATION);
		TestUtils.sendToDB(DriverManager.getConnection(DBConstants.URL, DBConstants.USER, DBConstants.PASSWORD),
				TestUtils.DROP_LOCATION);
	}

	@AfterClass
	public static void finish() throws SQLException {
		databaseConnection.closeConnection();
	}

	@Test
	public final void testReadAllOrders() throws SQLException {
		assertEquals(getCount(), orderdao.readAllOrders().size());
	}

	@Test
	public final void testInsertOrder() throws SQLException {
<<<<<<< HEAD
		Order insertTest = new Order(3,2);
		orderdao.insertOrder(insertTest);
=======
		final int count = getCount();
>>>>>>> d3c3406f62e6ecc4bad5244468f81324f27b56cd

		Order insertTest = new Order(3, 1);
		orderdao.insertOrder(insertTest);

		assertEquals(count + 1, getCount());
	}

	@Test
<<<<<<< HEAD
	public  void testUpdateOrder() throws SQLException {
		Order order = new Order(2,4);
=======
	public final void testUpdateOrder() throws SQLException {

		Order order = new Order(2, 1);
>>>>>>> d3c3406f62e6ecc4bad5244468f81324f27b56cd
		orderdao.updateOrder(order);

		ResultSet resultSet = databaseConnection.getStatement()
				.executeQuery("SELECT fk_customer_id from orders where order_id = " + 2);
		resultSet.next();
		assertEquals(4, resultSet.getInt("fk_customer_id"));
	}

<<<<<<< HEAD
	@Test
	public  void testDeleteOrder() throws SQLException {
		OrderDao orderdao = new OrderDao(databaseConnection);
		Order deleteTest = new Order(1, 2);
		orderdao.insertOrder(deleteTest);

		String query = "SELECT * FROM orders";
=======
	private int getCount() throws SQLException {
>>>>>>> d3c3406f62e6ecc4bad5244468f81324f27b56cd
		Statement statement = databaseConnection.getStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM orders");
		int count = 0;
		while (rs.next()) {
			count++;
		}
		return count;
	}

	@Test
	public final void testDeleteOrder() throws SQLException {
		final int count = getCount();
		orderdao.deleteOrder(count);

		assertEquals(count - 1, getCount());
	}

}
