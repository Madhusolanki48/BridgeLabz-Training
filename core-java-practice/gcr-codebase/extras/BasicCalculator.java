package extras;
import java.util.Scanner;
public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter first number: ");
        double number1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double number2 = sc.nextDouble();
        System.out.print("Choose operation (+,-,*,/) : ");
        char op = sc.next().charAt(0);
        double result = performOperation(number1, number2, op);
        System.out.println("Result = " + result);

    }

    //method to perform Operations
    public static double performOperation(double a, double b, char op) {
    	//using switch case
        switch (op) {
            case '+':
            	return a + b;
            case '-':
            	return a - b;
            case '*':
            	return a * b;
            case '/': 
            	return b != 0 ? a / b : 0;
            default:
            	return 0;
        }
    }
}

