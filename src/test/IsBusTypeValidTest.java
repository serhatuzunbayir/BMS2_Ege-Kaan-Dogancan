package src.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.BusManagementSystem.Voyage;

public class IsBusTypeValidTest {
	@Test
    public void isBusTypeValid(){
        Voyage voyage = new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046,"comfort");
        String busType = voyage.getBusType();
        assertEquals("comfort",busType);
        }
	
	@Test
    public void isBusTypeNotValid(){
        Voyage voyage = new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046,"comfort");
        String busType = voyage.getBusType();
        assertNotEquals("express",busType);
        }
}
