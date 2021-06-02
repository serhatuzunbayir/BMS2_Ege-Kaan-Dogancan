import java.util.Scanner;

public class AdminScreen {
    public AdminScreen() {
        Scanner choice = new Scanner(System.in);
        adminMenu();
        switch ( choice.nextInt() ) {
            case 1:
                Voyage.addVoyage();
                break;
            case 2:
                // VoyageScreen.deleteVoyage();
                break;
            case 3:
                // User.deleteUser();
                break;
            case 4:
                VoyageScreen.voyageMenu();
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
    public void adminMenu() {
        System.out.println("WELCOME TO THE BESTBUS ADMIN PAGE");
        System.out.println("=====================");
        System.out.println("1. Add Voyage");
        System.out.println("2. Delete Voyage");
        System.out.println("3. Delete User");
        System.out.println("4. Exit");
        System.out.println("=====================");
        System.out.println("Enter choice: ");
    }
}
