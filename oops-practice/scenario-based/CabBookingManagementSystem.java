package CabBookingManagementSystem;
import java.util.Scanner;

public class CabBookingManagementSystem {
	private static void printMainMenu() {
		System.out.println("""
				------------------ Home Menu --------------------
				1. User Management
				2. Driver Management
				3. Ride Options
				0. Exit
				-------------------------------------------------
				""");
	}

	private static void printUserMenu() {
		System.out.println("""
				\n------------------  USER MENU -----------------
				1. Add User
				2. Update User
				3. Delete User
				4. List Users
				0. Back
				-------------------------------------------------
				""");
	}

	private static void printDriverMenu() {
		System.out.println("""
				\n-----------------  DRIVER MENU ----------------
				1. Add Driver
				2. Update Driver
				3. Delete Driver
				4. List Drivers
				0. Back
				-------------------------------------------------
				""");
	}

	private static void printRideMenu() {
		System.out.println("""
				\n------------------ RIDE MENU -------------------
				1. Book Ride
				2. View Ride History
				0. Back
				--------------------------------------------------
				""");
	}

	public static void main(String[] args) {

		RideService service = new RideService();
		Scanner sc = new Scanner(System.in);

		System.out.println("--------  Welcome to the Cab Booking System!  ---------\n");

		while (true) {

			printMainMenu();
			System.out.print("Choose option: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:    //User Management
				System.out.println("\n Opening User Management...");
				while (true) {
					printUserMenu();
					System.out.print("Choose option: ");
					int user = sc.nextInt();
					sc.nextLine();

					if (user == 0) {
						System.out.println("Returning to Home Menu...\n");
						break;
					}

					switch (user) {

					case 1: //add user
						System.out.print("Enter User ID: ");
						int userId = sc.nextInt();
						sc.nextLine();
						System.out.print("Enter User Name: ");
						service.addUser(new User(userId, sc.nextLine()));
						System.out.println("User added successfully!\n");
						break;

					case 2: //update user
						System.out.print("Enter User ID: ");
						int userIdUpdate = sc.nextInt();
						sc.nextLine();
						System.out.print("Enter New User Name: ");
						service.updateUser(userIdUpdate, sc.nextLine());
						System.out.println("User updated successfully!\n");
						break;

					case 3: //delete user
						System.out.print("Enter User ID: ");
						int userIdDelete = sc.nextInt();
						service.deleteUser(userIdDelete);
						System.out.println("User removed (if existed).\n");
						break;

					case 4: //list users
						System.out.println("\nList of Users:");
						service.listUsers();
						System.out.println();
						break;

					default:
						System.out.println("Invalid option. Try again.\n");
					}
				}
				break;

			//Driver Management
			case 2:
				System.out.println("\n Opening Driver Management...");
				while (true) {
					printDriverMenu();
					System.out.print("Choose option: ");
					int driver = sc.nextInt();
					sc.nextLine();

					if (driver == 0) {
						System.out.println("Returning to Main Menu...\n");
						break;
					}

					switch (driver) {

					case 1: //add driver
						System.out.print("Enter Driver ID: ");
						int driverId = sc.nextInt();
						sc.nextLine();
						System.out.print("Enter Driver Name: ");
						service.addDriver(new Driver(driverId, sc.nextLine()));
						System.out.println("Driver added successfully!\n");
						break;

					case 2: //update driver
						System.out.print("Enter Driver ID: ");
						int driverIdUpdate = sc.nextInt();
						sc.nextLine();
						System.out.print("Enter New Driver Name: ");
						service.updateDriver(driverIdUpdate, sc.nextLine());
						System.out.println("Driver updated successfully!\n");
						break;

					case 3: //delete driver
						System.out.print("Enter Driver ID: ");
						int driverIdDelete = sc.nextInt();
						service.deleteDriver(driverIdDelete);
						System.out.println("Driver removed (if existed).\n");
						break;

					case 4: // list drivers
						System.out.println("\nList of Drivers:");
						service.listDrivers();
						System.out.println();
						break;

					default:
						System.out.println("Invalid option. Try again.\n");
					}
				}
				break;

			//Ride Options
			case 3:
				System.out.println("\n Opening Ride Options...");
				while (true) {
					printRideMenu();
					System.out.print("Choose option: ");
					int ride = sc.nextInt();
					sc.nextLine();

					if (ride == 0) {
						System.out.println("Returning to Main Menu...\n");
						break;
					}

					switch (ride) {

					case 1: // book ride
						try {
							System.out.print("Enter User ID: ");
							int userId = sc.nextInt();
							System.out.print("Enter Distance (in km): ");
							double distance = sc.nextDouble();
							System.out.print("Peak Pricing? (1=yes / 0=no): ");
							boolean peak = sc.nextInt() == 1;

							service.bookRide(userId, distance, peak);

							System.out.println("Ride booked successfully! Thank you for choosing us.\n");

						} catch (NoDriverAvailableException e) {
							System.out.println("Error " + e.getMessage() + "\n");
						}
						break;

					case 2: //ride history
						System.out.print("Enter User ID: ");
						int h = sc.nextInt();
						User userObj = service.getUser(h);

						if (userObj != null)
							userObj.printRideHistory();
						else
							System.out.println("User not found.\n");

						break;

					default:
						System.out.println("Invalid option. Try again.\n");
					}
				}
				break;

			//Exit
			case 0:
				System.out.println("\nThank you for using Cab Booking System!");
				System.out.println("Have a safe journey. Goodbye! ");
				return;

			default:
				System.out.println("Invalid choice. Try again.\n");
			}
		}
	}
}
