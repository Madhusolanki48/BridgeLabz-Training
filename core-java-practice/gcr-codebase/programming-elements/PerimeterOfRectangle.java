import java.util.Scanner;
class PerimeterOfRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of rectangle : ");
        double l = sc.nextDouble();
        System.out.println("Enter the width of rectangle : ");
        double w = sc.nextDouble();
        //Perimeter of Rectangle
        double perimeter = 2 * (l + w);
        System.out.println("The perimeter of the rectangle : "+perimeter);
    }
}

