package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class StudentDao {

	// insert Query 

	public static boolean insertStudentToDb(Student st) {
		
		boolean f =false;
		
		try {
			
			Connection con = ConnectionProvider.createConnection();
			
			String query = "insert into student(sname ,sphone, scity) values(?,?,?) ";
			
			//prepared statement
			PreparedStatement pspmt = con.prepareStatement(query);
			
			//set the value of parameter
			pspmt.setString(1, st.getStudentName());
			pspmt.setString(2, st.getStudentPhone());
			pspmt.setString(3, st.getStudentCity());
			
			
			pspmt.executeUpdate();
			
			f= true;
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
		
	}

	public static boolean deleteStudent(int id) {
		boolean f =false;
		
		try {
			
			Connection con = ConnectionProvider.createConnection();
			
			String query = "delete from student ifexist where sid =?";
			
			//prepared statement
			PreparedStatement pspmt = con.prepareStatement(query);
			
			//set the value of parameter
			pspmt.setInt(1, id);
			
			pspmt.executeUpdate();
			
			f= true;
			
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return f;
	}

	public static void showAllStudents() {
		
		try {
			
			Connection con  = ConnectionProvider.createConnection();
			
			String query = "select * from student;";
			
			//Statement
			Statement smt = con.createStatement();
			
		    ResultSet set =	smt.executeQuery(query);
		    
		    while(set.next()) {
		    	int id= set.getInt(1);
		    	String name = set.getString(2);
		    	String phone = set.getString(3);
		    	String city = set.getString(4);
		    	
		    	System.out.println("\nID : "+ id);
		    	System.out.println("name : "+ name);
		    	System.out.println("phone : "+ phone);
		    	System.out.println("city : "+ city);
		    	
		    	System.out.println("_________________________");
		    }
			
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
