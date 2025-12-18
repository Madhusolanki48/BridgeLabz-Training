import java.util.Scanner;
class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //taking input of three numbers from user
        System.out.println("Enter first number : ");
        double a = sc.nextDouble();
        System.out.println("Enter second number : ");
        double b = sc.nextDouble();
        System.out.println("Enter third number : ");
        double c = sc.nextDouble();
        //Formula for average of three numbers
        double avg = (a + b + c) / 3;
        System.out.println("The average of the three numbers : "+ avg);
    }
}

