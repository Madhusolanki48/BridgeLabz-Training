package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 1614
// Find the maximum nesting depth of parentheses in a string.

public class MaximumNestingDepth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a String: ");  //e.g. (1+(2*3)+((8)/4))+1  Output=3
        String s = sc.nextLine();
        //method calling
        int result = maxDepth(s);
        //print output
        System.out.println("Maximum Nesting Depth: " + result);
    }

    //method to calculate maximum depth
    public static int maxDepth(String s) {
        int currentDepth = 0;
        int maxDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            }
            else if (c == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }
}
