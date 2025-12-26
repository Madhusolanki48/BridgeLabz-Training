package leet_code_codebase;
import java.util.Scanner;
public class IsomorphicStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        //method calling
        boolean result = isIsomorphic(str1, str2);
        //print output
        if (result) {
            System.out.println("Strings are isomorphic !");
        } else {
            System.out.println("Strings are not isomorphic !");
        }
    }
    //method to check isomorphism strings
    //Two strings are isomorphic if every character in the first string can be replaced to get the second string, preserving order.
    public static boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (map1[c1] != map2[c2]) {
                return false;
            }
            //store index + 1 to avoid default 0 conflict
            map1[c1] = i + 1;
            map2[c2] = i + 1;
        }

        return true;
    }
}

