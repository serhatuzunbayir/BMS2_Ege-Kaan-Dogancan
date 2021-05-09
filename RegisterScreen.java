import java.util.Scanner;

public class RegisterScreen {
    // CREATING ACCOUNT SCREEN WITH INPUTS OF NAME, USERNAME, PASSWORD, HESCODE
    public static void showRegisterMenu() {
        System.out.println("=====================");
        System.out.println("USER REGISTERATION");
        System.out.println("=====================");
        var register = new Registration();
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();
            register.setFirstName(firstName);
            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();
            register.setLastName(lastName);
            System.out.print("Enter your user name: ");
            String username = scanner.nextLine();
            register.setUsername(username);
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            register.setPassword(password);
            System.out.print("Enter your HES Code: ");
            String hesCode = scanner.nextLine();
            register.setHesCode(hesCode);
            System.out.println("=====================");
            System.out.println("Account created successfully.");
            System.out.println("Back to the menu now!");
            System.out.println("=====================");
            MenuScreen menu = new MenuScreen();
        }
    }
    // PRINTING CREATED USER 
    private void printRegisteredUser(Registration register) {
        System.out.println(register.getFirstName());
        System.out.println(register.getLastName());
        System.out.println(register.getUsername());
        System.out.println(register.getPassword());
        System.out.println(register.getHesCode());
    } 
}
    // CAN BE USER CLASS LATER 
    // SETTERS AND GETTERS FOR REGISTRATION OF USER
    class Registration {
        private String firstName;
        private String lastName;
        private String username;
        private String password;
        private String hesCode;

        public String getFirstName() {
            return this.firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getHesCode() {
            return this.hesCode;
        }

        public void setHesCode(String hesCode) {
            this.hesCode = hesCode;
        }
}

