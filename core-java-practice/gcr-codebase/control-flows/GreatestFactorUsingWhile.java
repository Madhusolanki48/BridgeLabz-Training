package control_flows;
import java.util.Scanner;
public class GreatestFactorUsingWhile {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a number : ");
	        int number = sc.nextInt();
	        int greatestFactor = 1;
	        int counter = number - 1;
            //greatest factor using while loop
	        while (counter >= 1) {
	            if (number % counter == 0) {
	                greatestFactor = counter;
	                break;
	            }
	            counter--;
	        }
	        System.out.print("Greatest factor of "+number+" is "+greatestFactor);
	    }
}
