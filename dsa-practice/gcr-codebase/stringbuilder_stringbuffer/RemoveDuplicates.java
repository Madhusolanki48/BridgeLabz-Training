package stringbuilder_stringbuffer;
import java.util.*;
//StringBuilder Problem 2: Remove Duplicates from a String Using StringBuilder

public class RemoveDuplicates {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	//user input
	System.out.print("Enter a String: ");
	String str=sc.next();
	//StringBuilder object
	StringBuilder sb=new StringBuilder();
	//set to store characters
	Set<Character> set=new HashSet<>();
	for(int i=0;i<str.length();i++) {
		if(set.contains(str.charAt(i))) {
			continue;
		}
		//in-built methods
		sb.append(str.charAt(i));
		set.add(str.charAt(i));
	}
	System.out.println("String without duplicates: "+sb.toString());
	}

}
