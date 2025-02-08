package com.jsp.jdbc.properties;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC_Properties {

	public static void main(String[] args) {
		Connection connection=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");



			FileReader fReader= new FileReader("DB_Connection.properties");
			Properties properties=new Properties();
			properties.load(fReader);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_playerdb");

			PreparedStatement pStatement=connection.prepareStatement("SELECT * FROM player");

			ResultSet result=pStatement.executeQuery();
			while(result.next())
			{
				System.out.println(result.getInt(1));
				System.out.println(result.getString(2));
				System.out.println(result.getString(3));
				System.out.println(result.getInt(4));
				System.out.println("------------------------");
			}	


		} catch (ClassNotFoundException |IOException | SQLException e) {

			e.printStackTrace();
		}
		
         
        
	}

}
