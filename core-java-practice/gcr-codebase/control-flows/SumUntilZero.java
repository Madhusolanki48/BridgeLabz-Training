package control_flows;
import java.util.Scanner;
public class SumUntilZero {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        System.out.print("Enter numbers or 0 to terminate : ");
        double number = sc.nextDouble();
        // loop until user enters 0
        while (number != 0) {
        	//add number to total
            total += number;
            System.out.print("Enter a number : ");
            number = sc.nextDouble();
        }
        System.out.println("Total sum = " + total);
    }

}
