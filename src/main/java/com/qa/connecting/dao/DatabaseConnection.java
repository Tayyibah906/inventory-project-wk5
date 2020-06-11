package com.qa.connecting.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DatabaseConnection  {

	private String user;
	private String password;
	private Connection connection;

	public DatabaseConnection(String user, String password) throws SQLException {
		this.user = user;
		this.password = password;
		openConnection();
	}

	public abstract void openConnection();
	
	public void closeConnection() throws SQLException {
		connection.close();
	}

	public Statement getStatement() throws SQLException {
		Statement statement = connection.createStatement();
		return statement;
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
