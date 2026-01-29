package regex;
import java.util.Scanner;
import java.util.regex.*;

public class CapitalWordExtractor {
    public static void main(String[] args) {
    	//user input
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();
        //word starting with capital letter
        Matcher m = Pattern.compile("\\b[A-Z][a-z]*\\b").matcher(text);

        while (m.find()) {                  //find words
            System.out.println(m.group());  
        }

    }
}

