package methods;
import java.util.Scanner;
public class CollinearPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // user input
        System.out.print("Enter x1 y1 : ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        System.out.print("Enter x2 y2 : ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        System.out.print("Enter x3 y3 : ");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();
        //method calls
        boolean slopeResult = isCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean areaResult  = isCollinearByArea(x1, y1, x2, y2, x3, y3);
        //display results
        System.out.println("Are the points Collinear using slope formula ? : " + slopeResult);
        System.out.println("Are the points Collinear using slope formula ? : " + areaResult);
    }
    //method to find collinearity using slope formula
    public static boolean isCollinearBySlope(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {
        //compare cross multiplied slopes
        double v1 = (y2 - y1) * (x3 - x1);
        double v2 = (y3 - y1) * (x2 - x1);
        return v1 == v2;
    }
    //method to find collinearity using area of triangle
    public static boolean isCollinearByArea(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {
        double area = 0.5 * (x1 * (y2 - y3) +x2 * (y3 - y1) +x3 * (y1 - y2));
        return area == 0.0;  //collinear
    }
}
