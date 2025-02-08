package com.jsp.jdbc3rdSteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_PreapredStatement_insert {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection connection=null; //  because  of final block used 

		try {
			//Steps 1-Load and register the driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");  

			// Steps 2 :- Establish the connection
			
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/studedntdb?user=root&password=root123");

			//Steps 3:- create statement 
			 
		 PreparedStatement pst =  connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?)");
		 System.out.println("enter student id:");
		 pst.setInt(1,scan.nextInt());
		 System.out.println("enter student name :");
		 pst.setString(2,scan.next());
		 System.out.println("enter student email: ");
		 pst.setString(3,scan.next());
		 System.out.println("enter student marks: ");
		 pst.setInt(4,scan.nextInt());
		 
			//Steps 4-executed the query
			
			int rowsinserted=pst.executeUpdate();

			//Steps 5 :- PROCESS THE RESULT
			
			
			if (rowsinserted>0) {
				System.out.println(rowsinserted+"data inserted");
			} else {
                System.out.println("data not inserted");
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
