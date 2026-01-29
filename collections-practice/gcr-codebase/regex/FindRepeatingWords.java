package regex;
import java.util.regex.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
    	//input 
        String text = "This is is a repeated repeated word test";
        //regex: repeated consecutive words
        Matcher m = Pattern.compile("\\b(\\w+)\\s+\\1\\b").matcher(text);
        System.out.println("The repeated consecutive words in the given input: ");
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}


