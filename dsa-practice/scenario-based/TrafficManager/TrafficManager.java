package TrafficManager;
import java.util.*;

public class TrafficManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Roundabout roundabout = new Roundabout();
		WaitingQueue waitingQueue = new WaitingQueue(5);

		System.out.println("------  TrafficManager - Roundabout System  ------");
		System.out.println("--------------------------------------------------");

		while (true) {
			System.out.println("--------------------- Home page ------------------");
			System.out.println("\n1- Add vehicle to waiting queue");
			System.out.println("2- Allow next vehicle into roundabout");
			System.out.println("3- Remove vehicle from roundabout (exit)");
			System.out.println("4- Display roundabout status");
			System.out.println("5- Display waiting queue");
			System.out.println("6- Exit");
			System.out.println("--------------------------------------------------");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter vehicle number: ");
				String num = sc.nextLine();
				waitingQueue.enqueue(new Vehicle(num));
				break;

			case 2:
				Vehicle v = waitingQueue.dequeue();
				if (v != null) {
					roundabout.addVehicle(v);
					System.out.println("Vehicle entered roundabout: " + v);
				}
				break;

			case 3:
				System.out.print("Enter vehicle number to exit: ");
				String exitVehicle = sc.nextLine();
				if (roundabout.removeVehicle(exitVehicle))
					System.out.println("Vehicle exited successfully!");
				else
					System.out.println("Vehicle not found in roundabout!");
				break;

			case 4:
				roundabout.displayRoundabout();
				break;

			case 5:
				waitingQueue.displayQueue();
				break;

			case 6:
				System.out.println("System Closed!");
				System.out.println("Thank You! Have a Safe Journey...");
				return;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}
