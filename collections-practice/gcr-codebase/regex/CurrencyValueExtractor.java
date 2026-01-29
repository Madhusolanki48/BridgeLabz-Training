package regex;
import java.util.regex.*;

public class CurrencyValueExtractor {
    public static void main(String[] args) {
    	//input 
        String text = "Price is $45.99 and discount is 10.50";
        //regex: currency values
        Matcher m = Pattern.compile("\\$?\\d+\\.\\d{2}").matcher(text);
        System.out.println("Currency Values in the given input: ");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}

