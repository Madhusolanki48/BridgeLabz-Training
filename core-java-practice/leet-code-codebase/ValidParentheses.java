package leet_code_codebase;
import java.util.Scanner;
//Check whether the given string of brackets is valid or not.
public class ValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a string of brackets: ");
        String s = sc.nextLine();
        boolean result = isValid(s);
        if (result) {
            System.out.println("Valid parentheses");
        } else {
            System.out.println("Invalid parentheses");
        }
    }
    static boolean isValid(String s) {
        //keep removing valid pairs
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        //if string becomes empty, it is valid
        return s.length() == 0;
    }
}

