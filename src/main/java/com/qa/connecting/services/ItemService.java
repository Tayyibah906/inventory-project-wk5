package com.qa.connecting.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.connecting.dao.ItemsDao;
import com.qa.connecting.model.Items;

public class ItemService {

	public static final Logger LOGGER = Logger.getLogger(ItemService.class);

	private ItemsDao itemsDao;

	public ItemService(ItemsDao itemsDao) {
		super();
		this.itemsDao = itemsDao;
	}

	public void insertItem(Items item) {
		try {
			itemsDao.insertItems(item);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}

	public void readItem() {
		List<Items> items = null;
		try {
			items = itemsDao.readAllItems();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
		for (Items item : items) {
			LOGGER.info(item);
		}
	}

	public void updateItems(Items items) {
		try {
			itemsDao.updateItems(items);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}

	public void deleteItems(int itemId) {
		try {
			itemsDao.deleteItems(itemId);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}

		}
	}
}
