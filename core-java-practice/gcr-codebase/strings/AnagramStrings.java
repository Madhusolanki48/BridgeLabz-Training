package extras;
import java.util.Scanner;
public class AnagramStrings {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter first text: ");
        String text1 = sc.next();
        System.out.print("Enter second text: ");
        String text2 = sc.next();
        //print output
        if (isAnagram(text1, text2)) {
            System.out.println("The given strings are Anagrams.");
        } else {
            System.out.println("The given strings are noT Anagrams.");
        }
    }
    //method to check if two strings are anagrams
    public static boolean isAnagram(String text1, String text2) {
        if (text1.length()!=text2.length()) {
            return false;
        }
        //frequency arrays
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        //frequency of characters
        for (int i=0;i<text1.length();i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }
        //compare frequencies
        for (int i=0; i<256;i++) {
            if (freq1[i]!=freq2[i]) {
                return false;
            }
        }
        return true;
    }
}