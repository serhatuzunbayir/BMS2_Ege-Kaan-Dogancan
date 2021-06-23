package src.test;
import static org.junit.Assert.*;
import java.sql.ResultSet;
import org.junit.Test;

import src.BusManagementSystem.ConnectionManager;
import src.BusManagementSystem.MenuScreen;

public class IsAdminValidTest { // From BMS Users Where Is Admin Validation Test

	@Test
	public void isAdminValid() {
	String columns = "select isAdmin from bmsUsers where isAdmin = 1";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 int valid = rs.getInt(1);
			 assertEquals(1,valid);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}

	@Test
	public void isAdminNotValid() {
	String columns = "select isAdmin from bmsUsers where isAdmin = 1";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 int valid = rs.getInt(1);
			 assertNotEquals(11,valid);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}
}
