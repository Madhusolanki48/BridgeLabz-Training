import java.util.Scanner;
class KilometersToMilesConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the distance in kms : ");
        double km = sc.nextDouble();
        //formula for km to miles conversion
        double miles = km * 0.621371;
        System.out.println("The given distance in miles : "+miles);
    }
}
