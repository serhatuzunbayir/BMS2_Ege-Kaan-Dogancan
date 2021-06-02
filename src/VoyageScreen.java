import java.util.Scanner;

public class VoyageScreen {
    public static int ticketNo;
    private static String busType;
    public static boolean isComfort = false;
    public static boolean isExpress = false;
    public static boolean isLux = false;

    // VOYAGE MENU THAT LIST AVAILABLE VOYAGES AND BUY TICKETS WITH VOYAGENO
    public static void voyageMenu() {
        System.out.println("=====================");
        System.out.println("VOYAGES");
        System.out.println("=====================");
        System.out.println("There are Comfort, Express and Lux type of busses. Please select your bus type:  ");
        Scanner scanner = new Scanner(System.in); 
        busType = scanner.nextLine();
        if("comfort".equals(busType)){
                isComfort = true;
                System.out.println(busType+" class selected.");
                System.out.println("Here are the available voyages...");
                Voyage.listVoyages();
        }
        if("express".equals(busType)) {
                isExpress=true;
                System.out.println(busType+" class selected.");
                System.out.println("Here are the available voyages...");
                Voyage.listVoyages();
        }
        if("lux".equals(busType)) {
                isLux=true;
                System.out.println(busType+" class selected.");
                System.out.println("Here are the available voyages...");
                Voyage.listVoyages();
        }
        
        try(Scanner scanner2 = new Scanner(System.in)) {
            System.out.println("=====================");
            System.out.println("Please Enter Voyage No to Buy Ticket: ");
            ticketNo = scanner2.nextInt();
            Voyage.checkTicketNo();
        }
}
}

