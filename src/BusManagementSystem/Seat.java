package src.BusManagementSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Seat {
	
	// SEAT SELECTION FUNCTION FOR EMPTY & OCCUPIED SEAT
    public static void buySeat(int voyageNo) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
        try {
        	System.out.println("Please enter a seat no:");
	    	int seatNo = Integer.parseInt(input.readLine());
        	Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
	        Statement stmt = con.createStatement();
	        Statement stmt2 = con.createStatement();
	        Statement stmt3 = con.createStatement();
	        Statement stmt4 = con.createStatement();
	        Statement stmt5 = con.createStatement();
	        String sqlQuery = "select seatNo from seats where seatNo = '"+seatNo+"'";
	        String sqlQuery2 = "select status from seats where seatNo = '"+seatNo+"'";
	        String sqlQuery3 = "update seats set status = '"+User.ticketName+"' where seatNo = '"+seatNo+"'";
	        String sqlQuery4 = "select numberOfSeats from voyages where voyageNo= '"+voyageNo+"'";

	        ResultSet rs = stmt.executeQuery(sqlQuery);
	        ResultSet rs2 = stmt2.executeQuery(sqlQuery2);
	        ResultSet rs4 = stmt4.executeQuery(sqlQuery4);

	        while(rs.next() && rs2.next() && rs4.next()) {
	        	String empty= rs2.getString(1);
	        	if("empty".equals(empty)) {
	        		stmt3.executeUpdate(sqlQuery3);
	        		System.out.println("Seat selected.");
	        		int seats = rs4.getInt(1);
	    	    	String sqlQuery5 = "update voyages set numberOfSeats = '"+(seats-1)+"' where voyageNo= '"+voyageNo+"'";
	    	    	stmt5.executeUpdate(sqlQuery5);
	        	}
	        	else {
	        		System.out.println("Seat occupied. Please select another seat.");
	        		buySeat(voyageNo);
	        	}
	        }	       
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // BUS VISUAL FUNCTION FOR CUSTOMER TO SELECT SEAT
    public static void selectSeat(int voyageNo) {
    	try {
	    	String sqlQuery = "select _to from voyages where voyageNo = '"+voyageNo+"'";
	    	String sqlQuery2 = "select _from from voyages where voyageNo = '"+voyageNo+"'";
	    	String sqlQuery3 = "select numberOfSeats from voyages where voyageNo= '"+voyageNo+"'";
	    	String sqlQuery4 = "select status from seats";
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
	        Statement stmt = con.createStatement();
	        Statement stmt2 = con.createStatement();
	        Statement stmt3 = con.createStatement();
	        Statement stmt4 = con.createStatement();

	        ResultSet rs = stmt.executeQuery(sqlQuery);
	        ResultSet rs2 = stmt2.executeQuery(sqlQuery2);
	        ResultSet rs3 = stmt3.executeQuery(sqlQuery3);
	        ResultSet rs4 = stmt4.executeQuery(sqlQuery4);

	        while(rs.next() && rs2.next() && rs3.next() && rs4.next()) {
		    	System.out.println("===============================================================================================================");
		    	System.out.println("FROM: "+rs.getString(1)+" 		TO: "+rs2.getString(1)+"		AVAILABLE SEATS: "+rs3.getString(1)+"");
		    	System.out.println("===============================================================================================================");
		    	System.out.println("Please select a seat: ");
		    	for(int i=1; i<=40; i++) {
		    		System.out.format("%-12s %-20s",""+i+".", rs4.getString(1));
		    		rs4.next();
		    	}				
	        }
    	}
    	catch (Exception e) {
            System.out.println(e);
        }
    }
}
