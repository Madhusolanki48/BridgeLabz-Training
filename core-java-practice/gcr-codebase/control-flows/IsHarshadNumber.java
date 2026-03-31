package control_flows;
import java.util.Scanner;
public class IsHarshadNumber {
	public static void main(String[] args) {
		//Harshad number is a number that is divisible by the sum of its digits.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
 
        int originalNumber = number;
        int sum = 0;
        //sum of digits
        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
        //check Harshad Number
        if (originalNumber % sum == 0)
            System.out.println(originalNumber + " is a Harshad Number");
        else
            System.out.println(originalNumber + " is not a Harshad Number");
    }

}
