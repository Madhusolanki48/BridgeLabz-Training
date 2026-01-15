package sorting_algorithms;
import java.util.Arrays;
//Bubble Sort - Sort Student Marks

public class BubbleSortStudentMarks {
	//method to perform bubble sort
	public static void bubbleSort(int[] marks) {
		int n=marks.length;
		for(int i=0;i<n-1;i++) {
			boolean swapped=false;
			for(int j=0;j<n-1-i;j++) {
				if(marks[j]>marks[j+1]) {
					//swap
					int temp=marks[j];
					marks[j]=marks[j+1];
					marks[j+1]=temp;
					swapped=true;
				}	
			}
			if(!swapped)
				break;
		}
	}
	public static void main(String[] args) {
		int[] studentMarks= {56,87,76,54,67,99};
		System.out.println("----------------------  Bubble Sort  ---------------------");
		System.out.println("Marks of Student Before Sorting: "+Arrays.toString(studentMarks));
		
		bubbleSort(studentMarks);
		System.out.println("Marks of Student After Sorting: "+Arrays.toString(studentMarks));
	}

}
