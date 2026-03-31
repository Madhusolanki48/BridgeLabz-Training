package regex;
import java.util.*;

public class HexColorValidator {
    public static void main(String[] args) {
    	//user input
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter a Hex Code: ");
        String color = sc.nextLine();         

        //given: # followed by 6 hex characters
        System.out.println(color.matches("^#[0-9A-Fa-f]{6}$"));

    }
}

