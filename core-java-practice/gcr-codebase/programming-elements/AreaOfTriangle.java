import java.util.Scanner;
public class AreaOfTriangle {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the base of traingle in cm : ");
	        double base = sc.nextDouble();    // base in cm
	        System.out.println("Enter the height of traingle in cm : ");
	        double height = sc.nextDouble();    // height in cm
	        double areaCm = 0.5 * base * height;         // area in sq cm
	        double baseInch = base / 2.54;    // cm to inch
	        double heightInch = height / 2.54;  // cm to inch
	        double areaInches = 0.5 * baseInch * heightInch; // area in sq inches
	        System.out.printf("The area of the triangle in square inches is %.2f and in square centimeters is %.2f",
	            areaInches, areaCm
	        );
	    }
}
