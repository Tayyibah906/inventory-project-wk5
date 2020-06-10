package com.qa.connecting.doa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qa.connecting.model.Order;


public class OrderDao {

	private DatabaseConnection databaseConnection;

	public OrderDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertOrder(Order order) throws SQLException {
		String sql = "INSERT INTO orders(fk_customer_id, total, item_description) values ('"
				+ order.getFkCustomerId() + "');";

		databaseConnection.sendUpdate(sql);
	}

	public List<Order> readAllOrders() throws SQLException {
		String sql = "SELECT * FROM orders";
		ResultSet resultSet = databaseConnection.sendQuery(sql);
		ArrayList<Order> orders = new ArrayList<>();
		while(resultSet.next()) {
			Order order = new Order();
			order.setOrderId(resultSet.getInt("order_id"));
			order.setFkCustomerId(resultSet.getInt("fk_customer_id"));
			orders.add(order);
		}
		
		return orders;
	}


	public void updateOrder(Order order) throws SQLException {
		String sql = "Update into orders(fk_customer_id) values ('"
				+ order.getFkCustomerId() + "');";

			databaseConnection.sendUpdate(sql);
	}
	
	

	public void deleteOrder(int orderId) throws SQLException {
		String sql = "Delete from orders WHERE orders_id= '" + orderId + "');";

			databaseConnection.sendUpdate(sql);
	}
}
