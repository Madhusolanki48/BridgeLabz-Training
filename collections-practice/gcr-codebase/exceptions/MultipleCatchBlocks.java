package exceptions;

public class MultipleCatchBlocks {
	public static void main(String[] args) {
		//inputs
		int[] arr= {23,56,78,44,89};
		int index=5;
		try {
			System.out.println("Value at index "+index+": "+arr[index]);
		}
		//multiple catch blocks
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid Index!");	
		}
		catch(NullPointerException e) {
			System.out.println("Array is not Initialized!");
		}
	}

}
