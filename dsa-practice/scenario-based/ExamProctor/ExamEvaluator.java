package ExamProctor;
import java.util.*;

public class ExamEvaluator {
	//method to calculate score
	public static int calculateScore(HashMap<Integer, String> correctAnswers, HashMap<Integer, String> studentAnswers) {
		int score = 0;

		for (int qid : correctAnswers.keySet()) {
			String correct = correctAnswers.get(qid);
			String student = studentAnswers.getOrDefault(qid, "");

			if (student.equalsIgnoreCase(correct)) {
				score++;
			}
		}

		return score;
	}

	//method to print feedback
	public static void printFeedback(HashMap<Integer, String> correctAnswers, HashMap<Integer, String> studentAnswers) {
		System.out.println("\n------------------ Exam Feedback ------------------");
		for (int questionId : correctAnswers.keySet()) {
			String correct = correctAnswers.get(questionId);

			if (!studentAnswers.containsKey(questionId)) {
				System.out.println("Question " + questionId + ": Not Attempted (Correct: " + correct + ")");
				continue;
			}
			String student = studentAnswers.get(questionId);
			if (student.equalsIgnoreCase(correct))
				System.out.println("Question " + questionId + ": Correct");
			else
				System.out.println("Question " + questionId + ": Incorrect (Correct: " + correct + ")");
		}

		System.out.println("---------------------------------------------------");
	}
}
