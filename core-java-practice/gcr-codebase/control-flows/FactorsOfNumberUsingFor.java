package control_flows;
import java.util.Scanner;
public class FactorsOfNumberUsingFor {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //check positive number
        if (number > 0) {
        	System.out.print("The factors of " + number + " are ");
        	//factors of a number using for loop
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
