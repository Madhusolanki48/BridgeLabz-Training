package scenario_based;
import java.util.*;

public class StudentQuizGrader {
	public static void main(String[] args) {
		System.out.println("--------  Welcome to Student Quiz Grader  -------");
		System.out.println("-------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        //two String[] arrays
        String[] correctAnswers = {"A","C","B","D","A","B","C","A","D","B"};
        String[] studentAnswers = new String[10];

        System.out.println("Quiz starts — Enter Your Answers (A/B/C/D)");
        //user input
        for (int i = 0; i < 10; i++) {
            System.out.print("Question " + (i+1) + ": ");
            studentAnswers[i] = sc.nextLine();
        }

        System.out.println("--------------  Quiz Feedback  ----------------");
        //detailed feedback
        for (int i = 0; i < 10; i++) {
            if (studentAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                System.out.println("Question " + (i+1) + ": Correct");
            } else {
                System.out.println("Question " + (i+1) + ": Incorrect (Correct: "
                                     + correctAnswers[i] + ")");
            }
        }
        //method calling
        int score = calculateScore(correctAnswers, studentAnswers);
        //percentage score and pass/fail message
        double percentage = (score / 10.0) * 100;
        System.out.println("\n------------------------------------------------");
        System.out.println("\nFinal Score: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 50)
            System.out.println("Status: PASS");
        else
            System.out.println("Status: FAIL");
    }
	//method to calculate total score
    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;
        for (int i = 0; i < correct.length; i++) {
        	//string comparison with .equalsIgnoreCase() for case-insensitive matching
            if (student[i].equalsIgnoreCase(correct[i])) { 
                score++;
            }
        }
        return score;
    }

    
}
