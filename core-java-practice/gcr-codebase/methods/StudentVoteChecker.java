package methods;
import java.util.Scanner;
public class StudentVoteChecker {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        //user input
        for(int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + " : ");
            ages[i] = sc.nextInt();
            //method call
            boolean canVote = canStudentVote(ages[i]);
            //display result
            if (canVote) {
                System.out.println("Student can vote !");
            } else {
                System.out.println("Student cannot vote !");
            }
        }
    }
	// method to check voting eligibility
    public static boolean canStudentVote(int age) {
        if (age < 0) {  //invalid age
            return false;
        }
        if (age >= 18) {
            return true;
        }
        return false;
    }
}
