package scenario_based;
import java.util.Random;
public class EmployeeWageComputation {
    public static void main(String[] args) {
    	System.out.println("Welcome to Employee Wage Computation Program on Master Branch\n");
    }  
    // Use Case-1 : Check if employee is present or absent
    public static boolean isEmployeePresent() {
        Random random = new Random();
        return random.nextInt(2) == 1;
    }
}