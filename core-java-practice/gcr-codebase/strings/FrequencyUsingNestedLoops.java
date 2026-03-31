package strings;
import java.util.Scanner;
public class FrequencyUsingNestedLoops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a string : ");
        String text = sc.nextLine();
        //method call 
        String[] result = findFrequency(text);
        // display result
        for (int i = 0; i < result.length; i++) {
            if (result[i] != null) {
                System.out.println(result[i]);
            }
        }
    }
    //method to find frequency using nested loops
    public static String[] findFrequency(String text) {
        //string to character array
        char[] chars = text.toCharArray();
        int length = chars.length;
        //store frequency of each character
        int[] freq = new int[length];
        //nested loops to calculate frequency
        for (int i = 0; i < length; i++) {
            if (chars[i] == '0')
                continue;
            freq[i] = 1;

            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; //duplicate
                }
            }
        }
        //store result in 1D array
        String[] result = new String[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                result[index++] ="Frequency of character " + chars[i] + " is " + freq[i];
            }
        }
        return result;
    }
}
