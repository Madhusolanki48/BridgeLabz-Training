package methods;
import java.util.Scanner;
public class StudentScoreCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of students : ");
        int number = sc.nextInt();
        int[][] marks = generatePCMScores(number);
        double[][] result = calculateResults(marks);
        displayScoreCard(marks, result);
    }

    //method to generate random 2-digit PCM marks (2D Array)
    public static int[][] generatePCMScores(int n) {
        int[][] scores = new int[n][3]; // 0-Physics 1-Chem 2-Maths
        for (int i = 0; i < n; i++) {
            scores[i][0] = (int)(Math.random() * 50) + 50; // Physics
            scores[i][1] = (int)(Math.random() * 50) + 50; // Chemistry
            scores[i][2] = (int)(Math.random() * 50) + 50; // Maths
        }
        return scores;
    }

    //method to calculate Total, Average, Percentage
    public static double[][] calculateResults(int[][] marks) {
        double[][] res = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg  = total / 3.0;          
            double perc = (total / 300.0) * 100;
            // round off to 2 digits
            avg  = Math.round(avg * 100.0) / 100.0;
            perc = Math.round(perc * 100.0) / 100.0;
            res[i][0] = total;
            res[i][1] = avg;
            res[i][2] = perc;
        }
        return res;
    }
    //method to display Scorecard in Table format
    public static void displayScoreCard(int[][] marks, double[][] res) {
        System.out.println("\n                        Student Scorecard");
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf(" %-5s | %-7s | %-9s | %-8s | %-7s | %-9s | %-11s \n",
                "S.No.", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf(" %-5d | %-7d | %-9d | %-8d | %-7.0f | %-9.2f | %-11.2f \n",
                    (i+1),marks[i][0],marks[i][1],marks[i][2],res[i][0],res[i][1],res[i][2]);
        }
        System.out.println("----------------------------------------------------------------------------");
    }
}

