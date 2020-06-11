package com.qa.connecting.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUtils {

	public static final String SCHEMA_LOCATION = "src" + File.separator + "test" + File.separator + "resources"
			+ File.separator + "Schema.sql";
	public static final String DATA_LOCATION = "src" + File.separator + "test" + File.separator + "resources"
			+ File.separator + "Data.sql";
	public static final String CLEAR_LOCATION = "src" + File.separator + "test" + File.separator + "resources"
			+ File.separator + "ClearDB.sql";
	public static final String DROP_LOCATION = "src" + File.separator + "test" + File.separator + "resources"
			+ File.separator + "DropDB.sql";

	public static void sendToDB(Connection connection, String fileLocation) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
			br.lines().forEach(query -> {
				try {
					Statement statement = connection.createStatement();
					statement.executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
