package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateCarTableData {

		public static void main(String[] args) {
			final String url = "jdbc:mysql://127.0.0.1:3306/carworld";
			final String user = "root";
			final String password = "Nikhil@201";
			
			try {
				// Updates in Table
				Connection conn = DriverManager.getConnection(url,user,password);
				Statement statement = conn.createStatement();
				
				int rowsAffected = statement.executeUpdate("UPDATE cars SET fuel_type='Electric ' WHERE fuel_type='EV'");
				if(rowsAffected > 0) {
					System.out.println("Data Updated..");
				}else {
					System.out.println("Data-Not Updated");
					
				}
		
			}catch(SQLException e) {
				System.out.println("Problem in Code");
			}
		}
	}


