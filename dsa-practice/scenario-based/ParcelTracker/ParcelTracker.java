package ParcelTracker;
import java.util.*;

public class ParcelTracker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------- ParcelTracker – Delivery Chain Management ---------");
		System.out.println("-------------------------------------------------------------");

		//user input
		System.out.print("Enter Parcel ID: ");
		String id = sc.nextLine();
		System.out.println("-------------------------------------------------------------");

		Parcel parcel = new Parcel(id);

		while (true) {

			System.out.println("\nCurrent Parcel ID: " + id);
			System.out.println("What would you like to do?");
			System.out.println("1- Track Parcel Stages");
			System.out.println("2- Add Intermediate Checkpoint");
			System.out.println("3- Mark Parcel Lost");
			System.out.println("4- Exit");
			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				parcel.trackStages();
				break;

			case 2:
				System.out.println("\nAdd a new checkpoint between stages");
				System.out.println("Tip: Use correct stage name like Packed / Shipped / In Transit");
				System.out.println("-------------------------------------------------------------");
				System.out.print("Enter stage after which you want to add checkpoint: ");
				String after = sc.nextLine();
				System.out.print("Enter new checkpoint stage name: ");
				String newStage = sc.nextLine();
				parcel.addCheckpoint(after, newStage);
				break;

			case 3:
				System.out.print("\nAre you sure you want to mark parcel as LOST? (yes/no): ");
				String confirm = sc.nextLine();

				if (confirm.equalsIgnoreCase("yes")) {
					System.out.println("Updating parcel status...");
					System.out.println("-------------------------------------------------------------");
					parcel.markLost();
				} else {
					System.out.println("Parcel not marked as lost.");
					System.out.println("-------------------------------------------------------------");
				}
				break;

			case 4:
				System.out.println("-------------------------------------------------------------");
				System.out.println("ParcelTracker Closed. Thank you!");
				System.out.println("-------------------------------------------------------------");
				return;

			default:
				System.out.println("Invalid choice! Please select correct option.");
				System.out.println("-------------------------------------------------------------");
			}
		}
	}
}
