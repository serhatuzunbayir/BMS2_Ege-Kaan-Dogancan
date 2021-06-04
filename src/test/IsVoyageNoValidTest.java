package src.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.BusManagementSystem.Voyage;

public class IsVoyageNoValidTest {
	@Test
    public void isVoyageNoValid(){
        Voyage voyage = new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046,"comfort");
        int voyageNo = voyage.getVoyageNo();
        assertEquals(10203046,voyageNo);
        }
	
	@Test
    public void isVoyageNoNotValid(){
        Voyage voyage = new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046,"comfort");
        int voyageNo = voyage.getVoyageNo();
        assertNotEquals(30405060,voyageNo);
        }
}
