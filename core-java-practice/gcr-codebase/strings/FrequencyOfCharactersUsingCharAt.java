package strings;
import java.util.*;
public class FrequencyOfCharactersUsingCharAt {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input 
		System.out.print("Enter a string : ");
		String text=sc.next();
		//output
		String[][] result=findFrequencyOfCharacters(text);
		printResult(result);			
	}
	//method to find length of the string
	public static int getStringLength(String str) {
		int count=0;
		try {  //code containing exception
			while(true) {
				char ch=str.charAt(count);
				count++;
			}
		}
		catch(StringIndexOutOfBoundsException e) {

		}
		return count;
		
	}
	//method to find frequency 
	public static String[][] findFrequencyOfCharacters(String s){
		int[] freqArray=new int[256];
		for(int i=0;i<getStringLength(s);i++) {
			freqArray[s.charAt(i)]++;
		}
		String[][] ansArray=new String[getStringLength(s)][2];
		for(int i=0;i<getStringLength(s);i++) {
			ansArray[i][0]=String.valueOf(s.charAt(i));
			ansArray[i][1]=String.valueOf(freqArray[s.charAt(i)]);
		}
		return ansArray;
	}
	//method to display result
	public static void printResult(String[][] resultArray) {
		for(int i=0;i<resultArray.length;i++) {
			System.out.println("Frequency of character "+resultArray[i][0]+" is "+resultArray[i][1]);
		}
	}

}