package RestaurantTableReservationSystem;
import java.util.*;

//service class handling reservation logic
public class ReservationSystem {
    Map<Integer, Table> tables = new HashMap<>();           // store tables
    List<Reservation> reservationList = new ArrayList<>(); // store reservations
    //add table to system
    public void addTable(Table table) {
        tables.put(table.tableNumber, table);
    }

    //method to reserve table with validation
    public void reserveTable(int tableNumber, String timeSlot,
                             String customerName, String customerNumber)
            throws TableAlreadyReservedException {

        Table table = tables.get(tableNumber);

        if (table == null) {
            System.out.println("Invalid table number!");
            return;
        }
        for(Reservation r: reservationList) {
        	if(r.tableNumber==tableNumber && r.timeSlot.equals(timeSlot)) {
        		throw new TableAlreadyReservedException("OOPS! Table "+tableNumber+" already reserved for "+timeSlot);
        	}
        }
        
        reservationList.add(
                new Reservation(tableNumber, timeSlot,customerName, customerNumber));
        System.out.println("\nTable " + tableNumber + " Reserved Successfully!");
        System.out.println("--------------------------------");
        System.out.println("Customer : " + customerName);
        System.out.println("Phone    : " + customerNumber);
        System.out.println("Time     : " + timeSlot);
        System.out.println("--------------------------------");
    }

    //method to cancel reservation
    public void cancelReservation(int tableNumber, String timeSlot) {
        Table table = tables.get(tableNumber);
        for (int i = 0; i < reservationList.size(); i++) {
            Reservation r = reservationList.get(i);
            if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
                reservationList.remove(i);
                System.out.println("Reservation cancelled successfully!");
                return;
            }
        }
        System.out.println("No reservation found");
    }
    //method to show available tables
    public void showAvailableTables(String timeSlot) {
		System.out.println("Available tables for " + timeSlot + ":");
		for(Table t : tables.values()) {
			boolean reserved=false;
			for(Reservation r:reservationList) {
				if(r.tableNumber==t.tableNumber && r.timeSlot.equals(timeSlot)) {
					reserved=true;
					break;
				}
			}
			if(!reserved) {
				System.out.println(t);
			}
		}
    }
}
