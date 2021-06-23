package src.BusManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionManager {
	 	public static Connection conn=null;
	    public static Statement stmt=null;
	    public static PreparedStatement prepstmt=null;
	    public static String driver = "org.sqlite.JDBC";
	    public static ResultSet rs = null;
	    static Statement [] tables;
	    
	    // ESTABLISH CONNECTION TO DATABASE
	    public static Connection openConnection() throws Exception {
	    	try {
			   // Driver d = (Driver)Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			    conn = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
		        stmt = conn.createStatement();
			    if (conn!= null) {
			    	//System.out.println ("Database connection established.");
			    	}
			    }
		    catch (Exception e) {
			    System.out.println ("Database connection failed.");
			    e.printStackTrace();
		    }
	    return conn;
	}	    
	 // RESET DATABASE FUNCTION FOR ADMIN
	    public static void resetDB() {
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
	            Statement stmt = con.createStatement();
	            Statement stmt2 = con.createStatement();
	            String empty = "empty";
	            String sqlQuery = "update voyages set numberOfSeats = 40 where numberOfSeats != 40";
	            String sqlQuery2 = "update seats set status = '"+empty+"' where status != '"+empty+"'";
	            stmt.executeUpdate(sqlQuery);
	            stmt2.executeUpdate(sqlQuery2);
	            LoginScreen.backToMenu();
	    	}
	    	catch (Exception e) {
	    		System.out.println(e);
	    	}   	
	    }  
}
