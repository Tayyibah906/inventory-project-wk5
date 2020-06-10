package com.qa.connecting.dao;

import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.connecting.doa.CustomerDao;
import com.qa.connecting.doa.DatabaseConnection;
import com.qa.connecting.model.Customer;

public class CustomerDaoTest {
	static DatabaseConnection databaseConnection;
	static final String SCHEMA_LOCATION ="src\\test\\resources\\schema.sql";
	static final String DATA_LOCATION ="src\\test\\resources\\data.sql";
	static final String CLEAR_LOCATION ="src\\test\\resources\\ClearDB.sql";
	static final String DROP_LOCATION ="src\\test\\resources\\DropDB.sql";


	private static void sendToDB(Connection connection, String fileLocation) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
            String string;
            while ((string = br.readLine()) != null) {
                try (Statement statement = connection.createStatement();) {
                    statement.executeUpdate(string);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
	
	@BeforeClass
	public static void init() throws SQLException {
		sendToDB(DriverManager.getConnection("jdbc:mysql://35.226.67.80:3306/", "root", "Carpet29"),SCHEMA_LOCATION );
	}
	
	@Before
	public void setup() throws SQLException {
		DatabaseConnection databaseConnection = new DatabaseConnectionTest("root","Capret29");
		sendToDB(databaseConnection.getConnection(),DATA_LOCATION);
	}
	
	@After
	public void teardown() throws SQLException {
		sendToDB(DriverManager.getConnection("jdbc:mysql://35.226.67.80/testdb:3306", "root", "Carpet29"),CLEAR_LOCATION);
	}
	
	@AfterClass
	public static void terminate() throws SQLException {
		sendToDB(DriverManager.getConnection("jdbc:mysql://35.226.67.80:3306", "root", "Carpet29"),DROP_LOCATION);
		databaseConnection.closeConnection();
	}
	
	@Test
	public void test() throws SQLException {
		CustomerDao customerdao = new CustomerDao(databaseConnection);
		Customer test = new Customer("Leon", "95 Elderberry Road", "07985423467", "leon@ping.com",35);
		customerdao.insertCustomer(test);
		
		String query ="SELECT * FROM customer";
		
		ResultSet rs = databaseConnection.sendQuery(query);
		int count = 0;
		while(rs.next()) {
			count++;
		}
		
		assertEquals(4,count);
	}
}


