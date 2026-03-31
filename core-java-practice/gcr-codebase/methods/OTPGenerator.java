package methods;
import java.util.*;
public class OTPGenerator {
	public static void main(String[] args) {
		//method call
        int[] otps = generateOTPsArray();
        boolean result = OTPsUnique(otps);
        System.out.println("Generated OTPs (10 attempts):");
        System.out.println(Arrays.toString(otps)); 
        System.out.println("\nAre OTPs unique? " + result);
    }
    //method to generate a 6-digit OTP using Math.random()
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    //method to generate 10 OTP values and store in array
    public static int[] generateOTPsArray() {
        int[] otps = new int[10];
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }

    //method to validate that OTP numbers generated are NOT all the same
    public static boolean OTPsUnique(int[] otps) {
        int first = otps[0];
        for (int i = 1; i < otps.length; i++) {
            if (otps[i] != first) {
                return true;   //unique otps
            }
        }
        return false;          
    }
}