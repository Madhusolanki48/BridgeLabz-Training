package regex;
public class CensorBadWords {
    public static void main(String[] args) {
    	//input 
        String text = "This is a damn bad example with some stupid words";
        //Replace bad words with ****
        System.out.println(text.replaceAll("\\b(damn|stupid)\\b", "****"));
    }
}
