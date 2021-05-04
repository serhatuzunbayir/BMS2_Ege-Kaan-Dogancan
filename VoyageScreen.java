public class VoyageScreen {
    // VOYAGE CLASS NEEDED
    private static String[] to =  {"Izmir", "Istanbul", "Ankara", "Adana"};
    private static String[] from = {"Izmir", "Istanbul", "Ankara", "Adana"};
    private static int[] price;
    private static int[] duration;
    private static int[][] seats;
    private static int voyageCount;
    private static int voyageNo;
    // VOYAGE CLASS NEEDED

    public static void showVoyages() {
        int i = 0;
        System.out.println("VOYAGES");
        System.out.println("=====================");
        for(i=0; i<voyageCount; i++) {
            // TO
            // FROM
            // PRICE
            // DURATION
            // AVAILABLE SEATS 
            // VOYAGE NO
        }
        System.out.println("=====================");
        System.out.println("Enter Voyage Number to Purchase Ticket: ");
    }
}
