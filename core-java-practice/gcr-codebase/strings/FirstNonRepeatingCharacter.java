package strings;
import java.util.Scanner;
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a string : ");
        String text = sc.nextLine();
        //method call 
        char result = firstNonRepeatingCharacter(text);
        // print result
        System.out.println("First non-repeating character in the string is : " + result);
    }
    //method to find first non-repeating character
    public static char firstNonRepeatingCharacter(String str) {
        //array to store characters
        int[] freq = new int[256];
        //counting frequency of each character
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        //first character with frequency one
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) //using charAt method
                return str.charAt(i);
        }
        //if nothing found
        return '\0';  //return null
    }
}

