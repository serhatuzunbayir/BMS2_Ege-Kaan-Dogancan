package src.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.BusManagementSystem.Voyage;

public class IsDurationValidTest {
	@Test
    public void isDurationValid(){
        Voyage voyage = new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046,"comfort");
        int duration = voyage.getDuration();
        assertEquals(240,duration);
        }
	
	@Test
    public void isDurationNotValid(){
        Voyage voyage = new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046,"comfort");
        int duration = voyage.getDuration();
        assertNotEquals(200,duration);
        }
}
