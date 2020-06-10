package com.qa.connecting.doa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qa.connecting.model.Customer;

public class CustomerDao{

	private DatabaseConnection databaseConnection;

	public CustomerDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public List<Customer> readAllCustomers() throws SQLException {
		String sql = "SELECT * FROM customer";
		ResultSet resultSet = databaseConnection.sendQuery(sql);
		ArrayList<Customer> customers = new ArrayList<>();
		while(resultSet.next()) {
			Customer customer = new Customer();
			customer.setCustomerId(resultSet.getInt("customer_id"));
			customer.setName(resultSet.getString("name"));
			customer.setAddress(resultSet.getString("address"));
			customer.setPhoneNumber(resultSet.getString("address"));
			customer.setEmail(resultSet.getString("email"));
			customer.setAge(resultSet.getInt("age"));
			
			customers.add(customer);
		}
		
		return customers;
	}

	public void insertCustomer(Customer customer) throws SQLException {
		String sql = "INSERT INTO customer(name, address, phone_number, email, age) values ('" + customer.getName()
				+ "', '" + customer.getAddress() + "', '" + customer.getPhoneNumber() + "', '" + customer.getEmail()
				+ "', '" + customer.getAge() + "');";
			databaseConnection.sendUpdate(sql);
	}

	public void updateCustomer(Customer customer) throws SQLException {
		String sql = "Update customer set name='" +customer.getName()+ "', address='"+ customer.getAddress() + 
				"',phone_number='"+ customer.getPhoneNumber() + "',email='"+ customer.getEmail()+ "', age='" + customer.getAge() 
				+ "'"+ "'WHERE customer_id ='" +customer.getCustomerId()+"';";

		
			databaseConnection.sendUpdate(sql);
		
	}
	

	public void deleteCustomer(int customerId) throws SQLException {
		String sql = "Delete from customer WHERE customer_id= '" + customerId + "';";

		databaseConnection.sendUpdate(sql);
	
		
		
	}

	

}