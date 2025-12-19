package control_flows;
import java.util.Scanner;
public class SumOfNaturalNumbsUsingWhile {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //validate natural number
        if (number > 0) {
            int sum = 0;
            int i = 1;
            //sum using while loop
            while (i <= number){
                sum += i;
                i++;
            }
            //sum using formula
            int sumUsingFormula = number * (number + 1) / 2;
            System.out.println("Sum of "+number+" natural numbers using while loop = " + sum);
            System.out.println("Sum of "+number+" natural numbers using formula = " + sumUsingFormula);
        } else {
            System.out.println("Not a natural number");
        }
    }
}
