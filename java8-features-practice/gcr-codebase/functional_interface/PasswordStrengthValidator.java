package functional_interface;
//interface with static utility method
interface SecurityUtils {

	//static method to validate password strength
	static boolean isStrongPassword(String password) {
		return password.length() >= 8; // basic rule
	}
}

public class PasswordStrengthValidator {
	public static void main(String[] args) {
		String password = "Secure123";
		//calling static method using interface name
		if (SecurityUtils.isStrongPassword(password)) {
			System.out.println("Strong password");
		} else {
			System.out.println("Weak password");
		}
	}
}
