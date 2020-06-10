package com.qa.connecting;

import org.apache.log4j.Logger;

import com.qa.connecting.controller.Action;
import com.qa.connecting.controller.CustomerController;
import com.qa.connecting.controller.ItemController;
import com.qa.connecting.controller.OrderController;
import com.qa.connecting.doa.CustomerDao;
import com.qa.connecting.doa.DatabaseConnection;
import com.qa.connecting.doa.ItemsDao;
import com.qa.connecting.doa.OrderDao;
import com.qa.connecting.model.SelectableModels;
import com.qa.connecting.services.CustomerService;
import com.qa.connecting.services.ItemService;
import com.qa.connecting.services.OrderService;
import com.qa.connecting.utils.Input;


public class Inv {

	public static final Logger LOGGER = Logger.getLogger(Inv.class);

	private Input input;
	private DatabaseConnection databaseConnection;

	public Inv(Input input, DatabaseConnection databaseConnection) {
		super();
		this.input = input;
		this.databaseConnection = databaseConnection;
	}

	public void invMenu() {
		while (true) {
		String sentence = "Please select from: ";
		for (SelectableModels models : SelectableModels.values()) {
			sentence += models + ", ";
		}
		LOGGER.info(sentence);

		SelectableModels selectedModel;

		while (true) {
			try {
				String choice = input.getInput().toUpperCase();
				selectedModel = SelectableModels.valueOf(choice);
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.warn("Not in the options. please choose from provided list");
			}
		}

		String actionSentence = "Please select from: ";
		for (Action action: Action.values()) {
			actionSentence+= action + ", ";
		}
		LOGGER.info(actionSentence);
		
		Action selectedAction;
		while (true) {
			try {
				String actionInput = input.getInput();
				selectedAction = Action.valueOf(actionInput.toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Not a valid selection. Please re-enter");
			}
		}
		
		switch (selectedModel) {
		case CUSTOMERS:
			CustomerController customerMenu = new CustomerController(input, new CustomerService(new CustomerDao(databaseConnection)));
			customerMenu.run(selectedAction);
			break;
		case ITEMS:
			ItemController itemMenu = new ItemController(input, new ItemService(new ItemsDao(databaseConnection)));
			itemMenu.run(selectedAction);
			break;
		case ORDERS:
			OrderController orderMenu = new OrderController(input, new OrderService(new OrderDao(databaseConnection)));
			orderMenu.run(selectedAction);
			break;
		case EXIT:
			System.exit(0);
			break;
		default:
			System.out.println("Please choose from the options above.");
			break;
		}

		}
	}
}