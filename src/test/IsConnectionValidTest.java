package src.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import src.BusManagementSystem.ConnectionManager;
import src.BusManagementSystem.MenuScreen;

public class IsConnectionValidTest {

	@Test
	public void testOpenConnection () throws Exception {
	//System.out.println("openConnection");
	Connection result = ConnectionManager.openConnection();
	assertEquals(result != null, true) ;
	}

	@Test
	public void testCloseConnection () throws Exception {
	//System.out.println("openConnection");
	Connection result = ConnectionManager.openConnection();
	assertNotEquals(result == null, true) ;
	}
}
