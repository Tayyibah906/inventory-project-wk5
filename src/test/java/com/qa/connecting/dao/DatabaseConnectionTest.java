//package com.qa.connecting.dao;
//
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import com.qa.connecting.doa.DatabaseConnection;
//
//public class DatabaseConnectionTest extends DatabaseConnection {
//
//	public DatabaseConnectionTest(String user, String password) throws SQLException {
//		super(user, password);
//	}
//
//	public void openConnection() throws SQLException {
//		setConnection(
//				DriverManager.getConnection("jdbc:mysql://35.192.193.230:3306/testdb", getUser(), getPassword()));
//	}
//
//}
