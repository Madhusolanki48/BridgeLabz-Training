package algorithm_runtimeanalysis;
import java.util.*;
public class SortingLargeDataSet {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter size of the array : ");
		int size=sc.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=size-i;
		}
		long startTime=System.nanoTime();
		bubbleSort(arr);
		long endTime=System.nanoTime();
		long timeTaken=endTime-startTime;
		System.out.println("Time taken by bubble sort to sort the array : "+timeTaken/1000000.0+" ms");
		startTime=System.nanoTime();
		mergeSort(arr,0,size-1);
		endTime=System.nanoTime();
		timeTaken=endTime-startTime;
		System.out.println("Time taken by merge sort to sort the array : "+timeTaken/1000000.0+" ms");
		startTime=System.nanoTime();
		quickSort(arr,0,size-1);
		endTime=System.nanoTime();
		timeTaken=endTime-startTime;
		System.out.println("Time taken by quick sort to sort the array : "+timeTaken/1000000.0+" ms");
	}
	//bubble sort
	public static void bubbleSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	//merge sort
	public static void mergeSort(int[] arr,int left,int right) {
		int n=arr.length;
		if (left < right) {
            int mid = left + (right - left) / 2;
            //sort left half
            mergeSort(arr, left, mid);
            //sort right half
            mergeSort(arr, mid + 1, right);
            //merge both halves
            merge(arr, left, mid, right);
        }
	}
	public static void merge(int[] arr, int left, int mid, int right) {
        int n1=mid-left+1;
        int n2=right-mid;
        int[] L=new int[n1];
        int[] R=new int[n2];
        // Copy data
        for (int i=0;i<n1;i++)
            L[i]=arr[left+i];
        for (int j=0;j<n2;j++)
            R[j]=arr[mid+1+j];

        int i=0,j=0,k=left;
        //merge arrays
        while (i<n1 && j<n2) {
            if (L[i]<=R[j]) {
                arr[k++]=L[i++];
            } else {
                arr[k++]=R[j++];
            }
        }
        //copy remaining elements
        while (i<n1) {
            arr[k++]=L[i++];
        }
        while (j<n2) {
            arr[k++]=R[j++];
        }
    }
	//quick sort
	public static void quickSort(int[] arr,int low,int high) {
		if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
	}
    //partition using last element as pivot
	public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
	//swap utility
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
