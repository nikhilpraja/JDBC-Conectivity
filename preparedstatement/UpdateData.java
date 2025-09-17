package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateData {

	public static void main(String[] args) {
		
		 final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ps";
		 final String user = "root";
		 final String password = "Nikhil@201";
		 
		 Scanner sc = new Scanner(System.in);
		 
		 try {
			 Connection conn = DriverManager.getConnection(url,user,password);
			 String query = "UPDATE info SET city=?, name=? WHERE id=?";
			 PreparedStatement ps = conn.prepareStatement(query);
			 
			 System.out.println("City:");
			 ps.setString(1, sc.next());
			 
			 System.out.println("Name:");
			 ps.setString(2, sc.next());
			 
			 System.out.println("Id: ");
			 ps.setInt(3, sc.nextInt());
		
			 int rowsAffected = ps.executeUpdate();
			 if(rowsAffected>0) {
				 System.out.println("Data Updated Succesfully");
			 }else {
				 System.out.println("Data Not Updaated");
			 }
			 sc.close();
		 } catch(Exception e) {
			 System.out.println("Programm having a problem");
		 }
	}
}
