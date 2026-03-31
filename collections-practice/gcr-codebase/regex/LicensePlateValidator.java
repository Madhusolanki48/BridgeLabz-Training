package regex;
import java.util.*;

public class LicensePlateValidator {
    public static void main(String[] args) {
    	//user input
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter a License Plate Number: ");
        String plate = sc.nextLine();         

        //given: 2 uppercase letters + 4 digits
        System.out.println(plate.matches("^[A-Z]{2}\\d{4}$"));
    }
}

