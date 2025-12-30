package class_and_object;

// Class to model a movie ticket
class MovieTicket {
	//attributes
    private String movieName, seatNumber;  
    private double price;
    private boolean booked;  //booking status

    //method to book a ticket (assign seat and update price)
    public void bookTicket(String movieName, String seatNumber, double price) {
        if (booked) {
            System.out.println("House full!!! sorry..... Ticket already booked");
            return;
        }
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        booked = true;

        System.out.println("Ticket booked for movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: $" + price);
    }

    //method to display ticket details
    public void displayTicket() {
        if (!booked)
            System.out.println("Ticket have not booked yet....");
        else {
            System.out.println("\nTicket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }
}

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.displayTicket();
        ticket.bookTicket("Dragon", "A10", 120);
        ticket.bookTicket("Dragon", "A10", 120);
        ticket.displayTicket();
    }
}
