package methods;
import java.util.Scanner;
public class EuclideanDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter x1 y1 : ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        System.out.print("Enter x2 y2 : ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        //method calls
        double distance = getEuclideanDistance(x1, y1, x2, y2);
        double[] lineEq  = getLineEquation(x1, y1, x2, y2);
        double m = lineEq[0];   // slope
        double b = lineEq[1];   // y-intercept
        //print output
        System.out.println("\nEuclidean Distance = " + distance);
        System.out.println("Slope (m)          = " + m);
        System.out.println("Y-Intercept (b)    = " + b);
        System.out.println("Equation of Line   :  y = " + m + " * x + " + b);

    }

    //method to find Euclidean distance between two points
    public static double getEuclideanDistance(
            double x1, double y1,
            double x2, double y2) {

        double part1 = Math.pow((x2 - x1), 2);
        double part2 = Math.pow((y2 - y1), 2);

        return Math.sqrt(part1 + part2);
    }

    //method to find equation of line (slope and intercept)
    public static double[] getLineEquation(
            double x1, double y1,
            double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - (m * x1);

        double[] result = new double[2];
        result[0] = m;
        result[1] = b;

        return result;
    }
}