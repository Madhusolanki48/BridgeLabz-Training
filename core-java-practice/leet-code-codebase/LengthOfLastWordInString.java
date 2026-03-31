package leet_code_codebase;
import java.util.Scanner;
public class LengthOfLastWordInString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        //take user input
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        //method call
        int result = lastWordLength(str);
        // print result
        System.out.println("Length of last word in the string : " + result);
    }
    static int lastWordLength(String s) {
        s = s.trim();   //remove leading and trailing spaces
        int count = 0;
        //go through each character
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                count = 0;   //reset count if space is found
            } else {
                count++;     //count characters of current word
            }
        }
        return count;
    }

}
