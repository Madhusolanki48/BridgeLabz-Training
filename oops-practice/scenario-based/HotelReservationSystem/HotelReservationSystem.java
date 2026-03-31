package HotelReservationSystem;
import java.util.ArrayList;
import java.util.Scanner;

//main class
public class HotelReservationSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//room list
		ArrayList<Room> rooms = new ArrayList<>();
		ArrayList<Guest> guests = new ArrayList<>();
		ArrayList<Reservation> reservations = new ArrayList<>();
		//adding some rooms initially
		rooms.add(new StandardRoom(101, 1500));
		rooms.add(new StandardRoom(102, 1500));
		rooms.add(new DeluxeRoom(201, 2500));
		rooms.add(new DeluxeRoom(202, 2500));
		System.out.println("----  Welcome to Hotel Reservation System  ----");

		while (true) {
			System.out.println("\n----------- Home Page -----------");
			System.out.println("1. View Rooms");
			System.out.println("2. Add Room");
			System.out.println("3. Book Reservation");
			System.out.println("4. Check-In");
			System.out.println("5. Check-Out");
			System.out.println("6. Generate Invoice");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			if (choice == 0) {
				System.out.println("Exiting... Thank you!");
				break;
			}

			switch (choice) {
			//CRUD Operations 
			case 1:  //room management - read 
				System.out.println("\n----- Room List -----");
				for (Room r : rooms)
					System.out.println(r);
				break;

			case 2:  //create
				System.out.println("\nSelect Room Type:");
				System.out.println("1. Standard Room");
				System.out.println("2. Deluxe Room");
				System.out.print("Enter type: ");
				int type = sc.nextInt();

				System.out.print("Enter Room Number: ");
				int roomNo = sc.nextInt();

				System.out.print("Enter Base Price: ");
				double basePrice = sc.nextDouble();

				if (type == 1) {
					rooms.add(new StandardRoom(roomNo, basePrice));
				} else if (type == 2) {
					rooms.add(new DeluxeRoom(roomNo, basePrice));
				} else {
					System.out.println("Invalid Room Type!");
				}

				System.out.println("Room Added Successfully!");
				break;

			case 3:   //reservation booking -create
				System.out.print("\nEnter Guest Id: ");
				int gid = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Guest Name: ");
				String gname = sc.nextLine();
				System.out.print("Enter Guest Phone: ");
				String phone = sc.nextLine();

				Guest guest = new Guest(gid, gname, phone);
				guests.add(guest);
				System.out.print("Enter Room Number to Book: ");
				int bookRoomNo = sc.nextInt();
				System.out.print("Enter Number of Nights: ");
				int nights = sc.nextInt();
				Room selectedRoom = null;
				for (Room r : rooms) {
					if (r.getRoomNumber() == bookRoomNo) {
						selectedRoom = r;
						break;
					}
				}

				try {
					if (selectedRoom != null) {
						if (!selectedRoom.isAvailable()) {
							throw new RoomNotAvailableException("Room " + bookRoomNo + " is not available!");
						}

						Reservation res = new Reservation(reservations.size() + 1, guest, selectedRoom, nights);
						reservations.add(res);

						selectedRoom.setAvailable(false);

						System.out.println("Reservation Booked Successfully!");
						System.out.println(res);

					} else {
						System.out.println("Invalid Room Number!");
					}
				} catch (RoomNotAvailableException e) {
					System.out.println("Error: " + e.getMessage());
				}

				break;
			case 4:  //Check-In
				System.out.print("\nEnter Reservation Id for Check-In: ");
				int checkInId = sc.nextInt();

				Reservation checkInRes = findReservation(reservations, checkInId);
				if (checkInRes == null) {
					System.out.println("Reservation not found!");
				} else {
					checkInRes.checkIn();
					System.out.println("✅ Check-In Successful!");
				}
				break;
			case 5:  //Check-Out
				System.out.print("\nEnter Reservation Id for Check-Out: ");
				int checkOutId = sc.nextInt();

				Reservation checkOutRes = findReservation(reservations, checkOutId);
				if (checkOutRes == null) {
					System.out.println("Reservation not found!");
				} else {
					checkOutRes.checkOut();
					checkOutRes.getRoom().setAvailable(true);
					System.out.println("✅ Check-Out Successful!");
				}
				break;

			//Invoice Generation
			case 6:
				System.out.print("\nEnter Reservation Id to Generate Invoice: ");
				int invoiceId = sc.nextInt();

				Reservation invoiceRes = findReservation(reservations, invoiceId);
				if (invoiceRes == null) {
					System.out.println("Reservation not found!");
				} else {
					PricingStrategy pricing = new SeasonalPricing(); //polymorphism
					double total = pricing.calculateTotal(invoiceRes.getRoom(), invoiceRes.getNights());

					System.out.println("\n--------- INVOICE ---------");
					System.out.println("Reservation Id: " + invoiceRes.getReservationId());
					System.out.println("Guest Name: " + invoiceRes.getGuest().getName());
					System.out.println("Room: " + invoiceRes.getRoom().getRoomType() + " (" + invoiceRes.getRoom().getRoomNumber() + ")");
					System.out.println("Nights: " + invoiceRes.getNights());
					System.out.println("Total Bill: ₹" + total);
					System.out.println("---------------------------");
				}
				break;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
	//method to find reservation
	private static Reservation findReservation(ArrayList<Reservation> reservations, int id) {
		for (Reservation r : reservations) {
			if (r.getReservationId() == id)
				return r;
		}
		return null;
	}
}
