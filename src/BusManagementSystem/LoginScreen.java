package src.BusManagementSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.sql.*;

public class LoginScreen {
    public static void showLoginMenu() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("=====================");
        System.out.println("USER LOGIN");
        System.out.println("=====================");
        // USERNAME & PASSWORD CHECKPOINT WITH SQL QUERIES FOR REGISTERED USERS ON DATABASE
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
            Statement stmt = con.createStatement();
            System.out.println("Enter username: ");
            String username = br.readLine().trim();
            System.out.println("Enter password: ");
            String password = br.readLine().trim();
            String sqlQuery = "select username,password from bmsUsers where username = '"+username+"' and password = '"+password+"'";
            ResultSet rs = stmt.executeQuery(sqlQuery);
            int count = 0;
            while(rs.next()) {
                count = count+1;
            }
            if(count == 1) {
                if("admin".equals(username))
                {
                    User.isAdmin = true;
                }
                System.out.println("You are successfully logged in...");
                User.isLoggedIn = true;
                backToMenu();
            }
            else {
                System.out.println("Invalid username or password. Please try again...");
            }
        }
        catch(Exception e) {
                System.out.println(e);
        }
    }   
    
    // BACK TO THE MAIN MENU SCREEN & CHECKPOINT FOR IF USER IS ADMIN OR NOT
    public static void backToMenu() {
        System.out.println("Press enter to go back to the menu.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        if(User.isAdmin==true) {
            AdminScreen menu = new AdminScreen();
        }
        else {
            MenuScreen menu = new MenuScreen();
        }
    }
}
