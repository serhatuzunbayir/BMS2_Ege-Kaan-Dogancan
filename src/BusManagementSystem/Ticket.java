package src.BusManagementSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ticket {
	private static boolean empty = true;
	public static boolean isSold = false;
	
	// DISPLAY TICKET FUNCTION FOR CUSTOMER TO SEE TICKET AFTER PAYMENT
    public static void displayTicket() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
            Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement();
            Statement stmt3 = con.createStatement();

            String empty = "empty";
            String sqlQuery = "select * from voyages where voyageNo = '"+Voyage.voyageNo+"'";
            String sqlQuery2 = "select seatNo,userID from seats,bmsUsers where status != '"+empty+"' AND userID = '"+User.ID+"'";
            String sqlQuery3 = "select COUNT(*) from seats,bmsUsers where status != '"+empty+"' AND userID = '"+User.ID+"'";
	        ResultSet rs = stmt.executeQuery(sqlQuery);
	        ResultSet rs2 = stmt2.executeQuery(sqlQuery2);
	        ResultSet rs3 = stmt3.executeQuery(sqlQuery3);

	        while(rs.next() && rs2.next() && rs3.next()) {
	        	for(int i =0; i<rs3.getInt(1); i++) {
		    	System.out.println("==============================================================================");
	    		System.out.println("TICKET DETAILS");
		    	System.out.println("==============================================================================");
	    		System.out.println("TO : "+rs.getString(1));
	    		System.out.println("FROM : "+rs.getString(2));
	    		System.out.println("DURATION : "+rs.getString(3));
	    		System.out.println("PRICE : "+rs.getString(4));
	    		System.out.println("VOYAGE NO : "+rs.getString(6));
	    		System.out.println("BUS TYPE : "+rs.getString(7));
	    		System.out.println("SEAT NO : "+rs2.getString(1));
		    	System.out.println("==============================================================================");
	    		rs2.next();
	        	}
	        }
	    	LoginScreen.backToMenu();
    	}
    	catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
 // PAY TICKET FUNCTION FOR CUSTOMERS
    public static void  payTicket(int voyageNo) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
	        Statement stmt = con.createStatement();
	        Statement stmt2 = con.createStatement();
	        Statement stmt3 = con.createStatement();
	        Statement stmt4 = con.createStatement();

	        String sqlQuery = "select price from voyages where voyageNo= '"+voyageNo+"'";
	        String sqlQuery3 = "select voyagePoints from bmsUsers where userID= '"+User.ID+"'";

        	ResultSet rs = stmt.executeQuery(sqlQuery);
        	ResultSet rs3 = stmt3.executeQuery(sqlQuery3);
        	
                	
        	while(rs.next() && rs3.next()) {
        		int voyagePts = rs3.getInt(1);
        		if(voyagePts >= 100) {
            		System.out.println("You have 1 free seat because you have 100 Points.");
        	        String sqlQuery4 = "update bmsUsers set voyagePoints = '"+(voyagePts-100)+"' where userID= '"+User.ID+"'";
            		System.out.println("Press enter if you agree: ");
                    Scanner scanner = new Scanner(System.in);
                    scanner.nextLine();
                    stmt4.executeUpdate(sqlQuery4);
            		isSold = true;
            		System.out.println("Points received, bon voyage... ");
            		LoginScreen.backToMenu();
        		}
        		else {
	        		Voyage.price = rs.getInt(1);
	    	        String sqlQuery2 = "update bmsUsers set voyagePoints = '"+(voyagePts+(Voyage.price*10)/100)+"' where userID= '"+User.ID+"'";
	        		System.out.println("Total price is: "+Voyage.price+"₺");
	        		System.out.println("Press enter if you agree: ");
	                Scanner scanner = new Scanner(System.in);
	                scanner.nextLine();
	        		System.out.println("Please enter your credit card number: ");
	            	String cardNumber = input.readLine();
	        		stmt2.executeUpdate(sqlQuery2);
	        		isSold = true;
	        		System.out.println("Payment received, bon voyage... ");        		
	        		LoginScreen.backToMenu();            		
        		}
        	}
        }
        catch (Exception e) {
        	System.out.println(e);
        }
    }
    
    // BUY TICKET FUNCTION FOR CUSTOMERS
    public static void buyTicket() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
        try {
	    	System.out.println("Please enter a voyage number to buy ticket: ");
	    	Voyage.voyageNo = Integer.parseInt(input.readLine());
	    	checkTicketNo(Voyage.voyageNo);
	    	Seat.selectSeat(Voyage.voyageNo);
	    	Seat.buySeat(Voyage.voyageNo);
	    	payTicket(Voyage.voyageNo);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
 // CHECKING TICKETNO IF IT'S MATCH WITH THE VOYAGENO
    public static void checkTicketNo(int number) {
    	try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
	        Statement stmt = con.createStatement();
	        String sqlQuery = "select voyageNo from voyages where voyageNo = '"+number+"'";
	        ResultSet rs = stmt.executeQuery(sqlQuery);
	        while (rs.next())
	        {
	           int voyageNo = rs.getInt(1);
	           if(number == voyageNo) {
		        	System.out.println("Entry matched with voyage no.");
		            System.out.println("Voyage Selected.");
		            empty = false;
		        }	           
	        }
	        if(empty) {
	            System.out.println("Invalid voyage no! Try again...");
        	   	buyTicket();
            }
	    }
    	catch (Exception e) {
            System.out.println(e);
        }
    }
}
