package strings;
import java.util.Scanner;
public class IsAnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter first text : ");
        String text1 = sc.nextLine();
        System.out.print("Enter second text : ");
        String text2 = sc.nextLine();
        //method call 
        boolean result = isAnagram(text1, text2);
        //print result
        if (result)
            System.out.println("The given two texts are Anagrams !");
        else
            System.out.println("The given two texts are NOT Anagrams !");
    }
    //method to check if two texts are anagrams
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())  // are their lengths equal
            return false;
        //frequency arrays for ASCII characters
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        //find frequency of characters in first text
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i)]++;
        }
        //find frequency of characters in second text
        for (int i = 0; i < s2.length(); i++) {
            freq2[s2.charAt(i)]++;
        }
        //compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }
        return true;
    }
}

