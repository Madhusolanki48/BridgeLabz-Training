package arrays;
import java.util.Scanner;
public class FrequencyOfDigits {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // take input
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        int[] freq = new int[10];   //size of 10 given

        //digit frequency count
        while (number != 0) {
            freq[number % 10]++;
            number /= 10;
        }
        // print result
        System.out.println("Each digit frequency in the number:");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println("Digit " + i + " appears " + freq[i] + " time(s)");
            }
        }
	}
}
            


