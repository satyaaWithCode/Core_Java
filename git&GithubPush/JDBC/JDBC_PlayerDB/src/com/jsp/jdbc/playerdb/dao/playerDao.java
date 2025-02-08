package com.jsp.jdbc.playerdb.dao;

import java.lang.classfile.instruction.SwitchCase;
import java.lang.module.FindException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class playerDao {
	
	Scanner scan = new Scanner(System.in);
	public void addPlayer()
	{
		
		Connection connection=null; //  because  of final block used 

		try {
			//Steps 1-Load and register the driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");  

			// Steps 2 :- Establish the connection
			
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_playerdb?user=root&password=root123");

			//Steps 3:- create statement 
			 
		 PreparedStatement pst =  connection.prepareStatement("INSERT INTO player VALUES(?,?,?,?,?,?)");
		 System.out.println("enter playerId:");
		 pst.setInt(1,scan.nextInt());
		 System.out.println("enter playerName :");
		 pst.setString(2,scan.next());
		 System.out.println("enter playerAge: ");
		 pst.setInt(3,scan.nextInt());
		 System.out.println("enter playerCountry: ");
		 pst.setString(4,scan.next());
		 System.out.println("enter playerTeam");
		 pst.setString(5,scan.next());
		 System.out.println("enter playerSalary");
		 pst.setInt(6, scan.nextInt());
		 
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
	
	
	
	public void deletePlayerbyId()
	{
		//step-1:-Load and Register
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step=-2:-Connection
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_playerdb?user=root&password=root123");

			//step-3&4
			
			PreparedStatement ps=connection.prepareStatement("DELETE FROM  player WHERE playerId =(?)");
			
			System.out.println("Enter The Player Id:- ");
			
			ps.setInt(1, scan.nextInt());
			
			//step:5 
			boolean res= ps.execute();
			//step:-6
			if(res==false) {
				System.out.println("Data Delete SucessFull !! ");
				System.out.println("but one disadvantage it is not count");
			}
			else {
				System.out.println("Data not insert");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAllPlayerByCountry()
	{
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step=-2:-Connection
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_playerdb?user=root&password=root123");

			//step-3&4
			PreparedStatement ps=connection.prepareStatement("DELETE FROM  player WHERE playercountry in (?)");
			System.out.println("Enter The Country Name:- ");
			ps.setString(1, scan.nextLine());
			
			//step:5 
			boolean res= ps.execute();
			//step:-6
			if(res==false) {
				System.out.println("Data Delete SucessFull !! ");
				System.out.println("but one disadvantage it is not count");
			}
			else {
				System.out.println("Data not insert");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void findPlayerBetweenAge() 
	{
		Connection connection = null;
		try {
			//step-1:-Load and Register
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step=-2:-Connection
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_playerdb?user=root&password=root123");
			//Steps 3:- create statement
			Statement statement= connection.createStatement();

			//Steps 4-executed the query
			
			boolean res= statement.execute("Select playerAge from  player");
			ResultSet result =statement.getResultSet();
			
			
			while(result.next())
			{
				System.out.println(result.getInt(1));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			//step:6 connection closed   
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
	public void findAllPlayerByIPLTeam() 
	{
           Connection connection = null;
           
		try {
			//step-1:-Load and Register
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step=-2:-Connection
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_playerdb?user=root&password=root123");			
			//Steps 3:- create statement
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM  player  where playerTeam in(?)");
			System.out.println("Enter playerTeam name:-");
			String country=scan.next();
			ps.setString(1,country);
			
//			step-4:executed the query
			
			ResultSet rSet =ps.executeQuery();
			System.out.println("player Id\\tplayer Name\\tplayer Age\\tplayer Country\\tplayer team\\tplayer Salary");
			
			
			while(rSet.next())
			{
				System.out.println(rSet.getInt(1)+"\t\t");
				System.out.println(rSet.getString(2)+"\t\t");
				System.out.println(rSet.getInt(3)+"\t\t");
				System.out.println(rSet.getString(4)+"\t\t");
				System.out.println(rSet.getString(5)+"\t\t");
				System.out.println(rSet.getInt(6)+"\t\t");
				System.out.println();
			}
			
			
		
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			//step:6 connection closed   
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



	public void findAllPlayerByCountry() 
	{
		Connection connection = null;
		try
		{

			//step-1:-Load and Register
			Class.forName("com.mysql.cj.jdbc.Driver");

			//step=-2:-Connection
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_playerdb?user=root&password=root123");			

			//Steps 3:- create statement & //Steps 4-executed the query
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM  player where playerCountry in(?)");
			System.out.println("Enter Country name:-");
			String country=scan.next();
			ps.setString(1,country);
			
			ResultSet rSet =ps.executeQuery();
			System.out.println("player Id\tplayer Name\tplayer Age\tplayer Country\tplayer team\tplayer Salary");
			while(rSet.next())
			{
				System.out.println(rSet.getInt(1)+"\t\t");
				System.out.println(rSet.getString(2)+"\t\t");
				System.out.println(rSet.getInt(3)+"\t\t");
				System.out.println(rSet.getString(4)+"\t\t");
				System.out.println(rSet.getString(5)+"\t\t");
				System.out.println(rSet.getInt(6)+"\t\t");
				System.out.println();
			}
			
			
		} 

		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		finally {
			//step:6 connection closed   
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
	public void updatePlayerSalaryById()
	{
		Connection connection=null;
		//step-1:-Load and Register
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step=-2:-Connection
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_playerdb?user=root&password=root123");
			
			
			//step-3&4
			PreparedStatement ps=connection.prepareStatement("UPDATE player SET  playerSalary=5000000+ WHERE  in (?)");
			System.out.println("Enter The Player Id:- ");
			ps.setInt(1, scan.nextInt());
			//Step 4:- Executed the Query
			int rowupdate=ps.executeUpdate();
		
			//step 5:- Process The Result
			if(rowupdate>0)
			{
				System.out.println(rowupdate+" SucessFully Update!!!");
			}
			else
			{
				System.out.println("Update UncessFull Pls Again Try!!!");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updatePlayerSalaryBetweenAge()
	{
		
		Connection connection=null; //  because  of final block used 

		try {
			//Steps 1-Load and register the driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");  

			// Steps 2 :- Establish the connection
			
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_playerdb?user=root&password=root123");

			//Steps 3:- create statement 
			 
		 PreparedStatement pst =  connection.prepareStatement("SELECT * FROM player WHERE playerAge BETWEEN ? AND ? ");
		 System.out.println("ENTER initial age : ");
		 pst.setInt(1, scan.nextInt());
		 System.out.println("enter final age : ");
		 pst.setInt(2, scan.nextInt());
		 
			//Steps 4-executed the query
			
			ResultSet rSet = pst.executeQuery();

			//Steps 5 :- PROCESS THE RESULT
			
			
		while(rSet.next()) {
			int playerId=rSet.getInt("playerId");
			int currentSalary=rSet.getInt("playerSalary");
			pst=connection.prepareStatement("UPDATE player SET playerSalary=? WHERE playerId=?");
			pst.setInt(1, currentSalary+5000000);
			pst.setInt(2, playerId);
			
			pst.executeUpdate();
			
			
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
