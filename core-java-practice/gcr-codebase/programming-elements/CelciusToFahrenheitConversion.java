import java.util.Scanner;
class CelciusToFahrenheitConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the temp in celcius: ");
        double c = sc.nextDouble();
        //conversion formula
        double f = (c * 9 / 5) + 32;
        System.out.println("The temp in Fahrenheit : "+f);
    }
}

