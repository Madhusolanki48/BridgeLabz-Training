package arrays;
import java.util.Scanner;
public class ZaraBonusNSalary {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //array size initialization
        double[] salary = new double[10];
        double[] yearOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        
        //take salary and year of service input from the user
        for (int i = 0; i < 10; i++) {
        	System.out.println("Enter details for Employee " + (i + 1));

            System.out.print("Salary: ");
            double sal = sc.nextDouble();
            System.out.print("Years of Service: ");
            double yrs = sc.nextDouble();
            //salary can't be 0/-ve or year of service shouldn't be -ve
            if (sal <= 0 || yrs < 0) {
                System.out.println("Invalid input. Re-enter.");
                i--;
                continue;
            }

            salary[i] = sal;
            yearOfService[i] = yrs;
        }
        //bonus and new salary calculation
        for (int i = 0; i < 10; i++) {
            if (yearOfService[i] > 5)
                bonus[i] = salary[i] * 0.05;
            else
                bonus[i] = salary[i] * 0.02;

            newSalary[i] = salary[i] + bonus[i];

            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
            
            totalBonus += bonus[i];
        }
        //print output
        System.out.printf("Total Bonus Payout = %.2f%n", totalBonus);
        System.out.printf("Total Old Salary of All Employees = %.2f%n", totalOldSalary);
        System.out.printf("Total New Salary of All Employees = %.2f%n", totalNewSalary);
    }

}
