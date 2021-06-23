package src.test;

import static org.junit.Assert.*;
import java.sql.ResultSet;
import org.junit.Test;

import src.BusManagementSystem.ConnectionManager;
import src.BusManagementSystem.MenuScreen;

public class IsColumnVoyageNoValidTest { //  Voyages Table Column Voyage No Validation Test

	@Test
	public void isColumnVoyageNoValid() {
	String columns = "select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='voyages' AND COLUMN_NAME='voyageNo'";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String columnName1 = rs.getString(1);
			 assertEquals("voyageNo",columnName1);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}
	@Test
	public void isColumnVoyageNoNotValid() {
	String columns = "select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='voyages' AND COLUMN_NAME='voyageNo'";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String columnName1 = rs.getString(1);
			 assertNotEquals("voyageNoo",columnName1);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}

}
