package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CarsTableDataRetrived {

	public static void main(String[] args) {
		final String url = "jdbc:mysql://127.0.0.1:3306/carworld";
		final String user = "root";
		final String password = "Nikhil@201";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM cars WHERE year=2022");
			while(rs.next()) {
				int id = rs.getInt("car_id");
				String brand = rs.getString("brand");
				String model = rs.getString("model");
				int year = rs.getInt("year");
				double price = rs.getDouble("price");
				String fuel_type = rs.getString("fuel_type");
				
				System.out.println("Car id: - "+id + "\nCar brand: - "+brand+"\nCar Model: - "+
									model+"\nCar year: - "+year + "\nCar price: - "+price+"\nCar Fuel-Type: - "+fuel_type);
				
				System.out.println("");
			}
			 
		}catch(SQLException e) {
			System.out.println("Problem in Code");
		}
	}
}
