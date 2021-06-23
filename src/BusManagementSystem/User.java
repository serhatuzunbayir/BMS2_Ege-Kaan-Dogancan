package src.BusManagementSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class User {
		private String firstName;
        private String lastName;
        private String username;
        private String password;
        private String hesCode;
        public static boolean isLoggedIn = false;
        public static boolean isAdmin = false;
        public static String ID ;
        public static String ticketName;
        public static int voyagePoints = 0;

        public User(String firstName, String lastName, String username, String password, String hesCode) { 		
    		this.firstName = firstName;
    		this.lastName = lastName;
    		this.username = username;
    		this.password = password;
    		this.hesCode = hesCode;
    	}      
        
        // DELETE USER FUNCTION FOR ADMIN
        public static void deleteUser(){
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            try {
    	        System.out.println("Please enter userID to delete a user: ");
    	        int userID = Integer.parseInt(input.readLine());
            	String sqlQuery = "delete from bmsUsers where userID = '"+userID+"'";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
                PreparedStatement ps = con.prepareStatement(sqlQuery);
    	        ps.executeUpdate();
            }
            catch (Exception e) {
            	System.out.println(e);
            }
            
            System.out.println("User Deleted Successfully...");
            LoginScreen.backToMenu();
        }
        
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
