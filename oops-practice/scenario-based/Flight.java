package FlightBookingSystem;

//class to show available flight details
public class Flight {
    //attributes
	int flightId;
	String source;
	String destination;
	double price;
    //constructor
	public Flight(int flightId, String source, String destination, double price) {
		this.flightId = flightId;
		this.source = source;
		this.destination = destination;
		this.price = price;
	}
    //method to display flight information
	void displayFlight() {
		System.out.println(
				"Flight ID: " + flightId + ", From: " + source + ", To: " + destination + ", Price: ₹" + price);
	}
}