package arrays;
import java.util.Scanner;
public class CanStudentVote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] studentAge = new int[10];
        // taking input of ages for 10 students
        System.out.print("Enter the age of a student : ");
        for (int i = 1; i < studentAge.length; i++) {
            studentAge[i] = sc.nextInt();
        }
        // voting eligibility
        for (int i = 0; i < studentAge.length; i++) {

            if (studentAge[i] < 0) {   // age entered is a negative number
                System.out.println("Invalid age");
            } 
            else if (studentAge[i] >= 18) {
                System.out.println("The student with the age " + studentAge[i] + " can vote.");
            } 
            else {
                System.out.println("The student with the age " + studentAge[i] + " cannot vote.");
            }
        }
    }
}
