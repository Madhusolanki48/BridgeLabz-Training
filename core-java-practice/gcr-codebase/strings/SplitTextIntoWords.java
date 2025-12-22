package strings;
import java.util.Scanner;
public class SplitTextIntoWords {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String text = sc.nextLine();
        //split using charAt method created
        String[] wordsArray1 = splitUsingCharAt(text);
        //split using built-in split method
        String[] wordsArray2 = text.split(" ");
        //compare both word arrays
        boolean result = compareArrays(wordsArray1, wordsArray2);
        //print output
        System.out.println("Both the splits are same ? " + result);
    }

    //method to split string using charAt method
    public static String[] splitUsingCharAt(String text) {
        int wordCount = 1;
        //count number of words
        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == ' ')
                wordCount++;
        String[] words = new String[wordCount];
        int index = 0;
        String word = "";
   
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words[index++] = word;
                word = "";
            } else {
                word += text.charAt(i);
            }
        }

        //store last word
        words[index] = word;
        return words;
    }
    //method to compare two string arrays
    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) {// check array length
            return false;
        }
        // compare each word
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }
        return true;
    }

}
