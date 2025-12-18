import java.util.Scanner;
public class DoubleOptProgram {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a : ");
        double a = sc.nextDouble(); // input a
        System.out.println("Enter the value of b : ");
        double b = sc.nextDouble(); // input b
        System.out.println("Enter the value of c : ");
        double c = sc.nextDouble(); // input c
        double res1 = a + b * c;      // multiplication first
        double res2 = a * b + c;
        double res3 = c + a / b;
        System.out.printf(
            "The results of Double Operations are %.2f, %.2f, and %.2f",res1, res2, res3);
    }
}
