package methods;
import java.util.Scanner;
public class SmallestNLargestAmongThree {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number1 : ");
		int number1=sc.nextInt();
		System.out.print("Enter number2 : ");
		int number2=sc.nextInt();
		System.out.print("Enter number3 : ");
		int number3=sc.nextInt();
		//method call
		int[] result=findSmallestAndLargest(number1,number2,number3);
		//print output
		System.out.println("Smallest number is : "+result[0]);
		System.out.print("Largest number is : "+result[1]);
		
	}
	//method to find smallest and largest among 
	public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
		int[] result=new int[2];
		//for smallest number among them
		if(number1<number2 && number1<number3) {
			result[0]=number1;
		}else if(number2<number1 && number2<number3) {
			result[0]=number2;
		}else {
			result[0]=number3;
		}
		//for largest number among them
		if(number1>number2 && number1>number3) {
			result[1]=number1;
		}else if(number2>number1 && number2>number3) {
			result[1]=number2;
		}else {
			result[1]=number3;
		}
		return result;
	}
}
