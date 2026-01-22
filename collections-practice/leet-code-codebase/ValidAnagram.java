package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 242
// Check if two strings are anagrams using HashMap frequency counting.

public class ValidAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        //method calling
        boolean result = isAnagram(s, t);

        // print output
        if (result)
            System.out.println("Strings are Anagram");
        else
            System.out.println("Strings are NOT Anagram");
    }
    //method to check anagram
    static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        //store character frequency of s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        //reduce frequency using t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}
