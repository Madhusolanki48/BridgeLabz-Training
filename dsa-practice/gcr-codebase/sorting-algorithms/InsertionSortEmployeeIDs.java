package sorting_algorithms;
import java.util.Arrays;
//Insertion Sort - Sort Employee IDs

public class InsertionSortEmployeeIDs {
	public static void insertionSort(int[] ids) {
		for(int i=0;i<ids.length;i++) {
			int key=ids[i];
			int j=i-1;
			while(j>=0 && ids[j]>key) {
				ids[j+1]=ids[j];
				j--;
			}
			ids[j+1]=key;
		}
	}
	public static void main(String[] args) {
		int[] employeeIDs= {102,101,105,103,100};
		System.out.println("------------------ Insertion Sort  --------------------");
		System.out.println("Employee IDs Before Sorting: "+Arrays.toString(employeeIDs));
		
		insertionSort(employeeIDs);
		System.out.println("Employee IDs After Sorting: "+Arrays.toString(employeeIDs));
		
	}

}
