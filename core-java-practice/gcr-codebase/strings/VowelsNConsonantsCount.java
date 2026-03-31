package extras;
import java.util.*;
public class VowelsNConsonantsCount {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter String : ");
		String str=sc.nextLine();
		int[] freq=findFrequency(str);
		//print output
		System.out.println("Frequency of vowels and consonants in the string is : ");
		System.out.println("Number of vowels in the string are : "+freq[0]);
		System.out.println("Number of consonants in the string are : "+freq[1]);
	}
	    //method to find the length of a string
		public static int findLength(String str) {
			int count=0;
			//try catch block to handle exception
			try {
				while(true) {
					char ch=str.charAt(count);
					count++;
				}
			}
			catch(StringIndexOutOfBoundsException e) {

			}
			return count;
		}
	    //function to check if a character is vowel or consonant or something else
	    public static String isVowelOrConsonant(char ch) {
			if(ch>=65 && ch<=90) {
				ch=(char)(ch+32);
			}
			if(!(ch>=97 && ch<=122)) {
				return new String("Not a letter");
			}
			else if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
				return new String("Vowel");
			}
			else {
				return new String("Consonant");
			}
		
	}
	    //function to calculate frequency of vowel and consonant in a string 
	    public static int[] findFrequency(String str){
		    int[] freqArray=new int[findLength(str)];
		    for(char ch:str.toCharArray()) {
			    String type=isVowelOrConsonant(ch);
			    if(type.equals("Vowel")) {
				    freqArray[0]+=1;
			    }
			    else if(type.equals("Consonant")) {
				    freqArray[1]+=1;
			    }
		    }
		    return freqArray;
	}

}