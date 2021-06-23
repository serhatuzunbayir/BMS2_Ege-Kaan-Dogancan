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
    private int price;
    private int numberOfSeats;
    private int voyageNo;
    private String busType;
    public static ArrayList<Voyage> voyages = new ArrayList<>();
    public static boolean confirmed = false;

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
                // DATABASE ARRAYLIST PUSH
                for(int i=0; i<voyages.size(); i++){
                    ps.setString(1, voyages.get(i).to);
                    ps.setString(2, voyages.get(i).from);
                    ps.setInt(3, voyages.get(i).duration);
                    ps.setInt(4, voyages.get(i).price);
                    ps.setInt(5, voyages.get(i).numberOfSeats);
                    ps.setInt(6, voyages.get(i).voyageNo);
                    ps.setString(7, voyages.get(i).busType);
                    ps.executeUpdate();
                }
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
                for(int i=0; i<voyages.size(); i++){
                    ps.setString(1, voyages.get(i).to);
                    ps.setString(2, voyages.get(i).from);
                    ps.setInt(3, voyages.get(i).duration);
                    ps.setInt(4, voyages.get(i).price);
                    ps.setInt(5, voyages.get(i).numberOfSeats);
                    ps.setInt(6, voyages.get(i).voyageNo);
                    ps.setString(7, voyages.get(i).busType);
                    ps.executeUpdate();
                }
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
                for(int i=0; i<voyages.size(); i++){
                    ps.setString(1, voyages.get(i).to);
                    ps.setString(2, voyages.get(i).from);
                    ps.setInt(3, voyages.get(i).duration);
                    ps.setInt(4, voyages.get(i).price);
                    ps.setInt(5, voyages.get(i).numberOfSeats);
                    ps.setInt(6, voyages.get(i).voyageNo);
                    ps.setString(7, voyages.get(i).busType);
                    ps.executeUpdate();
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }}
    // PRINTING ADDED VOYAGES
    public static void printVoyages() {
    	for(int i=0;i<voyages.size();i++)
            System.out.println(i+") "+"From: "+voyages.get(i).from+" | To: "+voyages.get(i).to+" | Duration: "+voyages.get(i).duration+" minutes "+" | Price: "+ voyages.get(i).price+ " | Empty Seats: "+ voyages.get(i).numberOfSeats+ " | Voyage No: "+voyages.get(i).voyageNo);
    }
    // CHECKING TICKETNO IF IT'S MATCH WITH THE VOYAGENO
    public static void checkTicketNo(int number) {
    	try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
	        Statement stmt = con.createStatement();
	        String sqlQuery = "select voyageNo from voyages where voyageNo = '"+number+"'";
	        ResultSet rs = stmt.executeQuery(sqlQuery);
	        while (rs.next())
	        {
	           int deneme = rs.getInt(1);
	           System.out.println(deneme);
	           if(number == deneme) {
		        	confirmed = true;
		        }
	        }
	        
	        for(int i=0; i<voyages.size(); i++){
	            if(number != voyages.get(i).voyageNo) {
	                confirmed = false;
	            }
	            else if(number == voyages.get(i).voyageNo) {
	                confirmed = true;
	                break;
	            }
	        }
	        
	        if(confirmed == false) {
	            System.out.println("Invalid Voyage No!");
	        }
	        else if(confirmed == true) {
	            System.out.println("Voyage Selected.");
	        }
	    }
    	catch (Exception e) {
            System.out.println(e);
        }
    }
    // BUY TICKET FUNCTION FOR CUSTOMERS
    public static void buyTicket(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
        try {
	    	System.out.println("Please enter a voyage number to buy ticket: ");
	    	int voyageNo = Integer.parseInt(input.readLine());
	    	checkTicketNo(voyageNo);
	    	String sqlQuery = "select _to from voyages where voyageNo = '"+voyageNo+"'";
	    	String sqlQuery2 = "select _from from voyages where voyageNo = '"+voyageNo+"'";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://94.130.57.82/appsplat_semih", "appsplat_semih", "semihsemih123");
            Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            ResultSet rs2 = stmt2.executeQuery(sqlQuery2);
            while (rs.next())
	        {	
            	String deneme1 = rs.getString(1);
            	System.out.println(deneme1);	           
	        }
            while (rs2.next())
	        {	
            	String deneme2 = rs2.getString(1);
            	System.out.println(deneme2);	           
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
            LoginScreen.backToMenu();
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
    // DELETE VOYAGE FUNCTION FOR ADMIN
    public static void deleteVoyage(){
        printVoyages();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter voyage number to delete a voyage: ");
        int voyageNumber = input.nextInt();
        for(int i = 0; i<voyages.size(); i++) {
            if(voyageNumber == voyages.get(i).voyageNo){
                voyages.remove(i);
                break;
            }
        }
        System.out.println("Deleted Successfully");
        LoginScreen.backToMenu();
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