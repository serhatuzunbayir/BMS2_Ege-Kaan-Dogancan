package src.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.BusManagementSystem.Voyage;

public class IsFromValidTest {
	@Test
    public void isFromValid(){
        Voyage voyage = new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046,"comfort");
        String from = voyage.getFrom();
        assertEquals("Istanbul",from);
        }
	
	@Test
    public void isFromNotValid(){
        Voyage voyage = new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046,"comfort");
        String from = voyage.getFrom();
        assertNotEquals("istanbul",from);
        }
}
