package regex;
public class SSNValidator {
    public static void main(String[] args) {

        //input SSN
        String ssn = "123-45-6789";

        //regex: SSN format XXX-XX-XXXX
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        //validate and print result
        if (ssn.matches(regex)) {
            System.out.println(ssn+" is a Valid SSN");
        } else {
            System.out.println(ssn+" is an Invalid SSN");
        }
    }
}
