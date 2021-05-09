import java.util.ArrayList;

public class Voyage {
    private String to;
    private String from;
    private int duration;
    private double price;
    private int numberOfSeats;
    private int voyageNo;
    public static ArrayList<Voyage> voyages = new ArrayList<>();
    public static boolean confirmed = false;


    public Voyage(String to, String from, int duration, double price, int numberOfSeats, int voyageNo) {
        this.to = to;
        this.from = from;
        this.duration = duration;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
        this.voyageNo = voyageNo;
    }
    // ADDING & LISTING VOYAGES
    public static void listVoyages(){
        voyages.add(new Voyage("Izmir", "Istanbul", 240, 150 , 40, 10203040));
        voyages.add(new Voyage("Izmir", "Ankara", 300, 160, 40, 10203041));
        voyages.add(new Voyage("Izmir", "Adana", 500, 250, 40, 10203042));
        voyages.add(new Voyage("Istanbul", "Izmir", 240, 150 , 40, 10203043));
        voyages.add(new Voyage("Istanbul", "Ankara", 300, 160, 40, 10203044));
        voyages.add(new Voyage("Istanbul", "Adana", 500, 250, 40, 10203045));
        voyages.add(new Voyage("Ankara", "Istanbul", 240, 150 , 40, 10203046));
        voyages.add(new Voyage("Ankara", "Izmir", 300, 160, 40, 10203047));
        voyages.add(new Voyage("Ankara", "Adana", 500, 250, 40, 10203048));
        voyages.add(new Voyage("Adana", "Istanbul", 240, 150 , 40, 10203049));
        voyages.add(new Voyage("Adana", "Izmir", 300, 160, 40, 10203050));
        voyages.add(new Voyage("Adana", "Ankara", 500, 250, 40, 10203051));
        // PRINTING ADDED VOYAGES
        for(int i=0;i<voyages.size();i++)
            System.out.println("From: "+voyages.get(i).from+" | To: "+voyages.get(i).to+" | Duration: "+voyages.get(i).duration+" minutes "+" | Price: "+ voyages.get(i).price+ " | Empty Seats: "+ voyages.get(i).numberOfSeats+ " | Voyage No: "+voyages.get(i).voyageNo);
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
    public static void buyTicket(){}
}
