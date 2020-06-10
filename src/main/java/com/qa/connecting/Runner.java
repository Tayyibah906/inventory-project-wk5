package com.qa.connecting;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.qa.connecting.doa.DatabaseConnection;
import com.qa.connecting.utils.Input;

public class Runner {

	public static final Logger LOGGER = Logger.getLogger(Runner.class);

	public static void main(String[] args) throws SQLException {
		Input input = new Input();

		LOGGER.info("Database username: ");
		String user = input.getInput();
		LOGGER.info("Database password: ");
		String password = input.getInput();

		DatabaseConnection connection = new DatabaseConnection(user, password);

		Inv inv = new Inv(input, connection);
		inv.invMenu();
		
		connection.closeConnection();

	}

}
