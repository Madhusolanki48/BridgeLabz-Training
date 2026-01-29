package regex;
import java.util.Scanner;

public class CreditCardValidator {
	public static void main(String[] args) {
        //user input
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter a card number: ");
        String card = sc.nextLine();        
        if (isValidVisa(card)) {
            System.out.println(card+"is a Valid Visa Card");
        } else if (isValidMasterCard(card)) {
            System.out.println(card+"is a Valid MasterCard");
        } else {
            System.out.println(card+"ia an Invalid Card");
        }
    }
	//method to validate cards
    //check Visa card- starts with 4 and has 16 digits
    public static boolean isValidVisa(String card) {
        return card.matches("^4\\d{15}$");
    }

    //check MasterCard- starts with 5 and has 16 digits
    public static boolean isValidMasterCard(String card) {
        return card.matches("^5\\d{15}$");
    }

}

