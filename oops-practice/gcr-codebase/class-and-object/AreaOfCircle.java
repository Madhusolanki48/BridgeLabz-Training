package class_and_object;
// Class representing a Circle
class Circle {
    private double radius;   //attribute

    //constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    //method to calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    //method to calculate circumference
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    //method to display results
    public void display() {
        System.out.printf("Area of circle: %.4f\n", getArea());
        System.out.printf("Circumference of circle: %.4f\n", getCircumference());
    }
}

public class AreaOfCircle {
    public static void main(String[] args) {
        Circle c = new Circle(2.5);
        c.display();
    }
}
