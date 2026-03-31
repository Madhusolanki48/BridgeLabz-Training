package control_flows;
import java.util.Scanner;
public class FactorialOfNumberWhileLoop {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //check positive number
        if (number > 0) {
            int fact = 1;
            int i = 1;
            //Factorial using while loop
            while (i <= number) {
                fact *= i;
                i++;
            }
            System.out.println("Factorial of "+number+" is " + fact);
        } else {
        	//invalid input
            System.out.println("Enter a positive integer");
        }
    }

}
