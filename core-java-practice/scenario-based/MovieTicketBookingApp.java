package scenario_based;
import java.util.Scanner;
class MovieTicketBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("------------------Movie Ticket Booking------------------");
            //user input
            System.out.print("Enter movie type (action/comedy/drama) or 'exit' : ");
            String movieType = sc.next().toLowerCase();
            if (movieType.equals("exit"))
            	break;
            System.out.print("Choose seat type (gold/silver) : ");
            String seatType = sc.next().toLowerCase();
            System.out.print("Add snacks ? (yes/no) : ");
            String snackChoice = sc.next().toLowerCase();
            int ticketCost = 0;
            //switch and if
            switch (movieType) {
                case "action":
                	ticketCost = 180;
                	break;
                case "comedy":
                	ticketCost = 150;
                	break;
                case "drama":
                	ticketCost = 120;
                	break;
                default:
                    System.out.println("Invalid movie type!");
                    continue;
            }
            if (seatType.equals("gold"))
            	ticketCost += 80;
            else if (seatType.equals("silver"))
            	ticketCost += 40;
            else {
                System.out.println("Invalid seat type!");
                continue;
            }
            if (snackChoice.equals("yes"))
            	ticketCost += 60;

            System.out.println("Final Ticket Price : " + ticketCost);
            System.out.println("Booking Confirmed!");
        }
        System.out.println("\n Booking session closed, Thank you! ");
    }
}

