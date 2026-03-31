package control_flows;
import java.util.Scanner;
public class SumUntilZeroOrNegative {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        double total = 0.0;
	        System.out.println("Enter numbers or (0 or negative no. to terminate): ");
	     // loop until user enters 0
	        while (true) {
	        	System.out.print("Enter a number : ");
	            double number = sc.nextDouble();
	            if (number <= 0) {  //if number is negative
	                break;
	            }
	            //add number to total
	            total += number;
	        }
	        System.out.println("Total sum = " + total);
	    }

}
