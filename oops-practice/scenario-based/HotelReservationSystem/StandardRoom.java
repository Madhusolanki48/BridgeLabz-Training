package HotelReservationSystem;

//standard room class
public class StandardRoom extends Room {

	//constructor
	public StandardRoom(int roomNumber, double basePrice) {
		super(roomNumber, basePrice);
	}

	@Override
	public String getRoomType() {
		return "Standard Room";
	}
}
