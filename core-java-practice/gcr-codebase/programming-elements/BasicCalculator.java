import java.util.Scanner;
public class BasicCalculator {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number : ");
        double number1 = sc.nextDouble();   // first number
        System.out.println("Enter the second number : ");
        double number2 = sc.nextDouble();   // second number
        double add = number1 + number2;     // addition
        double sub = number1 - number2;     // subtraction
        double mul = number1 * number2;     // multiplication
        double div = number1 / number2;     // division
        System.out.printf( "The addition, subtraction, multiplication and division value of 2 numbers %.1f and %.1f is %.1f, %.1f, %.1f, and %.2f",
                number1, number2, add, sub, mul, div);
	}

}
