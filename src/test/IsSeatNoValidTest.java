package src.test;
import static org.junit.Assert.*;
import java.sql.ResultSet;
import org.junit.Test;

import src.BusManagementSystem.ConnectionManager;
import src.BusManagementSystem.MenuScreen;

public class IsSeatNoValidTest { // From Seats Where Seat No Validation Test
	@Test
	public void isSeatNoValid() {
	String columns = "select seatNo from seats where seatNo =40";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 int valid = rs.getInt(1);
			 assertEquals(40,valid);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}
	@Test
	public void isSeatNoNotValid() {
	String columns = "select seatNo from seats where seatNo =40";	
	try {
		ConnectionManager.openConnection();
		ResultSet rs = ConnectionManager.stmt.executeQuery(columns);
		while (rs.next())
	        {	
			 int valid = rs.getInt(1);
			 assertNotEquals(41,valid);         
	        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	}
}
