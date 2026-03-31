package HotelReservationSystem;

//reservation class
public class Reservation {
	//attributes
	private int reservationId;
	private Guest guest;
	private Room room;
	private int nights;
	private String status;

	//constructor
	public Reservation(int reservationId, Guest guest, Room room, int nights) {
		this.reservationId = reservationId;
		this.guest = guest;
		this.room = room;
		this.nights = nights;
		this.status = "BOOKED";
	}

	//getters
	public int getReservationId() {
		return reservationId;
	}

	public Guest getGuest() {
		return guest;
	}

	public Room getRoom() {
		return room;
	}

	public int getNights() {
		return nights;
	}

	public String getStatus() {
		return status;
	}

	//check-in method
	public void checkIn() {
		status = "CHECKED-IN";
	}

	//check-out method
	public void checkOut() {
		status = "CHECKED-OUT";
	}

	@Override
	public String toString() {
		return "Reservation Details: " + "Id - " + reservationId + " | Guest - " + guest.getName() + " | Room No - "
				+ room.getRoomNumber() + " | Status - " + status + " | Nights - " + nights;
	}
}
