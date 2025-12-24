package methods;
import java.util.*;
public class UnitConvertor3 {
	//methods
	public static double farhenheitToCelsius(double farhenheit) {
		double celsius = (farhenheit - 32) * 5 / 9;
		return celsius; 
	}
	public static double celsiusToFarhenheit(double celcius) {
		double farhenheit = (celcius * 9 / 5) + 32;
		return farhenheit;
	}
	public static double poundsToKilograms(double pounds) {
		return pounds*0.453592;
	}
	public static double kilogramsToPounds(double kg) {
		return kg*2.20462;
	}
	public static double gallonsToLiters(double gallons) {
		return gallons*3.78541;
	}
	public static double litersToGalllons(double liters) {
		return liters*0.264172;
	}
}
