package methods;
import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //array to store data
        double[][] personData = new double[10][3];
        String[] status = new String[10];
        System.out.println("Enter Weight(in kg) and Height(in cm) for 10 persons:");
        for (int i = 0; i < 10; i++) {
            personData[i][0] = sc.nextDouble();  // weight
            personData[i][1] = sc.nextDouble();  // height
        }
        calculateBMI(personData);
        status = getBMIStatus(personData);
        //print result
        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s%n",
                    personData[i][1],
                    personData[i][0],
                    personData[i][2],
                    status[i]);
        }
    }
    //method to calculate BMI and store in column 2
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;   //cm to meter
            double bmi = weight / (heightM * heightM);  //given
            data[i][2] = bmi;   //BMI in column 3
        }
    }
    //method to determine BMI status
    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi <= 18.4)
                status[i] = "Underweight";
            else if (bmi <= 24.9)
                status[i] = "Normal";
            else if (bmi <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }
        return status;
    }
}

