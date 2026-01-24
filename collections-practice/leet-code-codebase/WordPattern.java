package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 290
// Check if a string follows the same pattern using HashMap and HashSet.

public class WordPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter pattern string: ");  //abba
        String pattern = sc.nextLine();
        System.out.print("Enter sentence: ");  //dog cat cat dog
        String s = sc.nextLine();
        //method calling
        boolean result = wordPattern(pattern, s);
        // print output
        if (result)
            System.out.println("String follows the pattern");
        else
            System.out.println("String does NOT follow the pattern");
    }

    //method to check word pattern
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        String[] words = s.split(" ");
        //length mismatch
        if (pattern.length() != words.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!words[i].equals(map.get(ch)))
                    return false;
            } 
            else {
                //ensure one-to-one mapping
                if (set.contains(words[i]))
                    return false;
                map.put(ch, words[i]);
                set.add(words[i]);
            }
        }

        return true;
    }
}
