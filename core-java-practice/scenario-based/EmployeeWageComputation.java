package scenario_based;
import java.util.Random;
public class EmployeeWageComputation {
    static final int wagePerHour = 20;  //assume wage per hour =20
    static final int fullDayWorkingHours = 8;  //full day hours =8
    static final int partTimeWorkingHours = 4; //part-time hours =4
    public static void main(String[] args) {
    	System.out.println("Welcome to Employee Wage Computation Program on Master Branch\n");
    // Use Case -2 : Compute Daily Employee Wage
            int dailyWage = wagePerHour * fullDayWorkingHours;
            System.out.println("Daily Employee Wage = ₹" + dailyWage + "\n");
    }
    // Use Case-1 : Check if employee is present or absent
    public static boolean isEmployeePresent() {
        Random random = new Random();
        return random.nextInt(2) == 1;
    }
    // Use Case -3 : Add Part time Employee & Wage
    public static int getEmployeeType() {
        return random.nextInt(2) + 1; // 1 = Part Time, 2 = Full Time
    }
    // Use Case-4 : Using Switch case, get working hours
    public static int getWorkingHours(int employeeType) {
        switch (employeeType) {
            case 1:
                return partTimeWorkingHours;
            case 2:
                return fullDayWorkingHours;
            default:
                return 0;
        }
    }   
}