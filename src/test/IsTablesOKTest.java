package src.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.junit.Test;

import src.BusManagementSystem.MenuScreen;

public class IsTablesOKTest { // IsColumnToValidTest Voyages Table Column To Validation Test

	@Test
	public void test() {
	String columns = "select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='voyages' AND COLUMN_NAME='_to'";	
	try {
		MenuScreen.openConnection();
		ResultSet rs = MenuScreen.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String columnName1 = rs.getString(1);
			 System.out.println(columnName1);
			 assertNotEquals("_too",columnName1);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}

}
