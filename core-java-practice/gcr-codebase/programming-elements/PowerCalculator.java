import java.util.Scanner;
class PowerCalculator {  //without using loops or conditionals
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base value : ");
        double base = sc.nextDouble();
        System.out.println("Enter the exponent value : ");
        double exp = sc.nextDouble();
        //base^exponent expression
        double result = Math.pow(base, exp);
        System.out.println("The value of base raised to exponent : "+result);
    }
}
