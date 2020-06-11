package com.qa.connecting.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.qa.connecting.exceptions.ConnectionNotMadeException;

public class RemoteDatabaseConnection extends DatabaseConnection {


	public RemoteDatabaseConnection(String user, String password) throws SQLException {
		super(user, password);
	}
	
	public void openConnection() {
		try {
			setConnection(DriverManager.getConnection("jdbc:mysql://35.226.67.80:3306/inventoryDB", getUser(), getPassword()));;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ConnectionNotMadeException("Remote database is not accessible: " + e.getMessage());

		}		
	}

}
