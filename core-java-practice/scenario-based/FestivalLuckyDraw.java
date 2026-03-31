package scenario_based;
import java.util.Scanner;
public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------Welcome to Diwali Mela------");
        while (true) {
        	//user input with exit condition
            System.out.print("Enter your lucky number (or -1 to exit): ");
            if (!sc.hasNextInt()) {  //loop for invalid number
                System.out.println("Invalid input! Please enter a number.");  //output on invalid input
                sc.next();   //clears invalid input
                continue;
            }
            int num = sc.nextInt();
            if (num == -1) break;
            //If the number is divisible by 3 and 5, they win a gift.
            if (num % 3 == 0 && num % 5 == 0) {
                System.out.println("Congratulations! You win a gift!");
            } else {
                System.out.println("Better luck next time!");
            }
        }
        System.out.println("Lucky Draw session closed !");
    }
}

