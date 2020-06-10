package com.qa.connecting.controller;

import org.apache.log4j.Logger;

import com.qa.connecting.model.Items;
import com.qa.connecting.services.ItemService;
import com.qa.connecting.utils.Input;

public class ItemController {
	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private Input input;
	private ItemService itemService;

	public ItemController(Input input, ItemService itemServices) {
		super();
		this.input = input;
		this.itemService=itemServices;
	}

	public void run(Action selectedAction) {
		switch (selectedAction) {

		case INSERT:
			insert();
			LOGGER.info("Would you like to add another item?");
			// input
			// check input is Y or N
			// loop until answer is Y or N

			// If yes begin loop of asking all over again
			break;
		case READ:
//			customerDao.readAllItems();
			break;
		case UPDATE:
//			customerDao.updateItems();
			break;
		case DELETE:
//			customerDao.deleteItems();
			break;
		case RETURN:
			break;
		default:
			LOGGER.info("Invalid selection, Please choose from the options above.");
			break;

		}
	}

	protected void insert() {
		LOGGER.info("item name");
		String itemName = input.getInput();

		LOGGER.info("item name");
		int quantity = input.getInt();

		LOGGER.info("item name");
		double price = input.getDouble();

		Items item = new Items(itemName, quantity, price);
		itemService.insertItem(item);
	}

	protected void readAllItems() {
		itemService.readItem();
	}

	protected void updateItems() {

		LOGGER.info("enter the Item id you would like to update: ");
		int itemId = input.getInt();

		LOGGER.info("item name: ");
		String itemName = input.getInput();

		LOGGER.info("item quantity: ");
		int quantity = input.getInt();

		LOGGER.info("item price: ");
		double price = input.getDouble();

		Items items = new Items(itemId, itemName, quantity, price);
		itemService.updateItems(items);
		;
	}

	protected void deleteItems() {
		LOGGER.info("enter the Item id you would like to delete: ");
		int itemId = input.getInt();
		itemService.deleteItems(itemId);
	}
}
