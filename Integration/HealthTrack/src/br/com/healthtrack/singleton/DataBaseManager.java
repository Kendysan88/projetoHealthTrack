package br.com.healthtrack.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseManager {
	
	public static Connection getConnection() {
		Connection conn = null;

		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");

	        conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM85337", "110288");
//	        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "SYSTEM", "Oradoc_db1");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
