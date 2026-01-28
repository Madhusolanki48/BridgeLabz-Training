package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 1941
// Check if all characters in a string have the same frequency.
public class EqualCharacterOccurrences {
    public static void main(String[] args) {
        String s = "abacbc";
        //method calling
        boolean result = areOccurrencesEqual(s);
        //print output
        if (result)
            System.out.println("All characters have equal occurrences");
        else
            System.out.println("Characters do not have equal occurrences");
    }

    //method to check equal occurrences
    public static boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        //count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int freq = -1;
        //check if all frequencies are same
        for (int count : map.values()) {
            if (freq == -1)
                freq = count;
            else if (count != freq)
                return false;
        }
        return true;
    }
}
