package methods;
import java.util.*;
public class BonusCalculator {
    public static void main(String[] args) {
        double[][] empData = generateEmployeeData();
        double[][] bonusData = calculateBonus(empData);
        displaySummary(empData, bonusData);
    }
    //method to generate salary & years of service
    public static double[][] generateEmployeeData() {
        double[][] emp = new double[10][2];
        for (int i = 0; i < 10; i++) {
            int salary = (int)(Math.random() * 90000) + 10000;   // 5-digit salary
            int yearOfExperience  = (int)(Math.random() * 11);              // 0-10 years

            emp[i][0] = salary;
            emp[i][1] = yearOfExperience;
        }
        return emp;
    }
    //method to calculate bonus & new salary
    public static double[][] calculateBonus(double[][] emp) {
        double[][] result = new double[10][2];
        for (int i = 0; i < 10; i++) {

            double salary = emp[i][0];
            double yearOfExperience  = emp[i][1];
            double bonus;
            //5% bonus if service > 5 years, else 2%
            if (yearOfExperience > 5)
                bonus = salary * 0.05;
            else
                bonus = salary * 0.02;
            double newSalary = salary + bonus;
            result[i][0] = bonus;
            result[i][1] = newSalary;
        }
        return result;
    }

    //method to display table & totals
    public static void displaySummary(double[][] emp, double[][] bonusData) {
        double totalOld = 0;
        double totalNew = 0;
        double totalBonus = 0;
        System.out.println("\n            Zara's Company Bonus Data");
        
        System.out.printf("%-6s %-12s %-10s %-12s %-12s\n",
                "EmpID", "Old Salary", "Years", "Bonus", "New Salary");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < 10; i++) {

            double salary = emp[i][0];
            double years  = emp[i][1];
            double bonus  = bonusData[i][0];
            double newSal = bonusData[i][1];

            totalOld  += salary;
            totalBonus += bonus;
            totalNew  += newSal;
            System.out.printf("%-6d %-12.2f %-10.0f %-12.2f %-12.2f\n",
                    (i+1), salary, years, bonus, newSal);
        }
        System.out.println("-------------------------------------------------------------");
        System.out.printf("TOTAL   %-12.2f %-10s %-12.2f %-12.2f\n",
                totalOld, "-", totalBonus, totalNew);
    }
}
