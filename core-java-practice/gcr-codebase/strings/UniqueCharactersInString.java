package strings;
import java.util.Scanner;
public class UniqueCharactersInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //take user input
        System.out.print("Enter a String : ");
        String text = sc.nextLine();
        //find unique characters
        char[] unique = findUniqueCharacters(text);
        //print output
        System.out.print("Unique characters in the string are : ");
        for (char ch : unique) {
            if (ch != '\0')
                System.out.print(ch + " ");
        }
    }
    //method to calculate length of string without using in built method
    public static int findLengthOfString(String text) {
        int length = 0;
        for (char c : text.toCharArray()) {
            length++;
        }
        return length;
    }
    //method to find unique characters in string
    public static char[] findUniqueCharacters(String text) {
        int length = findLengthOfString(text);
        char[] temp = new char[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;

            //check if character appeared before
            for (int j = 0; j < i; j++) {
                if (ch == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique)
                temp[index++] = ch;
        }
        return temp;
    }
}
