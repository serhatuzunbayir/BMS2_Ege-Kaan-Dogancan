import java.util.Scanner;

public class VoyageScreen {
    public static int ticketNo;
    // VOYAGE MENU THAT LIST AVAILABLE VOYAGES AND BUY TICKETS WITH VOYAGENO
    public static void voyageMenu() {
        System.out.println("=====================");
        System.out.println("VOYAGES");
        System.out.println("=====================");
        System.out.println("Here are the available voyages...");
        Voyage.listVoyages();
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("=====================");
            System.out.println("Please Enter Voyage No to Buy Ticket: ");
            ticketNo = scanner.nextInt();
            Voyage.checkTicketNo();
    }
}
}

