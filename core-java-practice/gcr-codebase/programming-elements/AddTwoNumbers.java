import java.util.Scanner;
class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //taking input values of two numbers from user
        System.out.println("Enter first number : ");
        int a=sc.nextInt();
        System.out.println("Enter second number : ");
        int b=sc.nextInt();
        //sum of two numbers
        int sum=a+b;
        System.out.println("Sum of the two numbers : "+ sum);
    }  
}
