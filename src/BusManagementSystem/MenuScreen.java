package src.BusManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class MenuScreen {
    // MAIN MENU NAVIGATOR
    public MenuScreen() {
        Scanner choice = new Scanner(System.in);
        displayMenu();
        switch ( choice.nextInt() ) {
            case 1:
                VoyageScreen.voyageMenu();
                break;
            case 2:
                Voyage.buyTicket();
                break;
            case 3:
            	LoginScreen.showLoginMenu();
                break;
            case 4:
            	RegisterScreen.showRegisterMenu();
                break;
            case 5:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Error");
                break;
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
    // YENI CLASS OLUSTUR
    public static Connection conn=null;
    public static Statement stmt=null;
    public static PreparedStatement prepstmt=null;
    public static String driver = "org.sqlite.JDBC";
    public static ResultSet rs = null;
    static Statement [] tables;
    
    //to establish connection to database
    public static Connection openConnection() throws Exception {
    	try {
		    //declaring a driver
		   // Driver d = (Driver)Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		    conn = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
	        stmt = conn.createStatement();
		    if (conn!= null) {
		    	System.out.println ("Database connection established.");
		    	}
		    }
	    catch (Exception e) {
		    System.out.println ("Database connection failed.");
		    e.printStackTrace();
	    }

    return conn;
}
}
