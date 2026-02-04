package lambda_expression;
import java.util.*;
import java.util.function.Predicate;

public class NotificationFilter {
    public static void main(String[] args) {

        List<String> alerts = Arrays.asList(
                "Emergency Alert",
                "Medicine Reminder",
                "Appointment Reminder"
        );

        //show only emergency alerts
        Predicate<String> emergencyOnly =
                alert -> alert.contains("Emergency");

        alerts.stream()
              .filter(emergencyOnly)
              .forEach(System.out::println);
    }
}

