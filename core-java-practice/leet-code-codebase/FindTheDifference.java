package leet_code_codebase;
import java.util.Scanner;
//Given two strings where the second string has one extra character,find the extra character.
public class FindTheDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter string s1 : ");
        String s1 = sc.nextLine();
        System.out.print("Enter another string s2 : ");
        String s2 = sc.nextLine();
        //method call
        char result = findDifference(s1 , s2);
        //print output
        System.out.println("Extra character in second string is : " + result);
    }
    //method to find extra character using ASCII sum
    public static char findDifference(String s1, String s2) {
        int code = 0;
        //add all characters of t
        for (int i = 0; i < s2.length(); i++) {
            code += s2.charAt(i);
        }
        //subtract all characters of s
        for (int i = 0; i < s1.length(); i++) {
            code -= s1.charAt(i);
        }
        //remaining value corresponds to extra character
        return (char) code;
    }
}
