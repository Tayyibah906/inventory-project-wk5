package com.qa.connecting.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.connecting.doa.CustomerDao;
import com.qa.connecting.model.Customer;

public class CustomerService {

	public static final Logger LOGGER = Logger.getLogger(CustomerService.class);

	private CustomerDao customerDao;

	public CustomerService(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	public void insertCustomer(Customer customer) {
		try {
			customerDao.insertCustomer(customer);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}

	public void readCustomer() {
		List<Customer> customers = null;
		try {
			customers = customerDao.readAllCustomers();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}

		for (Customer customer : customers) {
			LOGGER.info(customer);
		}
	}

	public void updateCustomer(Customer customer) {
		try {
			customerDao.updateCustomer(customer);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}

	public void deleteCustomer(int customerId) {
		try {
			customerDao.deleteCustomer(customerId);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}
}
