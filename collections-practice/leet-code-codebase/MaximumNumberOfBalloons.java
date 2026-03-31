package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 1189
// Find maximum number of times the word "balloon" can be formed.

public class MaximumNumberOfBalloons {
    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        // method calling
        int result = maxNumberOfBalloons(text);
        // print output
        System.out.println("Maximum number of balloons: " + result);
    }

    //method to calculate maximum number of balloons
    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        // count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // minimum count among required characters
        int min = Math.min(map.getOrDefault('b', 0),
        		Math.min(map.getOrDefault('a', 0),
        		Math.min(map.getOrDefault('n', 0),
        		Math.min(map.getOrDefault('l', 0) / 2,
        		map.getOrDefault('o', 0) / 2))));
        return min;
    }
}
