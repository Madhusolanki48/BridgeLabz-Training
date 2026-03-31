package regex;
import java.util.regex.*;

public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org";
        //regex: http or https links
        Matcher m = Pattern.compile("https?://\\S+").matcher(text);
        System.out.println("Links in the given input: ");
        while (m.find()) {   //find links
            System.out.println(m.group());
        }
    }
}

