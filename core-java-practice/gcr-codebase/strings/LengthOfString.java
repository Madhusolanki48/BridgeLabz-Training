package strings;
import java.util.Scanner;
public class LengthOfString {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.next();
        //length using method created
        int length1 = findLength(str);
        //length using built-in method
        int length2= str.length();
        //print output
        System.out.println("Length determined by method created : " + length1);
        System.out.println("Length determined by built-in method : " + length2);
    }

    public static int findLength(String str) {
        int count = 0;
        try {   //code containing exception
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (RuntimeException e) {
            return count;
        }
    }
}
