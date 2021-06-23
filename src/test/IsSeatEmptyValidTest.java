package src.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.Test;

import src.BusManagementSystem.ConnectionManager;
import src.BusManagementSystem.MenuScreen;

public class IsSeatEmptyValidTest { // From Seats Where Status Validation Test

	@Test
	public void isSeatEmptyValid() {
	String columns = "select status from seats where status ='empty'";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String valid = rs.getString(1);
			 assertEquals("empty",valid);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}
	@Test
	public void isSeatEmptyNotValid() {
	String columns = "select status from seats where status ='empty'";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 String valid = rs.getString(1);
			 assertNotEquals("emptyy",valid);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}

}
