package scenario_based;
import java.util.Random;
public class EmployeeWageComputation {
    static final int wagePerHour = 20;  //assume wage per hour =20
    static final int fullDayWorkingHours = 8;  //full day hours =8
    static final int partTimeWorkingHours = 4; //part-time hours =4
    static Random random = new Random();
    public static void main(String[] args) {
    	System.out.println("Welcome to Employee Wage Computation Program on Master Branch\n");
    // Use Case -2 : Compute Daily Employee Wage
            int dailyWage = wagePerHour * fullDayWorkingHours;
            //System.out.println("Daily Employee Wage = " + dailyWage + " Rupees \n");
            int totalWorkingDays = 0;
            int totalWorkingHours = 0;
    //Use Case-5 : Calculating Wages for a month (20 Working Days)
    // Use Case-6 : Calculate Wages till a condition of total working hours or days is reached for a month - Assume 100 hours & 20 days
            int totalWage = 0;
            System.out.println("-----------------------------------------------------------------");
            System.out.printf("%-8s %-12s %-15s %-12s %-10s\n","Day", "Status", "EmployeeType", "Hours", "Wage(in Rupees)");
            System.out.println("-----------------------------------------------------------------");
            while (totalWorkingDays < 20 && totalWorkingHours < 100) {  //replaced for loop of 20 days wage calc with while loop
                totalWorkingDays++;
                if (!isEmployeePresent()) {
                    System.out.printf("%-8d %-12s %-15s %-12s %-10s\n",totalWorkingDays, "Absent", "-", "-", "-");
                    continue;
                }
                int employeeType = getEmployeeType();
                int workingHours = getWorkingHours(employeeType);

                if (totalWorkingHours + workingHours > 100) {
                workingHours = 100 - totalWorkingHours;
                }
                totalWorkingHours += workingHours;
                int wagePerDay = workingHours * wagePerHour;
                totalWage += wagePerDay;
                //print output
                System.out.printf("%-8d %-12s %-15s %-12d %-10d\n",totalWorkingDays,"Present",
                (employeeType == 1 ? "Part-Time" : "Full-Time"),workingHours,wagePerDay);
            }
            System.out.println("--------------------------------------------------------------");
            //monthly summary of an employee
            System.out.println("\n------------------ Monthly Report Generated ------------------");
            System.out.printf("%-22s : %d\n", "Total Working Days", totalWorkingDays);
            System.out.printf("%-22s : %d\n", "Total Working Hours", totalWorkingHours);
            System.out.printf("%-22s : %d\n", "Total Monthly Wage", totalWage);
            System.out.println("--------------------------------------------------------------");
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