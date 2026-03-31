package json;

public class ValidateEmail {
    public static void main(String[] args) {
        //email value
        String email = "max@gmail.com";

        //simple validation
        if (email.contains("@") && email.contains(".")) {
            System.out.println("Valid Email");
        } else {
            System.out.println("Invalid Email");
        }
    }
}
