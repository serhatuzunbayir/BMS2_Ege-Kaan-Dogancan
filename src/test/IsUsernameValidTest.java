package src.test;

import static org.junit.Assert.*;


import org.junit.Test;

import src.BusManagementSystem.User;


public class IsUsernameValidTest {

	@Test
    public void isUsernameValid(){
        User user = new User("Dogancan", "Hir", "dogancanh", "123456", "A342B345");
        String username = user.getUsername();
        assertEquals("dogancanh",username);
        }
	
	@Test
    public void isUsernameNotValid(){
        User user = new User("Dogancan", "Hir", "dogancanh", "123456", "A342B345");
        String username = user.getUsername();
        assertNotEquals("Dogancanh",username);
        }
}
