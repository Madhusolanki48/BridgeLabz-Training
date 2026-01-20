package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 844
// Compare two strings after processing backspaces (#).

public class BackspaceStringCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter string t: ");
        String t = sc.nextLine();

        // method calling
        boolean result = backspaceCompare(s, t);

        // print output
        if (result)
            System.out.println("Both strings are equal after backspaces");
        else
            System.out.println("Strings are NOT equal after backspaces");
    }

    // method to compare strings
    public static boolean backspaceCompare(String s, String t) {

        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {

            //process string s
            int skip1 = 0;
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skip1++;
                    i--;
                } else if (skip1 > 0) {
                    skip1--;
                    i--;
                } else {
                    break;
                }
            }

            //process string t
            int skip2 = 0;
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skip2++;
                    j--;
                } else if (skip2 > 0) {
                    skip2--;
                    j--;
                } else {
                    break;
                }
            }

            //both finished
            if (i == -1 && j == -1)
                return true;

            //compare current characters
            if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
