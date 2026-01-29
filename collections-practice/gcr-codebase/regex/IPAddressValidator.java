package regex;

public class IPAddressValidator {
    public static void main(String[] args) {
        //input IP address
        String ip = "192.168.1.1";
        //regex: valid IPv4 address
        String regex =
                "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}" +
                "(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";
        //validate and print result
        if (ip.matches(regex)) {
            System.out.println(ip+" is a Valid IP Address");
        } else {
            System.out.println(ip+" is an Invalid IP Address");
        }
    }
}
