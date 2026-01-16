package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 1047
// Remove all adjacent duplicates in a string.

public class RemoveAllAdjacentDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        //method calling
        String result = removeDuplicates(str);
        //print output
        System.out.println("String after removing duplicates: " + result);
    }
    //method to remove adjacent duplicates using stack-like array
    public static String removeDuplicates(String s) {
        int n = s.length();
        char[] result = new char[n];
        int j = 0; //acts like stack top index

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            //if current char matches top of stack, remove it
            if (j > 0 && ch == result[j - 1]) {
                j--;
                result[j] = '\0';
            }
            //otherwise push into stack
            else {
                result[j++] = ch;
            }
        }

        return new String(result, 0, j);
    }
}
