package RestaurantTableReservationSystem;

public class Table {
	//attributes
	int tableNumber;
	//constructor
	Table(int tableNumber){
		this.tableNumber=tableNumber;
		
	}
	@Override
    public String toString() {
        return "Table " + tableNumber;
    }

}
