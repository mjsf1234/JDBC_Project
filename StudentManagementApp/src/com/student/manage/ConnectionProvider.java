package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection con;
	
	
	public static Connection createConnection() {
		
		
		try {
			
			//Step 1 -> Load a driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//Step  2 Create a connection 
			
			String url = "jdbc:mysql://localhost:3306/student_manage";
			String name ="root";
			String password ="localhost";
			
			try {
				con =DriverManager.getConnection(url, name, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
