package control_flows;
import java.util.Scanner;
public class MultiplesBelow100UsingWhile {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a number : ");
	        int number = sc.nextInt();
            //multiples of a number below 100 using while loop
	        if (number > 0 && number < 100) {
	            System.out.print("Multiples of " + number + " below 100 are : ");
	            int i = 100;
	            while (i >= 1) {
	                if (i % number == 0) {
	                    System.out.print(i + " ");
	                }
	                i--;
	            }
	        }
	 }

}
