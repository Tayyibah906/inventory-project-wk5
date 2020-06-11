package com.qa.connecting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.connecting.model.Items;

public class ItemsDao {

	private DatabaseConnection databaseConnection;

	public ItemsDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertItems(Items items) throws SQLException {
		String sql = "insert into items(item, quantity, price) values ('"
				+ items.getItemName() + "', "
				+ items.getQuantity() + ", " 
				+ items.getPrice() + ");";

		databaseConnection.sendUpdate(sql);

	}

	public List<Items> readAllItems() throws SQLException {
		String sql = "SELECT * FROM items";
		Statement statement = databaseConnection.getStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		ArrayList<Items> Items = new ArrayList<>();
		while (resultSet.next()) {
			Items item = new Items();
				item.setItemId(resultSet.getInt("item_id"));
				item.setItemName(resultSet.getString("item"));
				item.setQuantity(resultSet.getInt("quantity"));
				item.setPrice(resultSet.getDouble("price"));

				Items.add(item);
			}
			statement.close();
			resultSet.close();
			
		return Items;
	}

	public void updateItems(Items items) throws SQLException {
		String sql = "Update  items set item='" + items.getItemName() + "', quantity="+ items.getQuantity() +	", price=" + items.getPrice() 
		+" WHERE item_id =" +items.getItemId()+";";
		
		databaseConnection.sendUpdate(sql);
	}

	public void deleteItems(int itemId) throws SQLException {
		String sql = "Delete from items WHERE item_id= '" + itemId + "';";

			databaseConnection.sendUpdate(sql);
		
	}
}
