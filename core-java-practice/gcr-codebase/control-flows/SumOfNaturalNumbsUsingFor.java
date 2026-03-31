package control_flows;
import java.util.Scanner;
public class SumOfNaturalNumbsUsingFor {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        if (number > 0) {
            int sum = 0;
            //sum using for loop
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
            //sum using formula
            int sumUsingFormula = number * (number + 1) / 2;

            System.out.println("Sum of "+number+" natural numbers using for loop = " + sum);
            System.out.println("Sum of "+number+" natural numbers using formula = " + sumUsingFormula);
        } else {
            System.out.println("Not a natural number");
        }
    }

}
