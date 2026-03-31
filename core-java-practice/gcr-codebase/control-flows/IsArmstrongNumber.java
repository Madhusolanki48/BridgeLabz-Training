package control_flows;
import java.util.Scanner;
public class IsArmstrongNumber { 
	public static void main(String[] args) {
		//An Armstrong number is a number whose sum of the cubes of its digits is equal to the number itself.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
     
        int originalNumber = number;
        int sum = 0;
        //sum of cubes of digit
        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            sum += digit * digit * digit;
            originalNumber = originalNumber / 10;
        }
        //check armstrong number
        if (sum == number)
            System.out.println(number+" is an Armstrong Number.");
        else
            System.out.println(number+" is not an Armstrong Number.");
    }

}
