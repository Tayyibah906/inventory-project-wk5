package com.qa.connecting.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection  {

	private String user;
	private String password;
	private Connection connection;

	public DatabaseConnection(String user, String password) throws SQLException {
		this.user = user;
		this.password = password;
		openConnection();
	}

	private void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://35.226.67.80:3306/inventoryDB", user, password);
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}

	public ResultSet sendQuery(String sql) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		statement.close();
		return resultSet;
	}

	public void sendUpdate(String sql) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
