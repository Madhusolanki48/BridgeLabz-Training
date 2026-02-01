package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 409
// Find the length of the longest palindrome that can be built from characters.
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        // method calling
        int result = longestPalindrome(s);
        // print output
        System.out.println("Longest Palindrome Length: " + result);
    }

    // method to find longest palindrome length
    public static int longestPalindrome(String s) {
        int oddCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        // count character frequencies
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            //track odd frequency count
            if (map.get(ch) % 2 == 1)
                oddCount++;
            else
                oddCount--;
        }
        //if more than one odd count, one odd char can be placed in center
        if (oddCount > 1)
            return s.length() - oddCount + 1;

        return s.length();
    }
}
