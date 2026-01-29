package regex;
import java.util.regex.*;

public class EmailExtractor {
    public static void main(String[] args) {
    	//input example
        String text = "Contact us at support@example.com and info@company.org";
        //regex for email pattern
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}");
        Matcher matcher = pattern.matcher(text);
        System.out.println("The emails in the given input: ");
        while (matcher.find()) {  //find all matches
            System.out.println(matcher.group());
        }
    }
}


