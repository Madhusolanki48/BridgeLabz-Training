package scenario_based;
import java.util.Scanner;

public class FlipKeyLogicalProblem {
	//method to cleanse and invert the input string
	public static String CleanseAndInvert(String input) {
		//check if null or length less than 6 characters
		if(input==null || input.length()<6) {
			return "";
		}
		//check for only alphabets : no space, digit, or special char
		for(char ch: input.toCharArray()) {
			if(!Character.isLetter(ch)) {
				return "";
			}
		}
		//convert to lowercase
		input=input.toLowerCase();	
		
		//remove all characters whose ASCII values are even numbers
		StringBuilder nonEvenAscii=new StringBuilder();
		for(char ch: input.toCharArray()) {
			if(ch % 2 != 0) {
				nonEvenAscii.append(ch);
			}
		}
		//reverse the remaining characters
		nonEvenAscii.reverse();
		
		//convert even index characters to uppercase
		for(int i=0;i<nonEvenAscii.length();i++) {
			if(i%2==0) {
				nonEvenAscii.setCharAt(i,Character.toUpperCase(nonEvenAscii.charAt(i)));
			}
		}
		return nonEvenAscii.toString();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a word: ");
		String input=sc.nextLine();
		//method calling
		String result=CleanseAndInvert(input);
		//print output
		if(result.isEmpty()) {
			System.out.println("Invalid input!");
		}else {
			System.out.println("The generated key is - "+result);
		}
		
	}

}
