package control_flows;
import java.util.Scanner;
public class BonusOfEmployees {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the salary of an employee : ");
        double salary = sc.nextDouble();
        System.out.print("Enter the year of service of the employee : ");
        int yearOfService= sc.nextInt();
        //checking bonus criteria
        if (yearOfService > 5) {
        	//bonus calculation
            double bonusAmount = salary * 0.05;
            System.out.println("Bonus amount = " + bonusAmount);
        } else {
            System.out.println("No bonus");
        }
    }
}
