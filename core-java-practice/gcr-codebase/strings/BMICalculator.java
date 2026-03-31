package strings;
import java.util.*;
public class BMICalculator{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//input from user
		System.out.print("Enter number of students : ");
		int n=sc.nextInt();
		int[][] studentInfo=new int[n][2];
		//input weight and height of students
		for(int i=0;i<studentInfo.length;i++) {
			System.out.print("Enter height of person "+(i+1)+" in (cm) :");
			studentInfo[i][0]=sc.nextInt();
			System.out.print("Enter weight of person "+(i+1)+" in (kg) :");
			studentInfo[i][1]=sc.nextInt();
			System.out.println();		
		}
		//method call to calculate BMI 
		String[][] result=statusNBMI(studentInfo);
		//method call to display result
		displayResult(result);
	}
	//method to calculate BMI
	public static String[][] calculateBMI(int[] info) {
		String[][] ans=new String[1][2];
			double heightInMeters=info[0]/100.0;
			double BMI=info[1]/(heightInMeters*heightInMeters);
			String status;
			if(BMI<=18.4) {
				status="Underweight";
			}
			else if(BMI>=18.5 && BMI<=24.9) {
				status="Normal";
			}
			else if(BMI>=25.0 && BMI<=39.9) {
				status="Overweight";
			}
			else {
				status="Obese";
			}
			ans[0][0]=String.valueOf(BMI);
			ans[0][1]=status;
		return ans;
	}
	//method to find status of BMI
	public static String[][] statusNBMI(int[][] studentInfo){
		String[][] result=new String[studentInfo.length][4];
		for(int i=0;i<studentInfo.length;i++) {
			result[i][0]=String.valueOf(studentInfo[i][0]);
			result[i][1]=String.valueOf(studentInfo[i][1]);
			String[][] arr=calculateBMI(studentInfo[i]);
			result[i][2]=arr[0][0];
			result[i][3]=arr[0][1];
		}
		return result;
	}
	//method to display the result
	public static void displayResult(String[][] result) {
		System.out.println("BMI Calculation");
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("Student\tHeight(in cm)\tWeight(in kg)\tBMI(kg/m^2) \t status");
		for(int i=0;i<result.length;i++) {
			System.out.printf("%d\t%s\t\t%s\t\t%.2f\t\t%s\n",(i+1),result[i][0],result[i][1],
					Double.parseDouble(result[i][2]),result[i][3]);
		}
	}

}
