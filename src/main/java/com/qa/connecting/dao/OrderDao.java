package com.qa.connecting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.connecting.model.Order;


public class OrderDao {

	private DatabaseConnection databaseConnection;

	public OrderDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertOrder(Order order) throws SQLException {
		String sql = "INSERT INTO orders(fk_customer_id) values ("
				+ order.getFkCustomerId() + ");";

		databaseConnection.sendUpdate(sql);
	}

	public List<Order> readAllOrders() throws SQLException {
		String sql = "SELECT * FROM orders";
		Statement statement = databaseConnection.getStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		ArrayList<Order> orders = new ArrayList<>();
		while(resultSet.next()) {
			Order order = new Order();
			order.setOrderId(resultSet.getInt("order_id"));
			order.setFkCustomerId(resultSet.getInt("fk_customer_id"));
			orders.add(order);
		}
		statement.close();
		resultSet.close();
		
		return orders;
	}


	public void updateOrder(Order order) throws SQLException {
		String sql = "UPDATE orders SET fk_customer_id=" 
				+ order.getFkCustomerId() +  " WHERE order_id =" +order.getOrderId()+";";

			databaseConnection.sendUpdate(sql);
	}
	
	

	public void deleteOrder(int orderId) throws SQLException {
		String sql = "Delete from orders WHERE order_id= " + orderId + ";";

			databaseConnection.sendUpdate(sql);
	}
}
