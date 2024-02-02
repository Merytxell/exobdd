package fr.fms.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BddConnection {

	static Connection getConnection() {
		try  {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Shop","root","fms2024");
			return connection;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
