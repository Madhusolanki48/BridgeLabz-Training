package leet_code_codebase;
import java.util.Scanner;
public class ReverseWordsInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a sentence: ");
        String s = sc.nextLine();
        // method call
        String result = reverseWords(s);
        //print result
        System.out.println("Sentence with Reversed words: " + result);
    }
    //method to reverse the order of words in a given string
    public static String reverseWords(String s) {
        //trim and split string into words
        String[] words = s.trim().split("\\s+");
        String reversed = "";
        //traverse from last word to first
        for (int i = words.length - 1; i > 0; i--) {
            reversed = reversed + words[i] + " ";
        }
        // add first word with no trailing spaces
        return reversed + words[0];
    }
}

