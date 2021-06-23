package src.BusManagementSystem;
import java.sql.*;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Voyage {
    private String to;
    private String from;
    private int duration;
    public static int price;
    private int numberOfSeats;
    public static int voyageNo;
    private static String busType;
    public static ArrayList<Voyage> voyages = new ArrayList<>();
    public static boolean confirmed = false;
	private static boolean empty = true;
    
    public Voyage(String to, String from, int duration, int price, int numberOfSeats, int voyageNo, String busType) {
        this.to = to;
        this.from = from;
        this.duration = duration;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
        this.voyageNo = voyageNo;
        this.busType = busType;
    }
    
    // ADDING TO ARRAYLIST & LISTING VOYAGES FOR BUS TYPES
    public static void listVoyages(){
        try {
            String sqlQuery = "insert voyages values(?,?,?,?,?,?,?)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
            PreparedStatement ps = con.prepareStatement(sqlQuery);
	            if(VoyageScreen.isComfort==true) {
	                voyages.add(new Voyage("Izmir", "Istanbul", 240, 150 , 40, 10203040, "comfort"));
	                voyages.add(new Voyage("Izmir", "Ankara", 300, 160, 40, 10203041, "comfort"));
	                voyages.add(new Voyage("Izmir", "Adana", 500, 250, 40, 10203042, "comfort"));
	                voyages.add(new Voyage("Istanbul", "Izmir", 240, 150 , 40, 10203043, "comfort"));
	                voyages.add(new Voyage("Istanbul", "Ankara", 300, 160, 40, 10203044, "comfort"));
	                voyages.add(new Voyage("Istanbul", "Adana", 500, 250, 40, 10203045, "comfort"));
	                voyages.add(new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046, "comfort"));
	                voyages.add(new Voyage("Ankara", "Izmir", 300, 160, 40, 10203047, "comfort"));
	                voyages.add(new Voyage("Ankara", "Adana", 500, 250, 40, 10203048, "comfort"));
	                voyages.add(new Voyage("Adana", "Istanbul", 240, 150 , 40, 10203049, "comfort"));
	                voyages.add(new Voyage("Adana", "Izmir", 300, 160, 40, 10203050, "comfort"));
	                voyages.add(new Voyage("Adana", "Ankara", 500, 250, 40, 10203051, "comfort"));   
	                printVoyages();
	            } 
	            if(VoyageScreen.isExpress==true) {
	                voyages.add(new Voyage("Izmir", "Istanbul", 180, 150 , 40, 10203052, "express"));
	                voyages.add(new Voyage("Izmir", "Ankara", 250, 160, 40, 10203053, "express"));
	                voyages.add(new Voyage("Izmir", "Adana", 304, 250, 40, 10203054, "express"));
	                voyages.add(new Voyage("Istanbul", "Izmir", 240, 150 , 40, 10203055, "express"));
	                voyages.add(new Voyage("Istanbul", "Ankara", 300, 160, 40, 10203056, "express"));
	                voyages.add(new Voyage("Istanbul", "Adana", 500, 250, 40, 10203057, "express"));
	                voyages.add(new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203058, "express"));
	                voyages.add(new Voyage("Ankara", "Izmir", 300, 160, 40, 10203059, "express"));
	                voyages.add(new Voyage("Ankara", "Adana", 500, 250, 40, 10203060, "express"));
	                voyages.add(new Voyage("Adana", "Istanbul", 240, 150 , 40, 10203061, "express"));
	                voyages.add(new Voyage("Adana", "Izmir", 300, 160, 40, 10203062, "express"));
	                voyages.add(new Voyage("Adana", "Ankara", 500, 250, 40, 10203063, "express"));      
	                printVoyages();
	            }
	            if(VoyageScreen.isLux==true) {
	                voyages.add(new Voyage("Izmir", "Istanbul", 240, 180 , 40, 10203064, "lux"));
	                voyages.add(new Voyage("Izmir", "Ankara", 300, 200, 40, 10203065, "lux"));
	                voyages.add(new Voyage("Izmir", "Adana", 500, 250, 40, 10203066, "lux"));
	                voyages.add(new Voyage("Istanbul", "Izmir", 240, 150 , 40, 10203067, "lux"));
	                voyages.add(new Voyage("Istanbul", "Ankara", 300, 160, 40, 10203068, "lux"));
	                voyages.add(new Voyage("Istanbul", "Adana", 500, 250, 40, 10203069, "lux"));
	                voyages.add(new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203070, "lux"));
	                voyages.add(new Voyage("Ankara", "Izmir", 300, 160, 40, 10203071, "lux"));
	                voyages.add(new Voyage("Ankara", "Adana", 500, 250, 40, 10203072, "lux"));
	                voyages.add(new Voyage("Adana", "Istanbul", 240, 150 , 40, 10203073, "lux"));
	                voyages.add(new Voyage("Adana", "Izmir", 300, 160, 40, 10203074, "lux"));
	                voyages.add(new Voyage("Adana", "Ankara", 500, 250, 40, 10203075, "lux"));
	                printVoyages();
	            } 
	        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    // PRINTING VOYAGES FROM DATABASE
    public static void printVoyages() {
    	try {
    		System.out.println("=====================");
            System.out.println("VOYAGES");
            System.out.println("=====================");
            System.out.println("There are comfort, express and lux busses. Please select your bus type: ");
            Scanner scanner = new Scanner(System.in); 
            busType = scanner.nextLine();
    		Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
	        Statement stmt = con.createStatement();
	        Statement stmt2 = con.createStatement();

	        String sqlQuery = "select * from voyages where busType = '"+busType+"'";
            String sqlQuery2 = "select COUNT(*) from voyages where busType = '"+busType+"'";

	        ResultSet rs = stmt.executeQuery(sqlQuery);
	        ResultSet rs2 = stmt2.executeQuery(sqlQuery2);
	        
	        // ERROR STATE IF THE INPUT ISN'T COMFORT EXPRESS OR LUX
	        if(!"comfort".equals(busType) && !"express".equals(busType) && !"lux".equals(busType)) {
        		System.out.println("Wrong bus type, please try again: ");
        		printVoyages();
        	}
	        
	        while(rs.next() && rs2.next()) {
	        	for(int i = 0; i<rs2.getInt(1); i++) {
		        	if("comfort".equals(busType)) {
		        		System.out.format("TO: %-10s",rs.getString(1));
			    		System.out.format(" FROM: %-10s",rs.getString(2));
			    		System.out.format(" DURATION: %-1s %-10s",rs.getString(3),"minutes");
			    		System.out.format(" PRICE: %-8s",rs.getString(4)+"₺");
			    		System.out.format(" VOYAGE NO: %-10s",rs.getString(6));
			    		System.out.format(" BUS TYPE: %-10s%n",rs.getString(7));
		        	}
		        	else if("express".equals(busType)) {
		        		System.out.format("TO: %-10s",rs.getString(1));
			    		System.out.format(" FROM: %-10s",rs.getString(2));
			    		System.out.format(" DURATION: %-1s %-10s",rs.getString(3),"minutes");
			    		System.out.format(" PRICE: %-8s",rs.getString(4)+"₺");
			    		System.out.format(" VOYAGE NO: %-10s",rs.getString(6));
			    		System.out.format(" BUS TYPE: %-10s%n",rs.getString(7));
			    	}
		        	else if("lux".equals(busType)) {
		        		System.out.format("TO: %-10s",rs.getString(1));
			    		System.out.format(" FROM: %-10s",rs.getString(2));
			    		System.out.format(" DURATION: %-1s %-10s",rs.getString(3),"minutes");
			    		System.out.format(" PRICE: %-8s",rs.getString(4)+"₺");
			    		System.out.format(" VOYAGE NO: %-10s",rs.getString(6));
			    		System.out.format(" BUS TYPE: %-10s%n",rs.getString(7));
			    	}		        	
		        rs.next();
	        	}
	    		LoginScreen.backToMenu();
	        } 
	    }
    	catch (Exception e) {
    		System.out.println(e);
    	}
    }                  
    
    // ADDING VOYAGE FUNCTION FOR ADMIN
    public static void addVoyage() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
        try {
            String sqlQuery = "insert voyages values(?,?,?,?,?,?,?)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            System.out.println("Enter city: ");
            String to = input.readLine();
            System.out.println("Enter city: ");
            String from = input.readLine();
            System.out.println("Enter duration: ");
            int duration = Integer.parseInt(input.readLine());
            System.out.println("Enter price: ");
            int price = Integer.parseInt(input.readLine());
            System.out.println("Enter number of seats: ");
            int numberOfSeats = Integer.parseInt(input.readLine());
            System.out.println("Enter voyage no: ");
            int voyageNo = Integer.parseInt(input.readLine());
            System.out.println("Enter bus type: ");
            String busType = input.readLine();
            voyages.add(new Voyage(to,from,duration,price,numberOfSeats,voyageNo, busType));
            ps.setString(1, to);
            ps.setString(2, from);
            ps.setInt(3, duration);
            ps.setInt(4, price);
            ps.setInt(5, numberOfSeats);
            ps.setInt(6, voyageNo);
            ps.setString(7, busType);
            ps.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Voyage Added Successfully...");
        LoginScreen.backToMenu();
    }
    
    // DELETE VOYAGE FUNCTION FOR ADMIN
    public static void deleteVoyage(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
	        System.out.println("Please enter voyage number to delete a voyage: ");
	        int voyageNumber = Integer.parseInt(input.readLine());
            Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
	        Statement stmt = con.createStatement();
        	String sqlQuery = "delete from voyages where voyageNo = '"+voyageNumber+"'";
        	String sqlQuery2 = "select voyageNo from voyages where voyageNo = '"+voyageNumber+"'";
            Class.forName("com.mysql.cj.jdbc.Driver");
	        ResultSet rs = stmt.executeQuery(sqlQuery2);
            PreparedStatement ps = con.prepareStatement(sqlQuery);	     

	        while(rs.next()) {
	        	int vNo = rs.getInt(1);
	        	if(voyageNumber == vNo) {
		        	System.out.println("Voyage Deleted Successfully...");
		        	empty = false;
	    	        ps.executeUpdate();
	        	}	        		    	       
	        }
	        if(empty) {
	        	System.out.println("There is no voyage in the database. Please try again...");
	        	LoginScreen.backToMenu();
	        }	        
        }
        catch (Exception e) {
        	System.out.println(e);
        }             
    }
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public int getVoyageNo() {
		return voyageNo;
	}
	public void setVoyageNo(int voyageNo) {
		this.voyageNo = voyageNo;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
}