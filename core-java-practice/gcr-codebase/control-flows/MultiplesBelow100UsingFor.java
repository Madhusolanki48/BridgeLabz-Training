package control_flows;
import java.util.Scanner;
public class MultiplesBelow100UsingFor {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //multiples of a number below 100 using for loop
        if (number > 0 && number < 100) {
            System.out.print("The multiples of " + number + " below 100 are : ");

            for (int i = 100; i >= 1; i--) {
                if (i % number == 0)
                    System.out.print(i + " ");
            }
        }
    }
}
