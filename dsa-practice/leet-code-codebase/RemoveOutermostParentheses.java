package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 1021
// Remove the outermost parentheses of every primitive string.

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // user input
        System.out.print("Enter parentheses string: ");
        String s = sc.nextLine();

        // method calling
        String result = removeOuterParentheses(s);

        // print output
        System.out.println("After removing outer parentheses: " + result);
    }

    // method to remove outer parentheses
    public static String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // if stack not empty, it means not outer bracket
                if (!st.isEmpty()) {
                    sb.append(ch);
                }
                st.push(ch);
            }
            else {
                st.pop();
                // if stack not empty after pop, it means not outer bracket
                if (!st.isEmpty()) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
