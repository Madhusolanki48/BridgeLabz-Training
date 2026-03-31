package leet_code_codebase;
import java.util.*;
import java.util.stream.*;
// LeetCode Problem: 1491
// Find average salary excluding min and max using Java 8.

public class AverageSalaryUsingStreams {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// user input
		System.out.print("Enter number of employees: ");
		int n = sc.nextInt();

		int[] salary = new int[n];
		System.out.println("Enter salary values:");

		for (int i = 0; i < n; i++) {
			salary[i] = sc.nextInt();
		}
		// method calling
		double result = average(salary);
		System.out.printf("Average salary (excluding min & max): %.2f%n", result);

	}

	// Java 8 method
	public static double average(int[] salary) {

		IntSummaryStatistics stats = Arrays.stream(salary).summaryStatistics();

		return (double) (stats.getSum() - stats.getMin() - stats.getMax()) / (salary.length - 2);
	}
}