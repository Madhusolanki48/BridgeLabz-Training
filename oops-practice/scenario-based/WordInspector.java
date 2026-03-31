package scenario_based;
import java.util.Scanner;

public class WordInspector {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a paragraph: ");
        String paragraph = sc.nextLine();
        if (paragraph.trim().isEmpty()) {  //handle spaces
            System.out.println("Paragraph is empty. Nothing to analyze.");
            return;
        }
        System.out.print("Enter the word to replace: ");
        String actualWord = sc.nextLine();
        System.out.print("Enter the new word: ");
        String newWord = sc.nextLine();
        System.out.println("\n--- Analysis Result ---");
        System.out.println("Word Count = " + countWords(paragraph));
        System.out.println("Longest Word is " + longestWord(paragraph));
        //user input
        String updatedText = replaceWordIgnoreCase(paragraph, actualWord, newWord);
        System.out.println("Updated Paragraph: " + updatedText);
    }
	//method to count the number of words in the paragraph
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) return 0;
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
    //method to find and display the longest word
    public static String longestWord(String text) {
        if (text == null || text.trim().isEmpty()) return "";

        String longest = "";
        for (String word : text.split("\\s+")) {
            word = word.replaceAll("[^a-zA-Z]", ""); // remove punctuation
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
    //method to replace all occurrences of a specific word with another word (case-insensitive)
    public static String replaceWordIgnoreCase(String text, String actualWord, String newWord) {
        if (text == null)
        	return "";
        return text.replaceAll("(?i)\\b" + actualWord + "\\b", newWord);
    }
}

