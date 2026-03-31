package java_streams;
import java.io.*;
import java.util.*;

public class CountWordsInFile {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/java_streams/source.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty())
                        map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //sort by frequency
        map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(5)
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }
}

