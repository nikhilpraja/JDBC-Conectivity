package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {

	public static void main(String args[]) {
		final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ps";
		final String username = "root";
		final String password = "Nikhil@201";
		
		try {
			Connection conn = DriverManager.getConnection(url,username,password);
			String query = "INSERT INTO info(id,name,city) VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);

			Scanner sc = new Scanner(System.in);

            System.out.print("How many Data to insert? : ");
            int n = sc.nextInt();
            
            for(int i=1;i<=n;i++) {
            	System.out.println("Enter Id :");
            	ps.setInt(1, sc.nextInt());
            	System.out.println();
            	System.out.println("Enter Name : ");
            	ps.setString(2, sc.next());
            	System.out.println();
            	System.out.println("Enter City: ");
            	ps.setString(3, sc.next());
            	System.out.println();
            	ps.addBatch();
            }
            sc.close();
//			ps.setInt(1, 7);
//			ps.setString(2, "Eternal");
//			ps.setInt(3, 2021);
//			ps.addBatch();
//			
//			ps.setInt(1, 8);
//			ps.setString(2, "Captain America");
//			ps.setInt(3, 2015);
//			ps.addBatch();
//			
//			ps.setInt(1, 3);
//			ps.setString(2, "Bat Man");
//			ps.setInt(3, 2005);
//			ps.addBatch();
//			
//			ps.setInt(1, 4);
//			ps.setString(2, "Spider Man");
//			ps.setInt(3, 2018);
//			ps.addBatch();
//			
//			ps.setInt(1, 5);
//			ps.setString(2, "Hulk");
//			ps.setInt(3, 2029);
//			ps.addBatch();
//			
//			ps.setInt(1, 6);
//			ps.setString(2, "Thor");
//			ps.setInt(3, 2005);
//			ps.addBatch();
			
			int[] rowsAffected = ps.executeBatch();
			
			System.out.println(rowsAffected.length+": Entry Inserted");
			
//			
			
		}catch(SQLException e) {
			System.out.println("Code have Error: " + e);
		}
	}
}
