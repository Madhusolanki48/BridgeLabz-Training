package strings;
import java.util.Scanner;
public class GradeAndPercentage {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students : ");
        int n = sc.nextInt();
        int[][] scores = generateRandomScores(n);
        String[][] result = calculateTotalResult(scores);
        displayStudentResult(result);
    }
    //mathos to generate random Physics, Chemistry and Maths scores
    public static int[][] generateRandomScores(int n) {
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            scores[i][0] = 40 + (int)(Math.random() * 60);
            scores[i][1] = 40 + (int)(Math.random() * 60);
            scores[i][2] = 40 + (int)(Math.random() * 60);
        }
        return scores;
    }
    //calculate total, average, percentage, grade
    public static String[][] calculateTotalResult(int[][] scores) {
        String[][] table = new String[scores.length][6];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double percent = Math.round((total / 3.0) * 100) / 100.0;

            table[i][0] = String.valueOf(scores[i][0]);
            table[i][1] = String.valueOf(scores[i][1]);
            table[i][2] = String.valueOf(scores[i][2]);
            table[i][3] = String.valueOf(total);
            table[i][4] = String.valueOf(percent);
            table[i][5] = grade(percent);
        }
        return table;
    }
    //method to determine grades
    public static String grade(double percent) {
        if (percent >= 90) return "A";
        if (percent >= 75) return "B";
        if (percent >= 60) return "C";
        return "D";
    }
    //method to display Student result
    public static void displayStudentResult(String[][] table) {
    	System.out.println("\nTotal Percentage Grade in PCM\n");
        for (int i = 0; i < table.length; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics Marks : " + table[i][0]);
            System.out.println("Chemistry Marks : " + table[i][1]);
            System.out.println("Maths Marks : " + table[i][2]);
            System.out.println("Total Marks : " + table[i][3]);
            System.out.println("Percentage : " + table[i][4]);
            System.out.println("Grade : " + table[i][5]);
            System.out.println();
        }
    }

}
