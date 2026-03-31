package regex;
import java.util.regex.*;

public class DateExtractor {
    public static void main(String[] args) {
    	//input
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        //regex: dd/mm/yyyy format
        Matcher m = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(text);
        System.out.println("The dates in the given input: ");
        while (m.find()) {   //find dates
            System.out.println(m.group());
        }
    }
}

