package extras;
import java.time.*;
public class DateComparison {
	public static void main(String[] args) {
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.of(2026,8,4);
		System.out.println(date1+ " comes before "+date2+" ? "+date1.isBefore(date2));
		System.out.println(date1+ " comes after "+date2+" ? "+date1.isAfter(date2));
		System.out.println(date1+ " is equals to "+date2+" ? "+date1.isEqual(date2));
		
	}

}
