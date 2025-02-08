package com.jsp.jdbc1stSteps;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Statement_insert {

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

			int  row =st.executeUpdate("INSERT INTO jdbc_studentdb.student VALUES(103,'satya','chan341@gmail.com',90)");
			//			step-5: process the result

			if (row>0) {
				System.out.println(row+"data inserted!!");
			} else {
				System.out.println("data not inserted!!");

			}
			//	step-6:
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
