package scenario_based;
import java.util.*;

class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String s) {
        super(s);
    }
}

public class OnlineQuizPlatformExecptionHandling {
	//method to calculate scores
    public static int calculateScore(String[] correct, String[] student) throws InvalidQuizSubmissionException {
        if (correct.length != student.length)  //validate input (length mismatch)
            throw new InvalidQuizSubmissionException("Answer length mismatch! All 10 questions must be answered.");
        int score = 0;
        System.out.println("\n--------------- Quiz Feedback ----------------");
        for (int i = 0; i < correct.length; i++) {  
            if (student[i].equalsIgnoreCase(correct[i])) {  //comparing scores
                System.out.println("Question " + (i+1) + ": Correct");
                score++;
            } else {
                System.out.println("Question " + (i+1) +": Incorrect (Correct: " + correct[i] + ")");
            }
        }
        return score;
    }
    //method to return grades
    public static String getGrade(double percentage) {
        if (percentage >= 80)
        	return "A";
        else if (percentage >= 60)
        	return "B";
        else if (percentage >= 40)
        	return "C";
        else
        	return "Fail";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //list to store correct answers for comparison
        String[] correctAnswers = {"A","C","B","D","A","B","C","A","D","B"};
        //list to store scores of multiple users
        List<Integer> scores = new ArrayList<>();
        System.out.println("---------  Online Quiz Result Processor  ---------");
        while (true) {
            String[] studentAnswers = new String[10];
            System.out.println("\nEnter Your Answers (A/B/C/D):");
            for (int i = 0; i < 10; i++) {
                System.out.print("Question " + (i+1) + ": ");
                studentAnswers[i] = sc.nextLine();
            }
            try {
                int score = calculateScore(correctAnswers, studentAnswers);
                scores.add(score);
                double percentage = (score / 10.0) * 100;
                String grade = getGrade(percentage);
                //print result
                System.out.println("\n------------------ Result ------------------");
                System.out.println("Final Score : " + score + "/10");
                System.out.println("Percentage  : " + percentage + "%");
                System.out.println("Grade       : " + grade);
                System.out.println("---------------------------------------------");

            } catch (InvalidQuizSubmissionException e) {
                System.out.println("\n Error: " + e.getMessage());
            }

            System.out.print("\nEnter answers for another student? (yes/no): ");
            String again = sc.nextLine();
            if (!again.equalsIgnoreCase("yes"))
                break;
        }

        System.out.println("\nScores of all students: " + scores);
        System.out.println("Thank you for using the Quiz Result Processor.");
    }
}
