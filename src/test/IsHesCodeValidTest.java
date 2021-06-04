package src.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.BusManagementSystem.User;


public class IsHesCodeValidTest {

	@Test
    public void isHesCodeValid(){
        User user = new User("kaan", "alper", "kaanalper", "123456", "A456B23");
        String hesCode = user.getHesCode();
        assertEquals("A456B23",hesCode);
        }
	
	@Test
    public void isHesCodeNotValid(){
        User user = new User("kaan", "alper", "kaanalper", "123456", "A456B23");
        String hesCode = user.getHesCode();
        assertNotEquals("C123D45",hesCode);
        }
}
