package arrays;
import java.util.Scanner;
public class FactorsOfNumberUsingArray {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //initializing array size to 10
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;
        //factors of the number
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                //resizing the array if full
                if (index == maxFactor) {
                    maxFactor = maxFactor * 2; //reset the maxIndex to twice its size
                    int[] temp = new int[maxFactor];
                    for (int j = 0; j < factors.length; j++)
                        temp[j] = factors[j];
                    factors = temp;
                }
                //storing factors in the array
                factors[index++] = i;
            }
        }
        //print factors
        System.out.print("The factors of the number are : ");
        for (int i = 0; i < index; i++)
            System.out.print(factors[i] + " ");
    }
}
