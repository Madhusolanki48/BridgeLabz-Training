package regex;
import java.util.*;

public class UsernameValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a username: ");
        String username = sc.nextLine();
        //given:starts with letter, allows letters/digits/_, length 5–15
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";
        if(username.matches(regex)) {
            System.out.println(username+" is a Valid username!");
        } else {
            System.out.println(username+ "is an Invalid username!");
        }

    }
}
