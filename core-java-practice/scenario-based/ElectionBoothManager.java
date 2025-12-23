package scenario_based;
import java.util.Scanner;
public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("     Welcome to Election Booth    ");
        System.out.println("---------------------------------");
        while (true) {
        	//take age input from user
            System.out.print("Enter your age or 0 to exit voting : ");
            int age = sc.nextInt();
            //special exit condition
            if (age == 0) {
                System.out.println("Polling has ended !");
                break;
                }
            //check eligibility to vote
            if (age >= 18) {
                System.out.println("You are eligible to vote!");
                //show candidates output
                System.out.println("\nCandidates List:");
                System.out.println("1️ Candidate A");
                System.out.println("2️ Candidate B");
                System.out.println("3️ Candidate C");

                //vote choice input from user
                System.out.print("Please enter your choice (1/2/3): ");
                int vote = sc.nextInt();

                //validate vote
                if (vote == 1 || vote == 2 || vote == 3) {
                    System.out.println("Vote successfully recorded. Thank you for voting !");
                } else {
                    System.out.println("Invalid choice | Vote not recorded.");
                }
            } else {
                System.out.println("Sorry, you are not eligible to vote !");
                }
        }
    }
}

