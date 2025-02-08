package com.jsp.jdbc2ndSteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_statement_read {
	public static void main(String[] args) {
		Connection connection=null; //  bcz of final bolock used 

		try {
			//Steps 1-Load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");  

			// Steps 2 :- Establish the connection
			
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/studedntdb?user=root&password=root123");

			//Steps 3:- create statement 
			 
			Statement statement= connection.createStatement();

			//Steps 4-executed the query
			
			 ResultSet rs =statement.executeQuery("select * from student");  //read operation
		        System.out.println("studentId\studentName\studentEmail\studentMarks");
		        

			//Steps 5 :- PROCESS THE RESULT
			
		        while (rs.next()) {
		        	
					System.out.println(rs.getInt(1)+"\t\t");
					System.out.println(rs.getString(2)+"\t\t");
					System.out.println(rs.getString("studentEmail")+"\t\t");
					System.out.println(rs.getString("studentMarks")+"\t\t");
					
					System.out.println();
					
				}

		} 
		catch (ClassNotFoundException | SQLException  e) 
		{

			e.printStackTrace(); 
		} 
		
		finally {
			//step-6:close the connection
			
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			
		}

	}
}
