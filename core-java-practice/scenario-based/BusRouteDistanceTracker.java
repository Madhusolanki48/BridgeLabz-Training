package scenario_based;
import java.util.Scanner;
public class BusRouteDistanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalDistance = 0;
        int stopNumber = 1;
        System.out.println("---------Welcome to the City Bus Route---------");
        while (true) {
        	//user input
            System.out.print("\nEnter distance to Stop " + stopNumber + " (in km): ");
            double distance = sc.nextDouble();
            totalDistance += distance;

            System.out.println("You reached Stop " + stopNumber);
            System.out.println("Total distance travelled : " + totalDistance + " km");
            //Ask if the passenger wants to get off at a stop
            System.out.print("Do you want to travel more ? (yes/no): ");
            String result = sc.next().toLowerCase();

            if (result.equals("no")) {  //exit on user confirmation
                System.out.println("\n Journey Ended at Stop " + stopNumber);
                break;
            }
            stopNumber++;
        }

        System.out.println("Final Distance Travelled: " + totalDistance + " km");
    }
}

