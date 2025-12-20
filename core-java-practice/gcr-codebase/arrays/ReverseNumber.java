package arrays;
import java.util.Scanner;
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        int temp = number;
        int count = 0;
        //count the digits in number
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        temp = number;
        //digits stored in reverse number
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        System.out.print("The reverse number is ");
        //reverse number
        for (int i = 0; i < count; i++)
            System.out.print(digits[i]);
    }

}
