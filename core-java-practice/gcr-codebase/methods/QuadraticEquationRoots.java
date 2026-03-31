package methods;
import java.util.Scanner;
public class QuadraticEquationRoots {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter value of a: ");
        double a = sc.nextDouble();
        System.out.print("Enter value of b: ");
        double b = sc.nextDouble();
        System.out.print("Enter value of c: ");
        double c = sc.nextDouble();
        //method call
        double[] roots = findRoots(a, b, c);
        //display result
        if (roots.length == 0) {
            System.out.println("No real roots exists !");
        }
        else if (roots.length == 1) {
            System.out.println("One root of the given quadratic equation : " + roots[0]);
        }
        else {
            System.out.println("One root of given quadratic equation : " + roots[0]);
            System.out.println("Other root of given quadratic equation : " + roots[1]);
        }
    }
    //method to find roots of ax^2 + bx + c = 0
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta < 0) {  //no real roots
            return new double[0];
        }
        if (delta == 0) {  //one root
            double root = -b / (2 * a);
            return new double[]{root};
        }
        //two real roots (delta > 0)
        double root1 = (-b + Math.sqrt(delta)) / (2 * a);
        double root2 = (-b - Math.sqrt(delta)) / (2 * a);
        return new double[]{root1, root2};
    }
}

