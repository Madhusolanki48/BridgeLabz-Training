package FlightBookingSystem;

//class to store user booking details
public class Booking {

	int bookingId;
	String passengerName;
	Flight flight;

	public Booking(int bookingId, String passengerName, Flight flight) {
		this.bookingId = bookingId;
		this.passengerName = passengerName;
		this.flight = flight;
	}
    //method to display booking information
	void displayBooking() {
		System.out.println("Booking ID: " + bookingId + ", Passenger: " + passengerName + ", Flight ID: "
				+ flight.flightId + ", Route: " + flight.source + " -> " + flight.destination);
	}
}