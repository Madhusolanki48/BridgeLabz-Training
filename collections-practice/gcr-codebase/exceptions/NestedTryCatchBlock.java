package exceptions;

public class NestedTryCatchBlock {
	public static void main(String[] args) {
		//inputs
		int[] arr= {10,20,30,40,50};
		int index=5;
		int divisor=0;
		//nested try-catch blocks
		try {
			try {
				System.out.println(arr[index]/divisor);
			}catch(ArithmeticException e) {
				System.out.println("Cannot divide by zero!");
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid array index!");
		}
	}

}
