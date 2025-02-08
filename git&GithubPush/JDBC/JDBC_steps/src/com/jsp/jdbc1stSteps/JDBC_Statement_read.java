package com.jsp.jdbc1stSteps;

import java.nio.channels.Pipe.SourceChannel;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Statement_read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//step-1:load & register the driver
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver(); //load
			DriverManager.registerDriver(driver); //register

			//step-2: Establish the connection

			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307","root","root123");

			//			step-3:create statement

			Statement st=conn.createStatement();			

			
			//			step-4: execute the query

			        ResultSet rs =st.executeQuery("select * from jdbc_studentdb.student");  //read operation
			        System.out.println("studedntId\studentName\studentEmail\studentMarks");
			        
			//			step-5: process the result
			        while (rs.next()) {
			        	
						System.out.println(rs.getInt(1)+"\t\t");
						System.out.println(rs.getString(2)+"\t\t");
						System.out.println(rs.getString("studentEmail")+"\t\t");
						System.out.println(rs.getString("studentMarks")+"\t\t");
						
						System.out.println();
						
					}

			
			//	step-6:
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
