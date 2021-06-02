package src.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.BusManagementSystem.Voyage;

public class IsToValidTest {
	@Test
    public void isToValid(){
        Voyage voyage = new Voyage("Izmir", "Istanbul", 240, 150 , 40, 10203040,"comfort");
        String to = voyage.getTo();
        assertEquals("Izmir",to);
        }
	@Test
    public void isToNotValid(){
        Voyage voyage = new Voyage("Izmir", "Istanbul", 240, 150 , 40, 10203040,"comfort");
        String to = voyage.getTo();
        assertNotEquals("izmir",to);
        }
}
