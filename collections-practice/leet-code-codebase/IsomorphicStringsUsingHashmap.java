package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 205
// Check if two strings are isomorphic using HashMap mapping.

public class IsomorphicStringsUsingHashmap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // user input
        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();
        // method calling
        boolean result = isIsomorphic(s, t);
        // print output
        if (result)
            System.out.println("Strings are Isomorphic");
        else
            System.out.println("Strings are NOT Isomorphic");
    }

    //method to check isomorphic strings
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            // if already mapped, check mapping
            if (mapS.containsKey(charS)) {
                if (mapS.get(charS) != charT)
                    return false;
            } 
            else {
                // if charT already mapped to some other char, return false
                if (mapT.containsKey(charT) && mapT.get(charT) != charS)
                    return false;

                // store both mappings
                mapS.put(charS, charT);
                mapT.put(charT, charS);
            }
        }

        return true;
    }
}
