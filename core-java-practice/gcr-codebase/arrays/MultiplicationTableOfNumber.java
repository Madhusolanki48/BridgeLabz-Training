package arrays;
import java.util.Scanner;
public class MultiplicationTableOfNumber {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        int[] table = new int[10];
        //multiplication results stored in array
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }
        //table output
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }
    }
}
