package control_flows;
import java.util.Scanner;
public class IsAbundantNumber {
	//An abundant number is an integer in which the sum of all the divisors of the number is greater than the number itself.
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        int sum = 0;
        //sum of factors
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        //check Abundant Number
        if (sum > number)
            System.out.println(number + " is an Abundant Number");
        else
            System.out.println(number + " is not an Abundant Number");
	}

}
