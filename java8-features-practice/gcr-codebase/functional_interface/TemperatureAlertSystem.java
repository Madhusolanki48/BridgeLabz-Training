package functional_interface;
import java.util.function.Predicate;

public class TemperatureAlertSystem {
    public static void main(String[] args) {

        //predicate to check if temperature crosses threshold
        Predicate<Double> isHighTemp = temp -> temp > 37.5;

        double currentTemp = 38.2;

        //test temperature and alert
        if (isHighTemp.test(currentTemp)) {
            System.out.println("Alert! High temperature");
        } else {
            System.out.println("Normal Temperature!");
        }
    }
}

