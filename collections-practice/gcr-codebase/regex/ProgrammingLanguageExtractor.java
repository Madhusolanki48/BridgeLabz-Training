package regex;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {
    public static void main(String[] args) {
    	//input 
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        //regex: programming language names
        Matcher m = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b").matcher(text);
        System.out.println("The programming languages in the given input: ");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}

