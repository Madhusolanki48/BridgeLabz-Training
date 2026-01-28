package RestaurantTableReservationSystem;
import java.util.Scanner;

public class RestaurantReservationSystem {
	public static void main(String[] args) {
		System.out.println("------- Welcome to Restaurant Table Reservation System --------");
		ReservationSystem system = new ReservationSystem();
		Scanner sc = new Scanner(System.in);
		system.addTable(new Table(1));
		system.addTable(new Table(2));
		system.addTable(new Table(3));
		system.addTable(new Table(4));
		system.addTable(new Table(5));
		int choice;

		do {
			System.out.println("What would you like to do ?");
			System.out.println("\n1. Reserve Table");
			System.out.println("2. Cancel Reservation");
			System.out.println("3. Show Available Tables");
			System.out.println("4. Exit");
			
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:  //to reserve table
				try {
					System.out.print("Enter Table Number: ");
					int tableNumber = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter Time Slot (like: 7PM-8PM): ");
					String timeSlot = sc.nextLine();
					System.out.print("Enter Customer Name: ");
					String customerName = sc.nextLine();
					System.out.print("Enter Customer Phone: ");
					String customerPhone = sc.nextLine();
					system.reserveTable(tableNumber, timeSlot, customerName, customerPhone);
					
				}catch (TableAlreadyReservedException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:  //to cancel reservation
				System.out.print("Enter Table Number: ");
				int tableNumber = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Time Slot: ");
				String timeSlot = sc.nextLine();
				system.cancelReservation(tableNumber, timeSlot);
				break;

			case 3:   //to show all available tables
				System.out.print("Enter Time Slot: ");
				String slot = sc.nextLine();
				system.showAvailableTables(slot);
				break;

			case 4:
				System.out.println("Thank you! Visit Again.");
				break;

			default:
				System.out.println("Invalid choice. Try again.");
			}

		} while (choice != 4);
	}
}
