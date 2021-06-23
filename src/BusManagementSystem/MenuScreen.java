package src.BusManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class MenuScreen {
	
    // MAIN MENU NAVIGATOR
    public MenuScreen() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
	        Statement stmt = con.createStatement();
	        Scanner choice = new Scanner(System.in);
	        if(User.isLoggedIn == true) {
	        	isLoggedInDisplayMenu();
	        }
	        else {
	        	displayMenu();
	        }
	        switch ( choice.nextInt() ) {
	            case 1:
	                Voyage.printVoyages();
	                break;
	            case 2:
	            	if(User.isLoggedIn == false) {
		                System.out.println("You must login to the system for purchasing ticket...");
		                LoginScreen.backToMenu();
	            	}
	            	else {
	            		Ticket.buyTicket();
	            		break;
	            	}
	            case 3:
	            	if(User.isLoggedIn == true && Ticket.isSold == false) {
	            		System.out.println("You need to buy ticket first!");
	    	    		LoginScreen.backToMenu();
	            	}
	            	else if(User.isLoggedIn == true && Ticket.isSold == true) {
	            		Ticket.displayTicket();
	            		break;
	            	}	            	
	            	else {
		            	LoginScreen.showLoginMenu();
	            		break;
	            	}
	            case 4:
	            	if(User.isLoggedIn == true) {
	                    System.out.println("Goodbye!");                    
	                    break;
	            	}
	            	else {
	            		RegisterScreen.showRegisterMenu();
	            		break;
	            	}
	            case 5:
	                System.out.println("Goodbye!");
	                break;
	            default:
	                System.out.println("Error");
	                break;
	        }  }
	        catch (Exception e) {
	        	System.out.println(e);
	        }
    	}
    
    // MAIN MENU DISPLAY
    public void displayMenu() {
        System.out.println("WELCOME TO THE BESTBUS");
        System.out.println("=====================");
        System.out.println("1. List Voyages");
        System.out.println("2. Buy Ticket");
        System.out.println("3. User Login");
        System.out.println("4. User Registration");
        System.out.println("5. Exit");
        System.out.println("=====================");
        System.out.println("Enter choice: ");
    }
    
    // LOGGED IN USER MENU DISPLAY
    public void isLoggedInDisplayMenu() {
    	try {
    		String sqlQuery = "select voyagePoints from bmsUsers where userID = '"+User.ID+"'";
    		String sqlQuery2 = "select firstName from bmsUsers where userID = '"+User.ID+"'";
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
	        Statement stmt = con.createStatement();
	        Statement stmt2 = con.createStatement();
	        ResultSet rs = stmt.executeQuery(sqlQuery);
	        ResultSet rs2 = stmt2.executeQuery(sqlQuery2);
	        while(rs.next() && rs2.next()) {
	    		User.ticketName = rs2.getString(1);
	    		System.out.println("WELCOME TO THE BESTBUS "+User.ticketName+" :)");
	            System.out.println("=====================");
	            System.out.println("Your points: " + rs.getString(1));
	            System.out.println("=====================");
	            System.out.println("1. List Voyages");
	            System.out.println("2. Buy Ticket");
	            System.out.println("3. Display Ticket");
	            System.out.println("4. Exit");
	            System.out.println("=====================");
	            System.out.println("Enter choice: ");
	        }
    	}
    	catch (Exception e) {
    		System.out.println(e);
    	}	
    }   
}
