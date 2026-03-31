package leet_code_codebase;
import java.util.Scanner;
public class ReverseAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        //string to char array
        char[] s = str.toCharArray();
        // method call
        reversedString(s);
        //print output
        System.out.println("Reversed string: " + new String(s));
    }
    //method to reverse the string
    public static void reversedString(char[] s) {
    	int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];  // store left character
            s[i] = s[j];       // copy right to left
            s[j] = temp;       // copy temp to right

            i++;
            j--;
        }
    }
}

