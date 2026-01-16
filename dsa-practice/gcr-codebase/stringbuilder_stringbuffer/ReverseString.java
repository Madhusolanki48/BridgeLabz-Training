package stringbuilder_stringbuffer;
import java.util.*;
//StringBuilder Problem 1: Reverse a String Using StringBuilder

public class ReverseString {
	public static void main(String[] args) {
		String str="hello";
		//StringBuilder object
		StringBuilder sb=new StringBuilder(str);
		System.out.println("Original String: "+str);
		//in-built method to reverse the string
		sb.reverse();
		System.out.println("Reversed String: "+sb.toString());
	}

}
