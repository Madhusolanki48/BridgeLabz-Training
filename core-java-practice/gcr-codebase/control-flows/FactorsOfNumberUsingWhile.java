package control_flows;
import java.util.Scanner;
public class FactorsOfNumberUsingWhile {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a number : ");
	        int number = sc.nextInt();
            //check positive number
	        if (number > 0) {
	            System.out.print("The factors of " + number + " are ");

	            int i = 1;
	            //factors using while loop
	            while (i < number) {
	                if (number % i == 0) {
	                    System.out.print(i + " ");
	                }
	                i++;
	            }
	        }
	 }
}
