package src.test;

import static org.junit.Assert.*;
import java.sql.ResultSet;
import org.junit.Test;

import src.BusManagementSystem.ConnectionManager;
import src.BusManagementSystem.MenuScreen;

public class IsColumnIsAdminValidTest { //  BMS Users Table Column Is Admin Validation Test

	@Test
	public void isColumnIsAdminValid() {
	String columns = "select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='bmsUsers' AND COLUMN_NAME='isAdmin'";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String columnName1 = rs.getString(1);
			 assertEquals("isAdmin",columnName1);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}
	@Test
	public void isColumnIsAdminNotValid() {
	String columns = "select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='bmsUsers' AND COLUMN_NAME='isAdmin'";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String columnName1 = rs.getString(1);
			 assertNotEquals("isAdminn",columnName1);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}


}
