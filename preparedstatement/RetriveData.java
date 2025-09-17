package com.preparedstatement;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetriveData {

	public static void main(String[] args) {
		 final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ps";
		 final String user = "root";
		 final String password = "Nikhil@201";
		 
		 try {
			 Connection conn = DriverManager.getConnection(url,user,password);
			 String query = "SELECT * FROM info where id>=?";
			 PreparedStatement ps = conn.prepareStatement(query);
			 
			 ps.setInt(1, 7);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 int id = rs.getInt("id");
				 String name = rs.getString("name");
				 String city = rs.getString("city");
				 
				 System.out.println("Id: "+id);
				 System.out.println("Name: "+name);
				 System.out.println("City: "+city);
				 System.out.println();
			 }
			 
		 }catch(Exception e) {
			 System.out.println("Programm having a problem");
		 }
		
	}
}
