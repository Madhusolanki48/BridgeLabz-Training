package scenario_based;
import java.util.Random;
public class EmployeeWageComputation {
    static final int wagePerHour = 20;  //assume wage per hour =20
    static final int fullDayWorkingHours = 8;  //full day hour =8
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
    
}