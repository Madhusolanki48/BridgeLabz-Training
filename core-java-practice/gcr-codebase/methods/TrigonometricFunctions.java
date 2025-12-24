package methods;
import java.util.Scanner;
public class TrigonometricFunctions {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter an angle (in degree) : ");
		double angle=sc.nextDouble();
		//method call
		double[] result=calculateTrigonometricFunctions(angle);
		//print output
		System.out.printf("Sine function : %.2f\n",result[0]);
		System.out.printf("Cosine function : %.2f\n",result[1]);
		System.out.printf("Tangent function : %.2f",result[2]);
		
	}
	//method to calculate various trigonometric functions
	public static double[] calculateTrigonometricFunctions(double angle) {
		//degree to radian conversion
		double angleInRadians=Math.toRadians(angle);
		double sine=Math.sin(angleInRadians);
		double cosine=Math.cos(angleInRadians);
		double tangent=Math.tan(angleInRadians);
		return new double[] {sine,cosine,tangent};
	}

}
