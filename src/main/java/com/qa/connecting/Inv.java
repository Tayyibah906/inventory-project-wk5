package com.qa.connecting;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.qa.connecting.doa.CustomerDao;
import com.qa.connecting.doa.DatabaseConnection;
import com.qa.connecting.model.Customer;
import com.qa.connecting.utils.Input;

public class Inv {

	public static final Logger LOGGER = Logger.getLogger(Inv.class);
	
	Input input = new Input();

	public void start() throws SQLException {

		System.out.println("Database username: ");
		String user = input.getInput();
		System.out.println("Database password: ");
		String password = input.getInput();

		DatabaseConnection connection = new DatabaseConnection(user, password);
		
		

		// Below needs to be similar to Garage project
		// where different type of objects can be built and different inputs are
		// required
		// --------------------------

		System.out.println("What would you like to do? Choose from the following:");
		for (Action action : Action.values()) {
			System.out.println(action.name());
		}
		System.out.println("-----");

		Action selectedAction;
		while (true) {
			try {
				String actionInput = input.getInput();
				selectedAction = Action.valueOf(actionInput.toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.warn("Not a valid option. Please re-enter");
			}
		}

		System.out.println(selectedAction);

		switch (selectedAction) {
		case INSERT:
			System.out.println("customer name:");
			String name = input.getInput();

			System.out.println("customer address:");
			String address = input.getInput();

			System.out.println("customer phone number:");
			String phone_number = input.getInput();

			System.out.println("customer email:");
			String email = input.getInput();
			
			System.out.println("customer age");
			int age= input.getInput();

			Customer customer = new Customer(name, address, phone_number, email, age);
			// ----------------------------

			// With the object send it to the Dao and have it do the rest
			CustomerDao customerDao = new CustomerDao(connection);
			//
			customerDao.insertCustomer(customer);

			break;
		case READ:
//			("create a scope for this");
			break;
		case UPDATE:
//			("create a scope for this");
			break;
		case DELETE:
//			("create a scope for this");
			break;
		default:
			System.out.println("Please choose from the options above.");
			break;

		}

		// DONT FORGET TO CLOSE OFF CONNECTIONS
		connection.closeConnection();
	}
}