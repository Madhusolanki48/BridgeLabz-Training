package functional_interface;
import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {

        //function takes String and returns its length
        Function<String, Integer> lengthChecker = msg -> msg.length();

        String message = "Hello Java";

        //apply() executes the function
        int length = lengthChecker.apply(message);

        System.out.println("Message length: " + length);
    }
}

