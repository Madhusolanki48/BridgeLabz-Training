package extras;
import java.util.Scanner;
public class LongestWordInSentence {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a Sentence : ");
		String str=sc.nextLine();
		//method calling
		String result=isLongestWordInString(str);
		//print output
		System.out.print("The Longest Word in the sentence is : "+result);	
	}
	//method to find longest word in a string
	public static String isLongestWordInString(String s) {
		String[] words=s.split(" ");
		String result=new String();
		int longestWordLength=0;
		for(String word:words) {
			if(word.length()>longestWordLength) {
				longestWordLength=word.length();
				result=word;
			}
		}
		return result;
	}	

}
