package src.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.BusManagementSystem.Voyage;

public class IsNumberOfSeatsValidTest {
	@Test
    public void IsNumberOfSeatsValid(){
        Voyage voyage = new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046,"comfort");
        int seats = voyage.getNumberOfSeats();
        assertEquals(40,seats);
        }
	
	@Test
    public void IsNumberOfSeatsNotValid(){
        Voyage voyage = new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046,"comfort");
        int seats = voyage.getNumberOfSeats();
        assertNotEquals(30,seats);
        }
}
