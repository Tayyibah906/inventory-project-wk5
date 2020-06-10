package com.qa.connecting.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.connecting.doa.OrderDao;
import com.qa.connecting.model.Order;

public class OrderService {

	public static final Logger LOGGER = Logger.getLogger(OrderService.class);

	private OrderDao orderDao;

	public OrderService(OrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}

	public void insertOrder(Order orders) {
		try {
			orderDao.insertOrder(orders);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}

	public void readOrders() {
		List<Order> orders = null;
		{
			try {
				orders = orderDao.readAllOrders();
			} catch (SQLException e) {
				LOGGER.error(e.getMessage());
				for (StackTraceElement element : e.getStackTrace()) {
					LOGGER.debug(element);
				}
			}

			for (Order order : orders) {
				LOGGER.info(order);
			}
		}
	}

	public void updateOrder(Order order) {
		try {
			orderDao.updateOrder(order);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}

	public void deleteOrder(int orderId) {
		try {
			orderDao.deleteOrder(orderId);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}
}
