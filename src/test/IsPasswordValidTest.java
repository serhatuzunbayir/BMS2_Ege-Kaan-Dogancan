package src.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.BusManagementSystem.User;


public class IsPasswordValidTest {

	@Test
    public void isPasswordValid(){
        User user = new User("ege", "kural", "egekural", "123456", "A124M56");
        String password = user.getPassword();
        assertEquals("123456",password);
        }
	
	@Test
    public void isPasswordNotValid(){
        User user = new User("ege", "kural", "egekural", "123456", "A124M56");
        String password = user.getPassword();
        assertNotEquals("678901",password);
        }
}
