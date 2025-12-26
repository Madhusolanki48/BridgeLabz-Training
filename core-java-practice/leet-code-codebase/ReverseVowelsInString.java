package leet_code_codebase;
import java.util.Scanner;
public class ReverseVowelsInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        //method call
        String result = reverseVowels(str);
        //print output
        System.out.println("String after reversing vowels: " + result);
    }
    public static String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";
        while (start < end) {
            //move start to next vowel
            while (start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }

            //move end to previous vowel
            while (start < end && vowels.indexOf(word[end]) == -1) {
                end--;
            }
            //swap vowels
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;

            start++;
            end--;
        }
        return new String(word);
    }
}

