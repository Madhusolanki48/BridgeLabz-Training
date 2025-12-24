package methods;
import java.util.Scanner;
public class ChoclateDistribution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter number of total childern : ");
		int numberOfChildren=sc.nextInt();
		System.out.print("Enter number of total choclates : ");
		int numberOfChoclates=sc.nextInt();
        //method call
		int[] result=findChoclateCount(numberOfChildren,numberOfChoclates);
		System.out.println("Number of choclates each child gets = "+result[0]);
		System.out.print("Number of remaining choclates = "+result[1]);
		
	}
	//method to find the number of chocolates each child gets and number of remaining chocolates
	public static int[] findChoclateCount(int numberOfChildren, int numberOfChoclates) {
		int eachChildrenGetChoclate= numberOfChoclates / numberOfChildren;
		int remainingChoclates= numberOfChoclates % numberOfChildren;
		//array to store result
		int[] result= {eachChildrenGetChoclate,remainingChoclates};
		return result;
	}

}
