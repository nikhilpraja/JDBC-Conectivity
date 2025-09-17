package com.batchProcessing; // With Statement

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {

	public static void main(String[] args) {
		final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ps";
		final String user = "root";
		final String password = "Nikhil@201";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			Statement st = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.print("Enter id: ");
				int id = sc.nextInt();
				
				System.out.print("Enter Name: ");
				String name = sc.next();
				
				System.out.print("Enter City: ");
				String city = sc.next();
				 
				System.out.println("Want to Add more Entry Y/N");
				String choice = sc.next();
				String query = String.format("INSERT INTO info(id,name,city) VALUES (%d,'%s','%s')", id,name,city);
				st.addBatch(query);
				if(choice.toUpperCase().equals("N")) {
					break;
				}
				
			}
			int[] rows = st.executeBatch();
			
			for(int i=0;i<rows.length;i++) {
				System.out.println("Row: "+rows[i]+ " is Submited");
			}
			
			sc.close();
			conn.close();
			st.close();
		}catch (Exception e) {
				System.out.println("Error in Code");
			}
	}
}
