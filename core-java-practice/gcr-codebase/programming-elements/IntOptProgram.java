import java.util.Scanner;
public class IntOptProgram {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a : ");
        int a = sc.nextInt(); // input a
        System.out.println("Enter the value of b : ");
        int b = sc.nextInt(); // input b
        System.out.println("Enter the value of c : ");
        int c = sc.nextInt(); // input c
        int res1 = a + b * c;   // precedence: *
        int res2 = a * b + c;   // precedence: *
        int res3 = c + a / b;   // precedence: /
        System.out.println("The results of Int Operations are " + res1 + ", " + res2 + ", and " + res3);
    }

}
