package com.hospital.db.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnect {
	
	private static Connection connection;
	public static Connection connect() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String username = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/  hospital_data";
			
			connection = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
		
	}

	public static void main(String[] args) {
		
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
