package scenario_based;
import java.util.*;

public class StudentTestScoreManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Student Test Score Manager");
        System.out.println("---------------------------------------------");
        //user input
        System.out.print("Enter number of students: ");
        int number = sc.nextInt();

        //array to store the scores of n students
        double[] scores = new double[number];

        System.out.println("\nEnter student scores:");
        for (int i = 0; i < number; i++) {
            while (true) {
                System.out.print("Score " + (i + 1) + ": ");
                //handle invalid input like negative scores or non-numeric input
                if (!sc.hasNextDouble()) {
                    System.out.println("Invalid input! Enter a numeric value.");
                    sc.next();
                    continue;
                }

                double score = sc.nextDouble();

                if (score < 0) { //for negative values
                    System.out.println("Score cannot be negative. Re-enter.");
                    continue;
                }

                scores[i] = score;
                System.out.println("Score saved!\n");
                break;
            }
        }

        double sumofScores = 0, highestScore = scores[0], lowestScore = scores[0];

        //for highest and lowest scores
        for (double sum : scores) {
            sumofScores += sum;
            if (sum > highestScore)
                highestScore = sum;
            if (sum < lowestScore)
                lowestScore = sum;
        }

        double average = sumofScores / number;  //calculate and display the average score.

        System.out.println("\n------------ Score Summary ---------------");
        System.out.println("Average Score : " + average);
        System.out.println("Highest Score : " + highestScore);
        System.out.println("Lowest Score  : " + lowestScore);

        //display the scores above the average
        System.out.println("\nScores Above Average:");
        for (double sum : scores) {
            if (sum > average) System.out.println(sum);
        }

        System.out.println("\n----- Analysis Complete. Thank you! -----");
    }
}
