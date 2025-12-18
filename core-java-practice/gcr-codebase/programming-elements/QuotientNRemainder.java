import java.util.Scanner;
public class QuotientNRemainder {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the first number : ");
    int number1 = sc.nextInt(); // first number
    System.out.println("Enter the second number : ");
    int number2 = sc.nextInt(); // second number
    int quotient = number1 / number2;  // quotient
    int remainder = number1 % number2; // remainder
    
    System.out.println("The Quotient is " + quotient +" and Reminder is " + remainder +
        " of two number " + number1 + " and " + number2);
	}

}
