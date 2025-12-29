package extras;
import java.time.*;
public class DateArithmetic {
	public static void main(String[] args) {
		LocalDate date=LocalDate.now();
		System.out.println("Current date : "+date);  //prints current date
		date=date.plusDays(7);   //adds 7 days
		date=date.plusMonths(1); //adds 1 month
		date=date.plusYears(2);  //adds 2 years
		date=date.minusWeeks(3); //subtracts 3 weeks
		System.out.println("Updated date : "+date ); //prints updated date
	}

}
