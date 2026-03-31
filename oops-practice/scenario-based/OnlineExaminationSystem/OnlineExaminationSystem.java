package OnlineExaminationSystem;
import java.util.ArrayList;
import java.util.Scanner;
//main class
public class OnlineExaminationSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//exam list
		ArrayList<Exam> exams = new ArrayList<>();
		ArrayList<Student> students = new ArrayList<>();
		System.out.println("----  Welcome to Online Examination System  ----");

		while (true) {
			System.out.println("\n----------- Home Page -----------");
			System.out.println("1. Create Exam");
			System.out.println("2. View Exams");
			System.out.println("3. Enroll Student");
			System.out.println("4. View Students");
			System.out.println("5. Submit Answers (Take Exam)");
			System.out.println("6. Generate Result");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			if (choice == 0) {
				System.out.println("Thank you for Giving Exam!");
				break;
			}
			switch (choice) {
			//CRUD Operations 
			case 1:  //create Exam
				System.out.print("\nEnter Exam Id: ");
				int examId = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Exam Title: ");
				String title = sc.nextLine();
				System.out.print("Enter Duration (in minutes): ");
				int duration = sc.nextInt();
				Exam exam = new Exam(examId, title, duration);
				System.out.print("Enter number of questions: ");
				int qCount = sc.nextInt();
				sc.nextLine();

				for (int i = 1; i <= qCount; i++) {
					System.out.println("\nQuestion " + i);
					System.out.print("Enter Question Id: ");
					int qId = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter Question Text: ");
					String qText = sc.nextLine();

					System.out.println("Select Question Type:");
					System.out.println("1. Objective");
					System.out.println("2. Descriptive");
					System.out.print("Enter type: ");
					int type = sc.nextInt();
					sc.nextLine();

					if (type == 1) {
						System.out.print("Enter Correct Answer: ");
						String correct = sc.nextLine();
						exam.addQuestion(new ObjectiveQuestion(qId, qText, correct));
					} else {
						System.out.print("Enter Model Answer (for reference): ");
						String model = sc.nextLine();
						exam.addQuestion(new DescriptiveQuestion(qId, qText, model));
					}
				}

				exams.add(exam);
				System.out.println("\nExam Created Successfully!");
				break;
			case 2:    //CRUD-read exams
				System.out.println("\n----- Available Exams -----");
				if (exams.size() == 0) {
					System.out.println("No exams created yet!");
				} else {
					for (Exam e : exams)
						System.out.println(e);
				}
				break;
			case 3:  //CRUD-create student enrollment
				System.out.print("\nEnter Student Id: ");
				int sid = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Student Name: ");
				String sname = sc.nextLine();
				Student st = new Student(sid, sname);
				students.add(st);

				System.out.println("\nStudent Enrolled Successfully!");
				break;
			case 4:   //CRUD-read students
				System.out.println("\n----- Enrolled Students -----");
				if (students.size() == 0) {
					System.out.println("No students enrolled yet!");
				} else {
					for (Student s : students)
						System.out.println(s);
				}
				break;
			//Answer Submission
			case 5:
				if (exams.size() == 0 || students.size() == 0) {
					System.out.println("\nPlease create exam and enroll student first!");
					break;
				}
				System.out.print("\nEnter Student Id: ");
				int studentId = sc.nextInt();
				sc.nextLine();
				Student selectedStudent = null;
				for (Student s : students) {
					if (s.getId() == studentId) {
						selectedStudent = s;
						break;
					}
				}

				if (selectedStudent == null) {
					System.out.println("Invalid Student Id!");
					break;
				}
				System.out.print("Enter Exam Id to attempt: ");
				int attemptExamId = sc.nextInt();
				sc.nextLine();
				Exam selectedExam = null;
				for (Exam e : exams) {
					if (e.getId() == attemptExamId) {
						selectedExam = e;
						break;
					}
				}

				if (selectedExam == null) {
					System.out.println("Invalid Exam Id!");
					break;
				}

				System.out.print("Enter time taken (minutes): ");
				int timeTaken = sc.nextInt();
				sc.nextLine();

				try {
					selectedExam.checkExamTime(timeTaken);

					System.out.println("\n----- Start Exam: " + selectedExam.getTitle() + " -----");

					for (Question q : selectedExam.getQuestions()) {
						System.out.println("\nQ" + q.getQuestionId() + ". " + q.getQuestionText());
						System.out.print("Your Answer: ");
						String ans = sc.nextLine();
						selectedStudent.submitAnswer(selectedExam.getId(), q.getQuestionId(), ans);
					}

					System.out.println("\nAnswers Submitted Successfully!");

				} catch (ExamTimeExpiredException e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;

			//Result Generation
			case 6:
				System.out.print("\nEnter Student Id: ");
				int sIdRes = sc.nextInt();

				System.out.print("Enter Exam Id: ");
				int examIdRes = sc.nextInt();

				Student resultStudent = null;
				for (Student s : students) {
					if (s.getId() == sIdRes) {
						resultStudent = s;
						break;
					}
				}

				Exam resultExam = null;
				for (Exam e : exams) {
					if (e.getId() == examIdRes) {
						resultExam = e;
						break;
					}
				}

				if (resultStudent == null || resultExam == null) {
					System.out.println("Invalid Student/Exam Id!");
					break;
				}

				//Evaluation Strategy (Polymorphism)
				EvaluationStrategy strategy = new MixedEvaluation();
				double score = strategy.evaluate(resultExam, resultStudent);
				System.out.println("\nResult Generated Successfully!");
				System.out.println("Student: " + resultStudent.getName());
				System.out.println("Exam: " + resultExam.getTitle());
				System.out.println("Score: " + score + "/" + resultExam.getTotalMarks());
				break;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}
