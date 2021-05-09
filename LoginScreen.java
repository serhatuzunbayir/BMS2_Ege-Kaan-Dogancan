import java.util.Scanner;

public class LoginScreen {
    public static void showLoginMenu() {
        System.out.println("=====================");
        System.out.println("USER LOGIN");
        System.out.println("=====================");
        // USERNAME & PASSWORD INPUTS 
        try(Scanner scanner = new Scanner(System.in)) {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        // ADMIN USER CHECKPOINT
        if("admin".equals(username)) {
            System.out.println("Admin is successfully logged in.");
            System.out.println("=====================");
            backToMenu();
        }
        // USER CHECKPOINT
        else if (!"admin".equals(username)) {
            System.out.println(username+ " is successfully logged in.");
            System.out.println("=====================");
            backToMenu();
        }
        else {
            System.out.println("Invalid username or password.");
            System.out.println("=====================");
            backToMenu();
        }
    }   
    }
    // BACK TO THE MAIN MENU SCREEN
    public static void backToMenu() {
        System.out.println("Press enter to go back to the menu.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        MenuScreen menu = new MenuScreen();
    }
}
