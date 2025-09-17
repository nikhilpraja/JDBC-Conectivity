package com.batchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDataWithPreparedStatement {

	public static void main(String[] args) {
		final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ps";
		final String user = "root";
		final String password = "Nikhil@201";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			

			String query = "INSERT INTO info(id,name,city) VALUES (?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.print("Enter id: ");
				int id = sc.nextInt();
				
				System.out.print("Enter Name: ");
				String name = sc.next();
				
				System.out.print("Enter City: ");
				String city = sc.next();
				 
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, city);
				
				ps.addBatch();
				
				System.out.println("Want to Add more Entry Y/N");
				String choice = sc.next();
				
				if(choice.toUpperCase().equals("N")) {
					break;
				}
				
			}
			int[] rows = ps.executeBatch();
			
			for(int i=0;i<rows.length;i++) {
				System.out.println("Row: "+rows[i]+ " is Submited");
			}
			
			sc.close();
			conn.close();
			
		}catch (Exception e) {
				System.out.println("Error in Code");
			}
	}
}
