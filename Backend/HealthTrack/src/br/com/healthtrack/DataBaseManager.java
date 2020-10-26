package br.com.healthtrack;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseManager {
	
	public static Connection getConnection() {
		Connection conn = null;

		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");

	        conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM85337", "110288");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}
