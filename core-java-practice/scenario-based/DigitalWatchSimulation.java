package scenario_based;
public class DigitalWatchSimulation {
    public static void main(String[] args) {
    	//loop through hours
        for (int hour = 0; hour < 24; hour++) {
        	//loop through minutes
            for (int minute = 0; minute < 60; minute++) {
                //print time in HH:MM format
                System.out.println(String.format("%02d:%02d", hour, minute));
                //stop watch at 13:00 i.e. Power Cut ---given
                if (hour == 13 && minute == 0) {
                    System.out.println("Power cut! Watch stopped at 13:00");
                    break;
                }
            }
            //stop outer loop after power cut
            if (hour == 13) break;
        }
    }
}

