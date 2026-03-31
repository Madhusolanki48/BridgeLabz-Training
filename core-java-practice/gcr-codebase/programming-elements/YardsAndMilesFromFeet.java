import java.util.Scanner;
public class YardsAndMilesFromFeet {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the distance in Feet : ");
	        double distanceInFeet = sc.nextDouble();      // distance in feet
	        //1 mile = 1760 yards and 1 yard is 3 feet
	        double yards = distanceInFeet / 3;   // feet to yards
	        double miles = yards / 1760;        // yards to miles
	        System.out.printf("The distance in feet is %.2f while in yards is %.4f and miles is %.4f",
	                distanceInFeet, yards, miles);
	    }
}
