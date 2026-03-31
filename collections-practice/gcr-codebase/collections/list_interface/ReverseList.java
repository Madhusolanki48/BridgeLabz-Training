package list_interface;
import java.util.*;
public class ReverseList {
	//reverse a ArrayList without using in-built method
	public static List<Integer> reverseArrayList(List<Integer> list){
		ArrayList<Integer> reversedArrayList=new ArrayList<>();
		for(int i=list.size()-1;i>=0;i--) {
			reversedArrayList.add(list.get(i));
		}
		return reversedArrayList;	
	}
	//reverse a LinkedList without using built-in method
	public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list){
		LinkedList<Integer> reversedLinkedList=new LinkedList<>();
		for(int i=list.size()-1;i>=0;i--) {
			reversedLinkedList.add(list.get(i));
		}
		return reversedLinkedList;
	}
	public static void main(String[] args) {
		System.out.println("----------  Reverse a List  ----------");
		ArrayList<Integer> arrayList=new ArrayList<>(Arrays.asList(1,2,3,4,5));
		System.out.println("Original ArrayList : "+arrayList);
		System.out.println("Reversed ArrayList : "+reverseArrayList(arrayList));
		
		LinkedList<Integer> linkedList=new LinkedList<>(Arrays.asList(1,2,3,4,5));
		System.out.println("Original LinkedList : "+linkedList);
		System.out.println("Reversed LinkedList : "+reverseLinkedList(linkedList));
		
	}

}
