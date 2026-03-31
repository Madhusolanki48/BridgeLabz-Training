package arrays;
import java.util.Scanner;
public class FizzBuzzUsingArray {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //check positive number
        if (number > 0) {
            //store the result in string array
            String[] result = new String[number + 1];
            //loop from 1 to the number
            for (int i = 1; i <= number; i++) {
                //check fizzbuzz, fizz or buzz
                if (i % 3 == 0 && i % 5 == 0)
                    result[i] = "FizzBuzz";
                else if (i % 3 == 0)
                    result[i] = "Fizz";
                else if (i % 5 == 0)
                    result[i] = "Buzz";
                else
                    result[i] = String.valueOf(i);
            }
            // print output
            for (int i = 1; i <= number; i++) {
                System.out.println("Position " + i + " = " + result[i]);
            }
        } else {
            // invalid input
            System.out.println("Not a positive integer");
        }
	}
}
