package methods;
import java.util.Scanner;
public class SimpleInterest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter Principal Amount : ");
		double principalAmount=sc.nextDouble();
		System.out.print("Enter Rate of Interest (in %) : ");
		double rateOfInterest=sc.nextDouble();
		System.out.print("Enter Time Period : ");
		double time=sc.nextDouble();
		//method calling
		double result=calculateSimpleInterest(principalAmount,rateOfInterest,time);
		System.out.print("The Simple Interest is "+result+" for Principal "+principalAmount+ 
				" Rate of Interest "+rateOfInterest+" and Time "+ time);
	}
	//method to calculate Simple Interest
	public static double calculateSimpleInterest(double principal,double rateOfInterest,double time) {
		//SI calculation formula
		double simpleInterest =(principal* rateOfInterest* time) / 100 ;
		return simpleInterest;
	}

}
