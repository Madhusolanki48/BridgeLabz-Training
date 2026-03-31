package strings;
import java.util.Scanner;
public class CharacterType {  //vowel, consonant or not a letter
	//method to analyze each character & its type
	public static String[][] analyzeCharacters(String text) {
		//2D array to store character and its type
        String[][] table = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            table[i][0] = String.valueOf(ch);  //character
            table[i][1] = determineType(ch);   //character type
        }
        return table;
    }
	//method to determine the character type
    public static String determineType(char ch) {
    	//upper case to lower case
    	if (ch >= 'A' && ch <= 'Z') {
    	    ch = (char) (ch + 32);
    	}
    	//vowel or consonant
    	if (ch >= 'a' && ch <= 'z') {
    	    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
    	        return "Vowel";
    	    else
    	        return "Consonant";
    	}
    	// not a letter
        return "Not a Letter";
    }

}
