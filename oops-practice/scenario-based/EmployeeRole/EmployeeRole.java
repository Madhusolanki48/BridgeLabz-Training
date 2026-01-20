package EmployeeRole;
import java.util.*;

public class EmployeeRole {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------- Employee Bonus Calculator ---------");
		System.out.println("---------------------------------------------");

		while (true) {

			System.out.println("\nChoose Employee Role:");
			System.out.println("1- Manager");
			System.out.println("2- Developer");
			System.out.println("3- Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			if (choice == 3) {
				System.out.println("---------------------------------------------");
				System.out.println("System Closed. Thank you!");
				System.out.println("---------------------------------------------");
				return;
			}

			System.out.print("Enter Employee Name: ");
			String name = sc.nextLine();

			System.out.print("Enter Salary: ");
			double salary = sc.nextDouble();
			sc.nextLine();

			Employee emp = null;

			if (choice == 1) {
				emp = new Manager(name, salary);
				System.out.println("Manager profile created.");
			}
			else if (choice == 2) {
				emp = new Developer(name, salary);
				System.out.println("Developer profile created.");
			}
			else {
				System.out.println("Invalid choice!");
				continue;
			}

			System.out.println("---------------------------------------------");
			System.out.printf("Bonus Amount: %.2f%n", emp.getBonus());
			System.out.println("---------------------------------------------");
		}
	}
}
