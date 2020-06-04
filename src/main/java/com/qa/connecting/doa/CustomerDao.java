package com.qa.connecting.doa;

import java.sql.SQLException;

import com.qa.connecting.model.Customer;

public class CustomerDao {

	private DatabaseConnection databaseConnection;

	public CustomerDao(DatabaseConnection databaseConnection) throws SQLException {
		this.databaseConnection = databaseConnection;
	}

	public void insertCustomer(Customer customer) throws SQLException {
		String sql = "insert into customer(name, adresss, phone_number, email, age) values ('"
				+ customer.getName() + "', '" + customer.getAddress() + "', '" + customer.getPhone_number()
				+ "', '" + customer.getEmail() + "', '" + customer.getAge() + "');";

		databaseConnection.sendUpdate(sql);
	}
}