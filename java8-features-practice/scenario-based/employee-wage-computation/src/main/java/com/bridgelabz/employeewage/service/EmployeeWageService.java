package com.bridgelabz.employeewage.service;
import java.util.Random;
import com.bridgelabz.employeewage.model.Employee;

//handles attendance logic
public class EmployeeWageService {

	private static final int IS_PRESENT = 1;
	private static final int WAGE_PER_HOUR = 20;
	private static final int FULL_DAY_HOUR = 8;
	private static final int PART_TIME = 2;
	private static final int PART_TIME_HOUR = 8;
	private static final int FULL_TIME = 1;
	private static final int MAX_WORKING_DAYS = 20;
	private static final int MAX_WORKING_HOURS = 100;
	private final Random random = new Random();

	public Employee checkAttendance() {
		int check = random.nextInt(2);
		return new Employee(check == IS_PRESENT, 0, 0);
	}

	//UC-2:calculate daily wage for employee
	public Employee calculateDailyWage() {

		Employee emp = checkAttendance();

		int hours = emp.isPresent() ? FULL_DAY_HOUR : 0;
		int wage = hours * WAGE_PER_HOUR;

		return new Employee(emp.isPresent(), hours, wage);
	}

//    //UC-3:calculate wage including part-time employee
//    public Employee calculateWageWithPartTime() {
//        int empCheck = random.nextInt(3); // 0,1,2
//        int hours = 0;
//        if (empCheck == FULL_TIME) {
//            hours = FULL_DAY_HOUR;
//        } else if (empCheck == PART_TIME) {
//            hours = PART_TIME_HOUR;
//        }
//
//        int wage = hours * WAGE_PER_HOUR;
//        return new Employee(hours > 0, hours, wage);
//    }
	//UC-4: Calculate wage using switch case
	public Employee calculateWageWithSwitch() {
		int empCheck = random.nextInt(3);
		int hours;
		String type;

		switch (empCheck) {
		    case FULL_TIME:
		        hours = FULL_DAY_HOUR;
		        type = "FULL_TIME";
		        break;
		    case PART_TIME:
		        hours = PART_TIME_HOUR;
		        type = "PART_TIME";
		        break;
		    default:
		        hours = 0;
		        type = "ABSENT";
		}

		int wage = hours * WAGE_PER_HOUR;
		return new Employee(hours > 0, hours, wage,type);
	}
	//UC-5: calculate monthly wage for 20 working days
	public int calculateMonthlyWage() {
	    int totalWage = 0;

	    //loop for 20 days
	    for (int day = 1; day <= 20; day++) {
	        Employee emp = calculateWageWithSwitch();
	        totalWage += emp.getDailyWage();
	    }

	    return totalWage;
	}

	//UC-6: calculate wage till max hours OR max days reached
	public int calculateWageTillCondition() {
		int totalHours = 0;
		int totalDays = 0;
		int totalWage = 0;

		//stop when either condition hits
		while (totalHours <= MAX_WORKING_HOURS && totalDays < MAX_WORKING_DAYS) {

			totalDays++;
			Employee emp = calculateWageWithSwitch();

			totalHours += emp.getWorkingHours();
			totalWage += emp.getDailyWage();
		}

		return totalWage;
	}

	//UC-7: compute employee wage using class method & class variables
	public int computeEmployeeWage() {

		int totalHours = 0;
		int totalDays = 0;
		int totalWage = 0;

		while (totalHours <= MAX_WORKING_HOURS && totalDays < MAX_WORKING_DAYS) {

			totalDays++;

			Employee emp = calculateWageWithSwitch();

			totalHours += emp.getWorkingHours();
			totalWage += emp.getDailyWage();
		}

		return totalWage;
	}

	//UC-8: compute wage for a company using function parameters
	public int computeEmployeeWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
		int totalHours = 0;
		int totalDays = 0;
		int totalWage = 0;

		System.out.println("\n--- Computing for " + companyName + " ---");

		while (totalHours <= maxWorkingHours && totalDays < maxWorkingDays) {

			totalDays++;

			int empCheck = random.nextInt(3);
			int hours;

			switch (empCheck) {
			case FULL_TIME:
				hours = FULL_DAY_HOUR;
				break;
			case PART_TIME:
				hours = PART_TIME_HOUR;
				break;
			default:
				hours = 0;
			}

			totalHours += hours;
			totalWage += hours * wagePerHour;
		}

		return totalWage;
	}

	//UC-9: compute wage using company object (instance variables)
	public void computeEmployeeWage(com.bridgelabz.employeewage.model.CompanyEmployeeWage company) {
		int totalHours = 0;
		int totalDays = 0;
		int totalWage = 0;
//		System.out.println("----------------------------------------");
//		System.out.println("\n--- Computing for " + company.getCompanyName() + " ---");
//		System.out.println("----------------------------------------");

		while (totalHours <= company.getMaxWorkingHours() && totalDays < company.getMaxWorkingDays()) {
			totalDays++;
			int empCheck = random.nextInt(3);
			int hours;

			switch (empCheck) {
			case FULL_TIME:
				hours = FULL_DAY_HOUR;
				break;
			case PART_TIME:
				hours = PART_TIME_HOUR;
				break;
			default:
				hours = 0;
			}

			totalHours += hours;
			totalWage += hours * company.getWagePerHour();
		}

		//UC-9 main requirement
		company.setTotalWage(totalWage);
	}

}
