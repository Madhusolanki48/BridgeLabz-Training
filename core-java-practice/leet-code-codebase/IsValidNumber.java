package leet_code_codebase;
import java.util.Scanner;
//Check whether a given string is a valid number (handling digits, sign, decimal point, and exponent).
public class IsValidNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        //method call
        boolean result = isValidNumber(str);
        //print output
        if (result) {
            System.out.println("Given number is a Valid number !");
        } else {
            System.out.println("Given number is a Invalid number !");
        }
    }
    //method to check whether a number is valid or not
    static boolean isValidNumber(String str) {
        boolean hasNumberPart = false;
        boolean hasExponent = false;
        boolean hasSign = false;
        boolean hasDecimalPoint = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // digit found
            if (ch >= '0' && ch <= '9') {
                hasNumberPart = true;
            }
            // exponent (e or E)
            else if (ch == 'e' || ch == 'E') {
                //e cannot appear twice or before a number
                if (hasExponent || !hasNumberPart)
                    return false;
                hasExponent = true;
                hasSign = false;
                hasNumberPart = false;
                hasDecimalPoint = false;
            }
            //sign (+ or -)
            else if (ch == '+' || ch == '-') {
                //sign only at beginning or after e/E
                if (hasSign || hasNumberPart || hasDecimalPoint)
                    return false;
                hasSign = true;
            }
            //decimal point
            else if (ch == '.') {
                if (hasDecimalPoint || hasExponent)
                    return false;
                hasDecimalPoint = true;
            }
            else {
                return false;
            }
        }
        return hasNumberPart;
    }
}

