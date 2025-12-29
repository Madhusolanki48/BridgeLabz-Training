package leet_code_codebase;
import java.util.Scanner;
public class RomanToInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a Roman numeral value: ");
        String s = sc.nextLine();
        //method call
        int result = romanToInt(s);
        //print result
        System.out.println("Integer value of "+s +" is : " +result);
    }
    //method to onvert a Roman numeral string into its integer value
    public static int romanToInt(String s) {
        int ans = 0;
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            //convert symbol to value using switch case
            switch (ch) {
                case 'I':
                	num = 1; 
                	break;
                case 'V':
                	num = 5; 
                	break;
                case 'X':
                	num = 10; 
                	break;
                case 'L': 
                	num = 50; 
                	break;
                case 'C': 
                	num = 100; 
                	break;
                case 'D':
                	num = 500;
                	break;
                case 'M':
                	num = 1000;
                	break;
            }
            //subtractive rule check
            if (4 * num < ans)
                ans -= num;
            else
                ans += num;
        }
        return ans;
    }
}
