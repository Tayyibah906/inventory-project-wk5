package com.qa.connecting.controller;

import org.apache.log4j.Logger;

import com.qa.connecting.model.Order;
import com.qa.connecting.services.OrderService;
import com.qa.connecting.utils.Input;

public class OrderController {
	
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private Input input;
	private OrderService orderService;

	public OrderController(Input input, OrderService orderService) {
		super();
		this.input = input;
		this.orderService = orderService;
	}

	public void run(Action selectedAction) {
		switch (selectedAction) {

		case INSERT:
			insert();
			LOGGER.info("Would you like to add another order?");
			// input
			// check input is Y or N
			// loop until answer is Y or N
			
			// If yes begin loop of asking all over again
			break;
		case READ:
//			orderDao.readAllOrders();
			break;
		case UPDATE:
//			orderDao.updateOrders();
			break;
		case DELETE:
//			orderDao.deleteOrders();
			break;
		case RETURN:
			break;
		default:
			LOGGER.info("Invalid selection, Please choose from the options above.");
			break;

		}
	}

	protected void insert() {
		int fkCustomerId = input.getInt();
	
		Order order = new Order(fkCustomerId);
		orderService.insertOrder(order);
	}


}
