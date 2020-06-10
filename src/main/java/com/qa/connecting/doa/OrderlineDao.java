package com.qa.connecting.doa;

import java.sql.SQLException;

import com.qa.connecting.model.Orderline;

public class OrderlineDao {

	private DatabaseConnection databaseConnection;

	public OrderlineDao(DatabaseConnection databaseConnection) throws SQLException {
		this.databaseConnection = databaseConnection;
	}

	public void insertOrderline(Orderline orderline) throws SQLException {
		String sql = "insert into orderline(fk_order_id, fk_item_id, qty_ordered, status) values ('"
				+ orderline.getFk_order_id() + "', '" + orderline.getFk_item_id() + "', '" + orderline.getQty_ordered()
				+ "', '" + orderline.getStatus() + "');";

		databaseConnection.sendUpdate(sql);
	}
	
	
	public void selectOrderline(Orderline orderline) {
		String sql = "SELECT * FROM orderline";

		try {
			databaseConnection.sendQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Instruction not executed");
		}
	}
	

	public void UpdateOrderline(Orderline orderline) {
		String sql = "Update into orderline(fk_order_id, fk_item_id, qty_ordered, status) values ('"
				+ orderline.getFk_order_id() + "', '" + orderline.getFk_item_id() + "', '" + orderline.getQty_ordered()
				+ "', '" + orderline.getStatus() + "');";

		try {
			databaseConnection.sendUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Instruction not executed");
		}
	}
	
	public void DeleteOrderline(Orderline orderline) {
		String sql = "Delete from orderline WHERE fk_order_id= '" +orderline.getOrderline_id() +"');";
		 
		try {
			databaseConnection.sendUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Instruction not executed");
		}
	}

}
