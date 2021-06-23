package src.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.BusManagementSystem.Voyage;

public class IsPriceValidTest {
	@Test
    public void isPriceValid(){
        Voyage voyage = new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046,"comfort");
        int price = voyage.getPrice();
        assertEquals(150,price);
        }
	
	@Test
    public void isPriceNotValid(){
        Voyage voyage = new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046,"comfort");
        int price = voyage.getPrice();
        assertNotEquals(250,price);
        }
}
