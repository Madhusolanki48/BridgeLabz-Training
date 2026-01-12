package HotelReservationSystem;

//custom exception
public class RoomNotAvailableException extends Exception {
	public RoomNotAvailableException(String message) {
		super(message);
	}
}
