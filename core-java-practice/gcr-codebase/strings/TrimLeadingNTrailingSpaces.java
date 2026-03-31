package strings;
import java.util.Scanner;
public class TrimLeadingNTrailingSpaces {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String text = sc.nextLine();
        int[] index = findTrimIndexes(text);
        
        String trimUsingMethodCreated = createSubstring(text,index[0],index[1]);
        String trimUsingBuiltInMethod = text.trim();

        boolean result = compareStrings(trimUsingMethodCreated, trimUsingBuiltInMethod);
        //print output
        System.out.println("Trimmed String using method created : " + trimUsingMethodCreated);
        System.out.println("Trimmed String using built-in method : " + trimUsingBuiltInMethod);
        System.out.println("Are both the strings same ? : " + result);
    }

    //find start and end index
    public static int[] findTrimIndexes(String str) {
        int startIndex = 0;
        int endIndex = str.length() - 1;

        while (str.charAt(startIndex) == ' ')
        	startIndex++;
        while (str.charAt(endIndex) == ' ')
        	endIndex--;

        return new int[]{startIndex, endIndex + 1};
    }

    // method to create substring using charAt
    public static String createSubstring(String str, int startIndex, int endIndex) {
        String res = "";
        for (int i = startIndex; i < endIndex; i++) {
            res += str.charAt(i);
        }
        return res;
    }
    //method to compare both strings
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length())
        	return false;

        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i))
            	return false;

        return true;
    }

}
