package control_flows;
import java.util.Scanner;
public class RocketLaunchCountdownWhile {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");  //the number by which countdown starts
        int counter = sc.nextInt();
        //using a while loop 
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
    }
}
