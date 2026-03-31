package regex;
public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
    	//input 
        String text = "This is an  example with  multiple spaces.";
        //replace multiple spaces with single space
        System.out.println(text.replaceAll("\\s+", " "));
    }
}

