package strings;
import java.util.Scanner;
public class SplitStringWithWordsLengthCount2D {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String text = sc.nextLine();
        //split sentence into words
        String[] words = splitUsingCharAt(text);
        //2D array for words and their length
        String[][] table = buildWordLengthTable(words);
        System.out.println("Word\tLength");  //table header
        for (String[] row : table)
        	//each word with its length
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
    }
	//method to create 2D array of word and length
    public static String[][] buildWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
        	
            table[i][0] = words[i];   //word
            table[i][1] = String.valueOf(findLength(words[i]));   //length
        }
        return table;
    }
    //method to find length using charAt
    public static int findLength(String text) {
        int count = 0;
        try {   //code containing exception
        	//count characters until exception occurs
            while (true) {
                text.charAt(count++);
            }
        } catch (RuntimeException e) {
            return count - 1;
        }
    }
    //method to split string into words
    public static String[] splitUsingCharAt(String text) {
        return text.split(" ");
    }
}
