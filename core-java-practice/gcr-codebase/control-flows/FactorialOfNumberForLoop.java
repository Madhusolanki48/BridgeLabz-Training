package control_flows;
import java.util.Scanner;
public class FactorialOfNumberForLoop {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //check positive number
        if (number > 0) {
            int fact = 1;
            //factorial using for loop
            for (int i = 1; i <= number; i++) {
                fact *= i;
            }
            
            System.out.println("Factorial of "+number+" is " + fact);
        } else {
        	//invalid input
            System.out.println("Enter a positive integer");
        }
    }
}
