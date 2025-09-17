package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDataFromCarTable {

	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://127.0.0.1:3306/carworld";
		String username = "root";
		String password = "Nikhil@201";
		
		try {
			Connection conn = DriverManager.getConnection(url,username,password);
			Statement statement = conn.createStatement();
			
			int rowsAffected = statement.executeUpdate("DELETE FROM cars WHERE car_id=19 ");
			
			if(rowsAffected>0) {
				System.out.println("Data Deleted Successfully...");
			}else {
				System.out.println("Data is Not-Deleted");
			}
			
		}catch(SQLException e) {
			System.out.println("Code Have Errors........" + e);
		}
		
	}
}

