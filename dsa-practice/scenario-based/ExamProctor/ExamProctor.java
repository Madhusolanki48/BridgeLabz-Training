package ExamProctor;
import java.util.*;

public class ExamProctor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<Integer> navigationStack = new Stack<>();  //stack to track question navigation
		HashMap<Integer, String> studentAnswers = new HashMap<>();  //map to store answers
		HashMap<Integer, String> correctAnswers = new HashMap<>();  //map for correct answers

		//correct answers
		correctAnswers.put(1, "A");
		correctAnswers.put(2, "B");
		correctAnswers.put(3, "C");
		correctAnswers.put(4, "D");
		correctAnswers.put(5, "A");

		System.out.println("--------- ExamProctor – Online Exam Review System ---------");
		System.out.println("-----------------------------------------------------------");

		while (true) {
			//user options
			System.out.println("\n1- Visit Question");
			System.out.println("2- Submit Answer");
			System.out.println("3- Go Back (Last Visited Question)");
			System.out.println("4- Submit Exam");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter Question ID (1-5): ");
				int questionId = sc.nextInt();
				sc.nextLine();

				navigationStack.push(questionId);
				System.out.println("Question visited successfully: " + questionId);
				System.out.println("----------------------------------------------------------");
				break;

			case 2:
				System.out.print("Enter Question ID: ");
				int question = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Answer (A/B/C/D): ");
				String answer = sc.nextLine();

				studentAnswers.put(question, answer);
				System.out.println("Answer saved for Question " + question);
				System.out.println("----------------------------------------------------------");
				break;

			case 3:
				if (navigationStack.isEmpty()) {
					System.out.println("Stack Underflow! No navigation history.");
					System.out.println("----------------------------------------------------------");
				} else {
					int last = navigationStack.pop();
					System.out.println("Went back from Question " + last);

					if (!navigationStack.isEmpty())
						System.out.println("Now at Question " + navigationStack.peek());
					else
						System.out.println("No active question now!");

					System.out.println("----------------------------------------------------------");
				}
				break;

			case 4:
				System.out.println("Submitting exam...");
				System.out.println("----------------------------------------------------------");

				//attempt summary
				System.out.println("Questions Attempted: " + studentAnswers.size() + "/5");

				//feedback function calling
				ExamEvaluator.printFeedback(correctAnswers, studentAnswers);

				//score function calling
				int score = ExamEvaluator.calculateScore(correctAnswers, studentAnswers);
				double percentage = (score / 5.0) * 100;

				System.out.println("Exam submitted successfully!");
				System.out.println("Final Score: " + score + "/5");
				System.out.println("Percentage: " + percentage + "%");

				if (percentage >= 50)
					System.out.println("Status: PASS");
				else
					System.out.println("Status: FAIL");

				System.out.println("----------------------------------------------------------");
				System.out.println("Thank you for using ExamProctor!");
				return;

			default:
				System.out.println("Invalid choice! Please try again.");
				System.out.println("----------------------------------------------------------");
			}
		}
	}
}
