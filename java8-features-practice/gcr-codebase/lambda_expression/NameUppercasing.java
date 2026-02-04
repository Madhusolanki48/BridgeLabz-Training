package lambda_expression;
import java.util.*;

public class NameUppercasing {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("maxwell", "ronald", "andrew");

        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }
}

