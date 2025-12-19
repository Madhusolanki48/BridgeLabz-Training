package control_flows;
import java.util.Scanner;
public class RoacketLaunchCountdownFor {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int count = sc.nextInt();
        for (int i = count; i > 0; i--) {
            System.out.println(i);
        }
    }
}
