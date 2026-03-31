package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 884
// Find uncommon words from two sentences using HashMap.

public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        //method calling
        String[] result = uncommonFromSentences(s1, s2);
        //print output
        System.out.println("Uncommon Words: " + Arrays.toString(result));
    }

    //method to find uncommon words
    public static String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        //split sentences into words
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        //count frequency from first sentence
        for (String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //count frequency from second sentence
        for (String word : words2) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //collect words with frequency 1
        ArrayList<String> list = new ArrayList<>();
        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                list.add(word);
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
