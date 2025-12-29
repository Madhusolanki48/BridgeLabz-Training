package extras;
import java.util.Scanner;
public class MaximumOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = takeInput();     //method call for input
        //method call to find max
        int max = findMaximum(nums[0], nums[1], nums[2]);
        //print output
        System.out.println("Maximum number : " + max);
    }
    //method to take input of three numbers
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        //user input
        System.out.print("Enter three numbers :");
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    //method to find maximum of three numbers
    public static int findMaximum(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
}

