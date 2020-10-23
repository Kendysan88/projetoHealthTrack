package br.com.healthtrack;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseManager {

	public static Connection getConnection() {
		Connection conn = null;

		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");

	        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "<USER>", "<PWD>");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}