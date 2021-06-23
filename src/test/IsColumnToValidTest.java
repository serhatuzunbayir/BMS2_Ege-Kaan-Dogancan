package src.test;

import static org.junit.Assert.*;
import java.sql.ResultSet;
import org.junit.Test;

import src.BusManagementSystem.ConnectionManager;
import src.BusManagementSystem.MenuScreen;

public class IsColumnToValidTest { //  Voyages Table Column To Validation Test

	@Test
	public void isColumnToValid() {
	String columns = "select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='voyages' AND COLUMN_NAME='_to'";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String columnName1 = rs.getString(1);
			 assertEquals("_to",columnName1);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}
	@Test
	public void isColumnToNotValid() {
	String columns = "select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='voyages' AND COLUMN_NAME='_to'";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String columnName1 = rs.getString(1);
			 assertNotEquals("_too",columnName1);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}

}
