package strings;
import java.util.Scanner;
public class SplitStringSmallestLongestWords {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();
        //method calls
        String[] wordsArray = splitTextIntoWords(text);
        String[][] wordLengthTable = createWordLengthTable(wordsArray);
        String[] result = findShortestAndLongest(wordLengthTable);
        //print output
        System.out.println("Shortest word in the sentence is: " + result[0]);
        System.out.println("Longest word in the sentence is: " + result[1]);
    }
    //method to find length without using length()
    public static int calculateLength(String text) {
        int index = 0;
        try {  //code containing exception
            while (true) {
                text.charAt(index);
                index++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            
        }
        return index;
    }
    //method to count words in text
    public static int getWordCount(String text) {
        int count = 0;
        for (int i = 0; i < calculateLength(text); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }
        return count + 1;
    }
    //method to split text into words using charAt()
    public static String[] splitTextIntoWords(String text) {
        int totalWords = getWordCount(text);
        String[] words = new String[totalWords];
        int pos = 0;
        String temp = "";
        int len = calculateLength(text);

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words[pos++] = temp;
                temp = "";
            } else {
                temp += text.charAt(i);
            }
        }
        words[pos] = temp;
        return words;
    }
    //create 2D array for word and their length
    public static String[][] createWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(calculateLength(words[i]));
        }
        return table;
    }
    //find shortest and longest words
    public static String[] findShortestAndLongest(String[][] table) {
        int minLen = Integer.MAX_VALUE;
        int maxLen = 0;
        String minWord = "";
        String maxWord = "";

        for (int i = 0; i < table.length; i++) {
            int len = Integer.parseInt(table[i][1]);

            if (len > maxLen) {
                maxLen = len;
                maxWord = table[i][0];
            }
            if (len < minLen) {
                minLen = len;
                minWord = table[i][0];
            }
        }
        return new String[]{minWord, maxWord};
    }
}

