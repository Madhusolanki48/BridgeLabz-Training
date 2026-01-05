package scenario_based;
import java.util.*;

class InvalidScoreException extends Exception {  //custom exception
    public InvalidScoreException(String message) {
        super(message);
    }
}
public class StudentScoreAnalyzer {

    //validate score range
    public static void validateScores(double[] scores) throws InvalidScoreException {
        for (double s : scores) {
            if (s < 0 || s > 100) {
                throw new InvalidScoreException("Invalid score detected: " + s +" (Score must be between 0 and 100)");
            }
        }
    }

    //calculate average of marks
    public static double calculateAverage(double[] scores) {
        double sum = 0;
        for (double s : scores) sum += s;
        return sum / scores.length;
    }

    //find highest marks
    public static double findMax(double[] scores) {
        double max = scores[0];
        for (double s : scores) if (s > max) max = s;
        return max;
    }

    //find lowest marks
    public static double findMin(double[] scores) {
        double min = scores[0];
        for (double s : scores) if (s < min) min = s;
        return min;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("----  Welcome to Student Score Analyzer  ----");
        System.out.println("---------------------------------------------");
        System.out.print("Enter number of students: ");
        int number = sc.nextInt();
        double[] scores = new double[number];
        System.out.println("\nEnter scores (0–100):");
        for (int i = 0; i < number; i++) {
            System.out.print("Score " + (i + 1) + ": ");
            scores[i] = sc.nextDouble();
        }
        try {
            //validation
            validateScores(scores);

            //calculations
            double avg = calculateAverage(scores);
            double highest = findMax(scores);
            double lowest = findMin(scores);
            System.out.println("\n------------ Score Summary ---------------");
            System.out.println("Average Score : " + avg);
            System.out.println("Highest Score : " + highest);
            System.out.println("Lowest Score  : " + lowest);
            System.out.println("\nScores Above Average:");
            for (double s : scores)
                if (s > avg) System.out.println(s);
        } catch (InvalidScoreException e) {
            System.out.println("\nError: " + e.getMessage());
        }

        System.out.println("\n------- Analysis Complete. Thank you! -------");
    }
}
