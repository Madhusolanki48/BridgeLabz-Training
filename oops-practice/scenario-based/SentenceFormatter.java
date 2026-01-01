package scenario_based;
import java.util.*;
public class SentenceFormatter {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a paragraph: ");
		String paragraph=sc.nextLine();
		//method calling
		String result=sentenceFormatter(paragraph);
		//print output
		System.out.println("Formatted sentence after auto-correcting: "+result);
	}
	//method to auto-correct formatting by fixing spacing & capitalizing first letter of each sentence.
	public static String sentenceFormatter(String s) {
        if (s == null || s.trim().isEmpty())
        	return "";
        //normalize spaces
        s= s.trim().replaceAll("\\s+", " ");
        //one space after punctuation
        s = s.replaceAll("\\s*([.!?])\\s*", "$1 ");
        //capitalize first letter of paragraph
        s = s.substring(0,1).toUpperCase() + s.substring(1);
        //capitalize letter after punctuation
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;
        for (char ch : s.toCharArray()) {
            if (capitalizeNext && Character.isLetter(ch)) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }

            if (ch == '.' || ch == '?' || ch == '!') {
                capitalizeNext = true;   
            }
        }
        return result.toString().trim();
    }

}
