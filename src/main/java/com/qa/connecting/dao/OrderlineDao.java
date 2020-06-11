package com.qa.connecting.dao;

//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;

import com.qa.connecting.model.Orderline;

public class OrderlineDao {

	private DatabaseConnection databaseConnection;

	public OrderlineDao(DatabaseConnection databaseConnection) throws SQLException {
		this.databaseConnection = databaseConnection;
	}

	public void insertOrderline(Orderline orderline) throws SQLException {
		String sql = "insert into orderline(fk_order_id, fk_item_id, qty_ordered,) values ('"
				+ orderline.getFk_order_id() + "', '" 
				+ orderline.getFk_item_id() + "', '" 
				+ orderline.getQty_ordered()+"');";

		databaseConnection.sendUpdate(sql);
	}
	
	
//	public void List<Orderline> readAllorderlines() throws SQLException {
//		String sql = "SELECT * FROM orderline";
//		Statement statement = databaseConnection.getStatement();
//		ResultSet resultSet = statement.executeQuery(sql);
//		ArrayList<Orderline> orderline = new ArrayList<>();
//		while(resultSet.next()) {
//			Orderline orderline = new orderline();
//			orderline.
//			
//			
//			Orderline.add(orderline);
//		}
//		
//		statement.close();
//		resultSet.close();
//		return orderline;
//	}
//	

	public void UpdateOrderline(Orderline orderline) {
		String sql = "Update into orderline(fk_order_id, fk_item_id, qty_ordered) values ('"
				+ orderline.getFk_order_id() + "', '" + orderline.getFk_item_id() + "', '" + orderline.getQty_ordered()
				+ "', '" + "');";

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
