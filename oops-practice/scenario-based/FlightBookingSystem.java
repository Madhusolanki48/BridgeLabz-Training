package FlightBookingSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightBookingSystem {

	//array to store available flights
	static Flight[] flights = { new Flight(101, "Mumbai", "Delhi", 6700), new Flight(102, "Delhi", "Bangalore", 5700),
			new Flight(103, "Chennai", "Kolkata", 5900), new Flight(104, "Tamil Nadu", "Mumbai", 4500) };

	//list to store bookings
	static List<Booking> bookings = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static int bookingCounter = 1;

	public static void main(String[] args) {

		while (true) {
			System.out.println("\n--- FLIGHT BOOKING SYSTEM ---");
			System.out.println("1. Search Flights");
			System.out.println("2. Book Flight");
			System.out.println("3. View Bookings");
			System.out.println("4. Cancel Booking");
			System.out.println("5. Exit");

			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1 -> searchFlights();
			case 2 -> bookFlight();
			case 3 -> viewBookings();
			case 4 -> cancelBooking();
			case 5 -> {
				System.out.println("Thank you for using Flight Booking System");
				System.exit(0);
			}
			default -> System.out.println("Invalid choice");
			}
		}
	}
	//CRUD operations

	//search
	static void searchFlights() {
		System.out.print("Enter source: ");
		String source = sc.nextLine().toLowerCase();

		System.out.print("Enter destination: ");
		String destination = sc.nextLine().toLowerCase();
		boolean found = false;
		for (Flight f : flights) {
			if (f.source.toLowerCase().equals(source) && f.destination.toLowerCase().equals(destination)) {
				f.displayFlight();
				found = true;
			}
		}

		if (!found) {
			System.out.println("No flights found for this route");
		}
	}

	//create booking
	static void bookFlight() {
		System.out.print("Enter Flight ID to book: ");
		int flightId = sc.nextInt();
		sc.nextLine();
		Flight selectedFlight = null;
		for (Flight f : flights) {
			if (f.flightId == flightId) {
				selectedFlight = f;
				break;
			}
		}

		if (selectedFlight == null) {
			System.out.println("Invalid Flight ID");
			return;
		}
		System.out.print("Passenger Name: ");
		String name = sc.nextLine();
		bookings.add(new Booking(bookingCounter++, name, selectedFlight));
		System.out.println("Flight booked successfully");
	}

	//view bookings
	static void viewBookings() {
		if (bookings.isEmpty()) {
			System.out.println("No bookings available");
			return;
		}
		for (Booking b : bookings) {
			b.displayBooking();
		}
	}

	//delete booking (brute force)
	static void cancelBooking() {
		if (bookings.isEmpty()) {
			System.out.println("No bookings to cancel");
			return;
		}
		System.out.print("Enter Booking ID: ");
		int id = sc.nextInt();

		for (int i = 0; i < bookings.size(); i++) {
			if (bookings.get(i).bookingId == id) {
				bookings.remove(i);
				System.out.println("Booking cancelled successfully");
				return;
			}
		}

		System.out.println("Booking ID not found");
	}
}
