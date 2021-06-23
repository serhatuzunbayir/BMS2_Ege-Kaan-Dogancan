package src.BusManagementSystem;

import java.util.Scanner;

// ADMIN SCREEN NAVIGATOR
public class AdminScreen {
	
    public AdminScreen() {
        Scanner choice = new Scanner(System.in);
        adminMenu();
        switch ( choice.nextInt() ) {
            case 1:
                Voyage.addVoyage();
                break;
            case 2:
                Voyage.deleteVoyage();
                break;
            case 3:
                User.deleteUser();
                break;
            case 4:
                Voyage.printVoyages();
                break;
            case 5:
            	ConnectionManager.resetDB();
            	System.out.println("Database reset succesfully!");
            	break;
            case 6:
            	System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
    
    // ADMIN SCREEN DISPLAY
    public void adminMenu() {
        System.out.println("WELCOME TO THE BESTBUS ADMIN PAGE");
        System.out.println("=====================");
        System.out.println("1. Add Voyage");
        System.out.println("2. Delete Voyage");
        System.out.println("3. Delete User");
        System.out.println("4. List Voyages");
        System.out.println("5. Reset Database");
        System.out.println("6. Exit");
        System.out.println("=====================");
        System.out.println("Enter choice: ");
    }
}
