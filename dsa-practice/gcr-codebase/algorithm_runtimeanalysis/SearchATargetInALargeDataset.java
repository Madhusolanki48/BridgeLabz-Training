package algorithm_runtimeanalysis;
import java.util.*;
public class SearchATargetInALargeDataset {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//size of the array
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=i;
		}
		//target element
		System.out.print("Enter target value : ");
		int target=sc.nextInt();
		long startTime=System.nanoTime();
		int ans=linearSearch(arr,target);
		long endTime=System.nanoTime();
		//time taken by linear search to find an element
		long time=endTime-startTime;
		System.out.println("Time taken by linear search is : "+time/1000000.0+" ms");
		startTime=System.nanoTime();
		ans=binarySearch(arr,target);
		endTime=System.nanoTime();
		//time taken by binary search to find an element
		time=endTime-startTime;
		System.out.println("Time taken by binary search is : "+time/1000000.0+" ms");
	}
	//linear search algorithm
	public static int linearSearch(int[] arr,int target) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target) {
				return i;
			}
		}
		return -1;
	}
	//binary search algorithm
	public static int binarySearch(int[] arr,int target) {
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target) {
				return mid;
			}
			else if(arr[mid]>target) {
				end=mid-1;
			}
			else {
				start=mid+1;
			}
		}
		return -1;
	}
}
