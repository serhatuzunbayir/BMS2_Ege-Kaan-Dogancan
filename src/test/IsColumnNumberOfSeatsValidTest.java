package src.test;

import static org.junit.Assert.*;
import java.sql.ResultSet;
import org.junit.Test;

import src.BusManagementSystem.ConnectionManager;
import src.BusManagementSystem.MenuScreen;

public class IsColumnNumberOfSeatsValidTest { //  Voyages Table Column Number Of Seats Validation Test

	@Test
	public void isColumnNumberOfSeatsValid() {
	String columns = "select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='voyages' AND COLUMN_NAME='numberOfSeats'";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String columnName1 = rs.getString(1);
			 assertEquals("numberOfSeats",columnName1);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}
	@Test
	public void isColumnNumberOfSeatsNotValid() {
	String columns = "select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='voyages' AND COLUMN_NAME='numberOfSeats'";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String columnName1 = rs.getString(1);
			 assertNotEquals("numberOfSeatss",columnName1);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}
}
