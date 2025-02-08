package com.jsp.jdbc.playerdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jsp.jdbc.playerdb.dao.playerDao;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		playerDao pd = new playerDao();
		
//		pd.addPlayer();       
//		pd.updatePlayerSalaryById();
//		pd.findAllPlayerByCountry() ;
//		pd.findAllPlayerByIPLTeam();
//		pd.findPlayerBetweenAge() ;
//		pd.deleteAllPlayerByCountry();
//		pd.deletePlayerbyId();  
//		pd. updatePlayerSalaryBetweenAge();
//		
		
		
//		Scanner scan= new Scanner(System.in);
		
		try (Scanner sc = new Scanner(System.in)) {
			playerDao pDao = new playerDao();
			
			
			
			while(true)
			{
			
				System.out.println("1:Add Player");
				System.out.println("2:Find All PlayerBy Country");
				System.out.println("3:Find All PlayerBy IPLTeam");
//				System.out.println("4:Find All PlayerBy BetweenAge");
				System.out.println("5:Find All PlayerBy BetweenAge");
				System.out.println("7:Delete All  PlayerBy Country Name");
				System.out.println("8:Delete PlayerBy Id");
				System.out.println("9:Exit from Project");
				System.out.println("Choose number");
				System.out.println("4: update PlayerSalary BetweenAge()");
				
				
				int choice=sc.nextInt();
				
				if(choice>=1 && choice<=8)
					
				//switch case 
					
				switch(choice)
				{
				case 1: pDao.addPlayer();
				break;
				case 2: pDao.findAllPlayerByCountry();
				break;
				case 3: pDao.findAllPlayerByIPLTeam();
				break;
				case 4: pDao.findPlayerBetweenAge();
				break;
				case 5: pDao.updatePlayerSalaryById();
				break;
				case 6:pDao. updatePlayerSalaryBetweenAge();
				break;
				case 7: pDao.deleteAllPlayerByCountry();
				break;
				case 8: pDao.deletePlayerbyId();
				break;
				case 9:
					System.out.println("Thank You !!!  you are Exit from   Project");
					System.exit(0);
				default: System.out.println("Invalid number");
				}
				
				
			}
		}
		
		
		
		
		
		
		
	
	}

}
