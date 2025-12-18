 import java.util.Scanner;
class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of circle : ");
        double r = sc.nextDouble();
        //area of circle
        double area = Math.PI * r * r;
        System.out.println("Area of the circle : "+area);
    }
}

    
