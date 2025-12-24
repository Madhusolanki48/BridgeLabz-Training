package methods;
import java.util.Scanner;
public class WindChillTemperature {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter the temperature : ");
		double temperature=sc.nextDouble();
		System.out.print("Enter the wind speed : ");
		double windSpeed=sc.nextDouble();
		//method call
		double result=calculateWindChill(temperature,windSpeed);
		//print result
		System.out.printf("Calculted wind chill temperature is = %.02f ",result);
		
	}
	//method to calculate the wind chill temperature using the formula
	public static double calculateWindChill(double temperature, double windSpeed) {
		//formula given
		double windChill = 35.74 + 0.6215 *temperature + (0.4275*temperature - 35.75) * Math.pow(windSpeed,0.16);
		return windChill;
	}

}
