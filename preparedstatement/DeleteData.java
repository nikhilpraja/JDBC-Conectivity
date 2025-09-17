package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteData {

	public static void main(String[] args) {
		
		 final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ps";
		 final String user = "root";
		 final String password = "Nikhil@201";
		 
		 Scanner sc = new Scanner(System.in);
		 
		 try {
			 Connection conn = DriverManager.getConnection(url,user,password);
			 String query = "DELETE FROM info WHERE id=?";
			 PreparedStatement ps = conn.prepareStatement(query);
			 
//			 System.out.println("City:");
//			 ps.setString(1, sc.next());
//			 
//			 System.out.println("Name:");
//			 ps.setString(2, sc.next());
//			 
			 System.out.println("Id: ");
			 ps.setInt(1, sc.nextInt());
		
			 int rowsAffected = ps.executeUpdate();
			 if(rowsAffected>0) {
				 System.out.println("Data Deleted Succesfully");
			 }else {
				 System.out.println("Data Not-Deleted");
			 }
			 sc.close();
		 } catch(Exception e) {
			 System.out.println("Programm having a problem");
		 }
	}
}
