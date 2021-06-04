package src.BusManagementSystem;

import java.io.BufferedReader;
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
        }
        if(VoyageScreen.isExpress==true) {
            voyages.add(new Voyage("Izmir", "Istanbul", 180, 150 , 40, 10203040, "express"));
            voyages.add(new Voyage("Izmir", "Ankara", 250, 160, 40, 10203041, "express"));
            voyages.add(new Voyage("Izmir", "Adana", 304, 250, 40, 10203042, "express"));
            voyages.add(new Voyage("Istanbul", "Izmir", 240, 150 , 40, 10203043, "express"));
            voyages.add(new Voyage("Istanbul", "Ankara", 300, 160, 40, 10203044, "express"));
            voyages.add(new Voyage("Istanbul", "Adana", 500, 250, 40, 10203045, "express"));
            voyages.add(new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046, "express"));
            voyages.add(new Voyage("Ankara", "Izmir", 300, 160, 40, 10203047, "express"));
            voyages.add(new Voyage("Ankara", "Adana", 500, 250, 40, 10203048, "express"));
            voyages.add(new Voyage("Adana", "Istanbul", 240, 150 , 40, 10203049, "express"));
            voyages.add(new Voyage("Adana", "Izmir", 300, 160, 40, 10203050, "express"));
            voyages.add(new Voyage("Adana", "Ankara", 500, 250, 40, 10203051, "express"));
        }
        if(VoyageScreen.isLux==true) {
            voyages.add(new Voyage("Izmir", "Istanbul", 240, 180 , 40, 10203040, "lux"));
            voyages.add(new Voyage("Izmir", "Ankara", 300, 200, 40, 10203041, "lux"));
            voyages.add(new Voyage("Izmir", "Adana", 500, 250, 40, 10203042, "lux"));
            voyages.add(new Voyage("Istanbul", "Izmir", 240, 150 , 40, 10203043, "lux"));
            voyages.add(new Voyage("Istanbul", "Ankara", 300, 160, 40, 10203044, "lux"));
            voyages.add(new Voyage("Istanbul", "Adana", 500, 250, 40, 10203045, "lux"));
            voyages.add(new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046, "lux"));
            voyages.add(new Voyage("Ankara", "Izmir", 300, 160, 40, 10203047, "lux"));
            voyages.add(new Voyage("Ankara", "Adana", 500, 250, 40, 10203048, "lux"));
            voyages.add(new Voyage("Adana", "Istanbul", 240, 150 , 40, 10203049, "lux"));
            voyages.add(new Voyage("Adana", "Izmir", 300, 160, 40, 10203050, "lux"));
            voyages.add(new Voyage("Adana", "Ankara", 500, 250, 40, 10203051, "lux"));
        }
        // PRINTING ADDED VOYAGES
        for(int i=0;i<voyages.size();i++)
            System.out.println(i+") "+"From: "+voyages.get(i).from+" | To: "+voyages.get(i).to+" | Duration: "+voyages.get(i).duration+" minutes "+" | Price: "+ voyages.get(i).price+ " | Empty Seats: "+ voyages.get(i).numberOfSeats+ " | Voyage No: "+voyages.get(i).voyageNo);
    }
    // CHECKING TICKETNO IF IT'S MATCH WITH THE VOYAGENO
    public static void checkTicketNo() {
        for(int i=0; i<voyages.size(); i++){
            if(VoyageScreen.ticketNo != voyages.get(i).voyageNo) {
                confirmed = false;
            }
            else if(VoyageScreen.ticketNo == voyages.get(i).voyageNo) {
                confirmed = true;
                break;
            }
        }
        if(confirmed == false) {
            System.out.println("Invalid Voyage No!");
        }
        else if(confirmed==true) {
            System.out.println("Voyage Selected.");
        }
    }
    // BUY TICKET FUNCTION FOR CUSTOMERS
    public static void buyTicket(){}
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
    public static void deleteVoyage() {}
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