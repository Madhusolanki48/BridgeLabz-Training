package strings;
import java.util.Scanner;
public class CanStudentVote {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students : ");
        int n = sc.nextInt();
        //array to store ages of number of students
        int[] ages = generateRandomAges(n);
        String[][] result = isStudentEligibleToVote(ages);
        showResult(result);
    }
    //random 2 digit ages generated
    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = (int)(Math.random() * 90);
        }
        return ages;
    }
    // check voting eligibility
    public static String[][] isStudentEligibleToVote(int[] ages) {
        String[][] table = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            table[i][0] = String.valueOf(ages[i]);

            if (ages[i] >= 18)
                table[i][1] = "true";
            else
                table[i][1] = "false";
        }
        return table;
    }

    //tabular format data
    public static void showResult(String[][] table) {
        System.out.println("Age \tCan Vote");
        for (String[] row : table) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }
}
