package RestaurantTableReservationSystem;

public class Reservation {
	//attributes
	int tableNumber;
	String timeSlot;
	String customerName;
    String customerPhone;
	//constructor
	Reservation(int tableNumber, String timeSlot, String customerName, String customerPhone){
		this.tableNumber=tableNumber;
		this.timeSlot=timeSlot;
		this.customerName = customerName;
        this.customerPhone = customerPhone;
	}
}
