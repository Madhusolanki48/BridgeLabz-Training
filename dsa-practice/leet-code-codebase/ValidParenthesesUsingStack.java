package leet_code_codebase;
import java.util.Scanner;
import java.util.Stack;
// LeetCode Problem: 20
// Check if the given brackets string is valid using stack.
public class ValidParenthesesUsingStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter bracket string: ");
        String s = sc.nextLine();
        //method calling
        boolean result = isValid(s);
        //print output
        if (result)
            System.out.println("Valid Parentheses");
        else
            System.out.println("Invalid Parentheses");
    }

    //method to check valid parentheses
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            //push expected closing bracket
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else {
                // closing bracket case
                if (stack.isEmpty() || stack.pop() != c)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
