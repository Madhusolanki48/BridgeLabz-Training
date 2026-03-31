package map_interface;
import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String filePath) {
        Map<String, Integer> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", " "); //remove punctuation

                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        map.put(word, map.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return map;
    }

    public static void main(String[] args) {
        String filePath = "src/map_interface/input.txt"; // create input.txt in your project folder
        System.out.println("Word Frequency: " + countWordFrequency(filePath));
    }
}
