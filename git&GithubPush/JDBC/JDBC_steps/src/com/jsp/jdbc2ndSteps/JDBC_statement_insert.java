package com.jsp.jdbc2ndSteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC_statement_insert {
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
			
			boolean rowInsert= statement.execute("INSERT INTO STUDENT  VALUES (204,'ram','ram@gmail@com',50)");

			//Steps 5 :- PROCESS THE RESULT
			
			System.out.println("Return type Checked of execute method:- "+ rowInsert);

			if( rowInsert==false) {
				System.out.println("data insert !! ");
				System.out.println("but one disadvantage it is not count");
			}
			else {
				System.out.println("Data not insert");
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









