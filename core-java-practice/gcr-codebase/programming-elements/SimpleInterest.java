import java.util.Scanner;
class simpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Principle amount : ");
        double p = sc.nextDouble();
        System.out.println("Enter rate of interest : ");
        double r = sc.nextDouble();
        System.out.println("Enter time period : ");
        double t = sc.nextDouble();
        //Simple Interest formula
        double si = (p * r * t) / 100;
        System.out.println("The calculated SI : "+si);
    }
}


