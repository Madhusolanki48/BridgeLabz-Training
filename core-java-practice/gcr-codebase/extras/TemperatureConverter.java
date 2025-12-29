package extras;
import java.util.Scanner;
public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.println("Temperature Converter: ");
        System.out.print("Choose option (1 for Celsius to Fahrenheit) or (2 for Fahrenheit to Celsius) : ");
        int ch = sc.nextInt();
        if (ch == 1) {
            System.out.print("Enter Celsius : ");
            double c = sc.nextDouble();
            System.out.println("Fahrenheit = " + celsiusToFahrenheit(c));
        } else if(ch == 2){
            System.out.print("Enter Fahrenheit : ");
            double f = sc.nextDouble();
            System.out.println("Celsius = " + fahrenheitToCelsius(f));
        }
    }
    //method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double c) {
    	return (c * 9/5) + 32;
    }
    //method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double f) {
    	return (f - 32) * 5/9;
    }
}

