package com.demo;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class InsertDataInCarTable {

	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/carworld";
		String user = "root";
		String password = "Nikhil@201";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement statment = conn.createStatement();
			int rowsAffected = statment.executeUpdate("INSERT INTO cars(car_id,brand,model,year,price,fuel_type) "
					+ "VALUES(19,'Toyota','Land_Crusier',2024,12000000.120,'Disel')");
			if(rowsAffected>0) {
				System.out.println("Data Inserted Successfully !");
			}else {
				System.out.println("Data is not inserted");
			}
		}catch(SQLException e) {
			System.out.println("Error in code");
		}
	}
}
