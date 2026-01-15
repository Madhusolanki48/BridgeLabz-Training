package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 1051
//Count how many students are not standing in the correct order after sorting heights in non-decreasing order.
public class HeightChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] heights = new int[n];
        System.out.println("Enter heights:");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        //method calling
        int result = heightChecker(heights);
        //print output
        System.out.println("Students not in correct position: " + result);
    }

    //method to count mismatched positions after sorting
    public static int heightChecker(int[] heights) {
        //copy original array
        int[] expected = Arrays.copyOf(heights, heights.length);
        //sort copied array
        Arrays.sort(expected);
        int count = 0;
        //compare original and sorted arrays
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }
}
