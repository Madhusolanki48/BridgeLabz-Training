package extras;
import java.util.*;
public class ReplaceWord {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a sentence : ");
		String sentence=sc.nextLine();
		System.out.print("Enter first word : ");
		String word1=sc.next();
		System.out.print("Enter second word : ");
		String word2=sc.next();
	    //method call
		String result=replaceWords(sentence,word1,word2);
		//print output
		System.out.print("Sentence after replacing "+word1+" with "+word2+" is : \n"+result);
	}
	//method to replace a word with another word in a sentence
	public static String replaceWords(String sentence,String word1,String word2) {
		sentence=sentence.replaceAll(word1,word2);
		return sentence;
	}
}