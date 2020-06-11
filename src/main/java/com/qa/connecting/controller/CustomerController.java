package com.qa.connecting.controller;

import org.apache.log4j.Logger;

import com.qa.connecting.model.Customer;
import com.qa.connecting.services.CustomerService;
import com.qa.connecting.utils.Input;

public class CustomerController {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private Input input;
	private CustomerService customerService;

	public CustomerController(Input input, CustomerService customerService) {
		super();
		this.input = input;
		this.customerService = customerService;
	}

	public void run(Action selectedAction) {
		switch (selectedAction) {

		case INSERT:
			insert();
			LOGGER.info("Would you like to add another customer?");
			// input
			// check input is Y or N
			// loop until answer is Y or N

			// If yes begin loop of asking all over again
			break;
		case READ:
			readAllCustomers();
			break;
		case UPDATE:
			updateCustomer();
			break;
		case DELETE:
			deleteCustomer();
			break;
		case RETURN:
			break;
		default:
			LOGGER.info("Invalid selection, Please choose from the options above.");
			break;

		}
	}

	protected void insert() {
		LOGGER.info("Name: ");
		String name = input.getInput();

		LOGGER.info("address:");
		String address = input.getInput();

		LOGGER.info("phone_number");
		String phoneNumber = input.getInput();

		LOGGER.info("email");
		String email = input.getInput();

		LOGGER.info("age");
		int age = input.getInt();

		Customer customer = new Customer(name, address, phoneNumber, email, age);
		customerService.insertCustomer(customer);
		LOGGER.info("Customer added!");

	}

	protected void readAllCustomers() {
		customerService.readCustomer();
	}

	protected void updateCustomer() {
		LOGGER.info("enter the Customer id you would like to update: ");
		int customerId = input.getInt();

		LOGGER.info("Name: ");
		String name = input.getInput();

		LOGGER.info("address:");
		String address = input.getInput();

		LOGGER.info("phone_number");
		String phoneNumber = input.getInput();

		LOGGER.info("email");
		String email = input.getInput();

		LOGGER.info("age");
		int age = input.getInt();
		Customer customer = new Customer(customerId, name, address, phoneNumber, email, age);
		customerService.updateCustomer(customer);
		LOGGER.info("Customer updated!");

	}

	protected void deleteCustomer() {
		LOGGER.info("enter the Customer id you would like to delete: ");
		int customerId = input.getInt();
		customerService.deleteCustomer(customerId);
		LOGGER.info("Customer deleted!");

	}

}
