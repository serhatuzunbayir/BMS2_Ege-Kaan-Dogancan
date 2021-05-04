import java.util.Scanner;

public class MenuScreen {
    
    public MenuScreen() {
        Scanner choice = new Scanner(System.in);
        displayMenu();

        switch ( choice.nextInt() ) {
            case 1:
                VoyageScreen.showVoyages();
                break;
            case 2:
                LoginScreen.showLoginMenu();
                break;
            case 3:
                RegisterScreen.showRegisterMenu();
                break;
            case 4:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public void displayMenu() {
        System.out.println("WELCOME TO THE BESTBUS");
        System.out.println("=====================");
        System.out.println("1. List Voyages");
        System.out.println("2. User Login");
        System.out.println("3. User Registration");
        System.out.println("4. Exit");
        System.out.println("=====================");
        System.out.println("Enter choice: ");
    }

    
}
