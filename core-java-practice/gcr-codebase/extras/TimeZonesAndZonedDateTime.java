package extras;
import java.time.*;
public class TimeZonesAndZonedDateTime {
	public static void main(String[] args) {
		//GMT
		ZonedDateTime gmtTime=ZonedDateTime.now(ZoneId.of("GMT"));
        System.out.println("GMT Time : " + gmtTime);
        //IST
		ZonedDateTime istTime=ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("IST Time : " + istTime);
        //PST
		ZonedDateTime pstTime=ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("PST Time : " + gmtTime);		
	}
}