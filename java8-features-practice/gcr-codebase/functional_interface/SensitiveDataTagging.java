package functional_interface;

//marker interface
interface SensitiveData {
}

//sensitive class
class CreditCard implements SensitiveData {
	String number = "1234-5678-9012";
}

//security processor
public class SensitiveDataTagging {
	public static void main(String[] args) {
		CreditCard card = new CreditCard();

		//check marker
		if (card instanceof SensitiveData) {
			System.out.println("Encrypt data!");
		} else {
			System.out.println("No encryption needed!");
		}
	}
}
