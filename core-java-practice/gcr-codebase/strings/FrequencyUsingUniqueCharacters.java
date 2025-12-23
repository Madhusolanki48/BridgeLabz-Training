package strings;
import java.util.Scanner;
public class FrequencyUsingUniqueCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a string : ");
        String text = sc.nextLine();
        //method call
        String[][] result = findFrequency(text);
        //display result
        for (int i = 0; i < result.length; i++) {
            if (result[i][0] != null) {
                System.out.println("Frequency of character " +result[i][0] +" is " +
                    result[i][1]);
            }
        }
    }
    //method to find unique characters in a string using charAt and nested loops
    public static char[] findUniqueCharacters(String text) {
        int len = text.length();
        char[] unique = new char[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            //nested loop
            for (int j = 0; j < i; j++) {
                if (ch == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[index++] = ch;
            }
        }
        return unique;
    }
    //method to find frequency and return result in 2D array
    public static String[][] findFrequency(String text) {
        int[] freq = new int[256]; // ASCII frequency array
        //count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        //unique characters
        char[] uniqueChars = findUniqueCharacters(text);
        //2D array to store character and its frequency
        String[][] table = new String[uniqueChars.length][2];
        //store unique characters and their frequencies
        for (int i = 0; i < uniqueChars.length; i++) {
            if (uniqueChars[i] != '\0') {
                table[i][0] = String.valueOf(uniqueChars[i]);
                table[i][1] = String.valueOf(freq[uniqueChars[i]]);
            }
        }
        return table;
    }
}
