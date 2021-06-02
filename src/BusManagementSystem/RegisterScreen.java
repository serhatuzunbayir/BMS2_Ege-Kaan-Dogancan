package src.BusManagementSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class RegisterScreen {
    // CREATING ACCOUNT SCREEN WITH INPUTS OF NAME, USERNAME, PASSWORD, HESCODE
    public static void showRegisterMenu() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("=====================");
        System.out.println("USER REGISTERATION");
        System.out.println("=====================");
        try {
            String sqlQuery = "insert bmsUsers values(?,?,?,?,?,?,?)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            System.out.print("Enter your first name: ");
            String firstName = br.readLine();
            ps.setString(1, firstName);
            System.out.print("Enter your last name: ");
            String lastName = br.readLine();
            ps.setString(2, lastName);
            System.out.print("Enter your user name: ");
            String username = br.readLine();
            ps.setString(3, username);
            System.out.print("Enter your password: ");
            String password = br.readLine();
            ps.setString(4, password);
            System.out.print("Enter your HES Code: ");
            String hesCode = br.readLine();
            ps.setString(5, hesCode);
            int voyagePoints = 0;
            int isAdmin = 0;
            ps.setInt(6, voyagePoints);
            ps.setInt(7, isAdmin);
            ps.executeUpdate();
            System.out.println("=====================");
            System.out.println("Account created successfully.");
            LoginScreen.backToMenu();
            //MenuScreen menu = new MenuScreen();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    // // PRINTING CREATED USER 
    // private void printRegisteredUser(Registration register) {
    //     System.out.println(register.getFirstName());
    //     System.out.println(register.getLastName());
    //     System.out.println(register.getUsername());
    //     System.out.println(register.getPassword());
    //     System.out.println(register.getHesCode());
    // } 
}
