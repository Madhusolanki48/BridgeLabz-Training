package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 804
// Count unique Morse code representations of words.
public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        // method calling
        int result = uniqueMorseRepresentations(words);
        // print output
        System.out.println("Number of unique Morse representations: " + result);
    }
    //method to count unique Morse representations
    public static int uniqueMorseRepresentations(String[] words) {
        String[] alphabet = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> uniqueRepresentations = new HashSet<>();
        for (String word : words) {
            StringBuilder morse = new StringBuilder();
            for (char ch : word.toCharArray()) {
                morse.append(alphabet[ch - 'a']);
            }
            uniqueRepresentations.add(morse.toString());
        }
        return uniqueRepresentations.size();
    }
}
