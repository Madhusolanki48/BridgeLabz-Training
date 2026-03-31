package extras;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateFormatting {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();    //current date
        //Formatter 1: dd/MM/yyyy
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Formatter 2: yyyy-MM-dd
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //Formatter 3: EEE, MMM dd, yyyy
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        //print formatted dates
        System.out.println("Format 1 (dd/MM/yyyy): "+ today.format(format1));
        System.out.println("Format 2 (yyyy-MM-dd): "+ today.format(format2));
        System.out.println("Format 3 (EEE, MMM dd, yyyy): "+ today.format(format3));
    }
}
