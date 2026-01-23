package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 387
// Find the index of the first non-repeating character in a string using HashMap.

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // user input
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        // method calling
        int result = firstUniqChar(s);
        // print output
        if (result != -1)
            System.out.println("First unique character index: " + result);
        else
            System.out.println("No unique character found");
    }

    //method to find first unique character using HashMap
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        //count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //first index whose frequency is 1
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
