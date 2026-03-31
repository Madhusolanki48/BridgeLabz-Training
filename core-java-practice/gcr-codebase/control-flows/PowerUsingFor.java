package control_flows;
import java.util.Scanner;
public class PowerUsingFor {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a base number : ");
	        int number = sc.nextInt();
	        System.out.print("Enter the power number : ");
	        int power = sc.nextInt();
	        int result = 1;
	        //power using for loop
	        for (int i = 1; i <= power; i++) {
	            result *= number;
	        }
	        System.out.println(number + " raised to power " + power + " is " + result);
	    }
}
