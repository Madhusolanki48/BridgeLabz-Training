import java.util.Scanner;
public class CmToFeetNInches {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the height in cm : ");
	        double height = sc.nextDouble();        // height in cm
	        double totalInches = height / 2.54;     // convert cm to inches
	        int feet = (int)(totalInches/12);   // convert inches to feet
	        double inches = totalInches % 12;   // remaining inches
	        System.out.printf("Your Height in cm is %.2f while in feet is %d and inches is %.2f",height, feet, inches);
	    }

}
