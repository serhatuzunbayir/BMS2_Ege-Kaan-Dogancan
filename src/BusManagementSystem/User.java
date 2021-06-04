package src.BusManagementSystem;
public class User {
    // USER SETTERS GETTERS AND VARIABLES
		private String firstName;
        private String lastName;
        private String username;
        private String password;
        private String hesCode;
        public static boolean isLoggedIn = false;
        public static boolean isAdmin = false;

        public User(String firstName, String lastName, String username, String password, String hesCode) {
    		
    		this.firstName = firstName;
    		this.lastName = lastName;
    		this.username = username;
    		this.password = password;
    		this.hesCode = hesCode;
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
