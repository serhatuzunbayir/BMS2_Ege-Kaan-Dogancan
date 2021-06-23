package src.test;
import static org.junit.Assert.*;
import java.sql.ResultSet;
import org.junit.Test;

import src.BusManagementSystem.ConnectionManager;
import src.BusManagementSystem.MenuScreen;

public class IsColumnStatusValidTest { // Seats Table Column Status Validation Test
	
	@Test
	public void isColumnStatusValid() {
	String columns = "select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='seats' AND COLUMN_NAME='status'";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String columnName1 = rs.getString(1);
			 assertEquals("status",columnName1);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}
	@Test
	public void isColumnStatusNotValid() {
	String columns = "select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='seats' AND COLUMN_NAME='status'";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String columnName1 = rs.getString(1);
			 assertNotEquals("statuss",columnName1);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}

}
