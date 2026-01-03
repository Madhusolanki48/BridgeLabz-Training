package scenario_based;
import java.util.*;

public class TemperatureAnalyzer {
	public static void main(String[] args) {
		System.out.println("----------- Weekly Temperature Analyzer ----------");
        System.out.println("--------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        //week’s worth of hourly temperature data stored in a 2D array
        float[][] temps = new float[7][24];
        //user input
        System.out.println("Enter hourly temperatures for 7 days (in Celsius):");
        
        for (int day = 0; day < 7; day++) {
            System.out.println("\nDay " + (day + 1) + ":");
            for (int hour = 0; hour < 24; hour++) {
                System.out.print("Hour " + hour + ": ");
                temps[day][hour] = sc.nextFloat();
            }
        }
         //method calling
        float[] dailyAvg = getDailyAverages(temps);
        System.out.println(" Daily Average Temperatures:");
        for (int i = 0; i < dailyAvg.length; i++) {
            System.out.println("Day " + (i + 1) + ": " + dailyAvg[i] + " Celsius");
        }

        System.out.println();
        findHottestAndColdestDay(dailyAvg);
        System.out.println("\n------ Analysis Complete. Thank you! -------");
    }

    //method to return average temperature per day
    public static float[] getDailyAverages(float[][] temps) {
        float[] averages = new float[7];
        for (int day = 0; day < 7; day++) {
            float sum = 0;
            for (int hour = 0; hour < 24; hour++) {
                sum += temps[day][hour];
            }
            averages[day] = sum / 24;
        }
        return averages;
    }

    //method to finds hottest & coldest day based on average temperature
    public static void findHottestAndColdestDay(float[] dailyAvg) {
        int hottestDay = 0;
        int coldestDay = 0;

        for (int i = 1; i < dailyAvg.length; i++) {
            if (dailyAvg[i] > dailyAvg[hottestDay]) hottestDay = i;
            if (dailyAvg[i] < dailyAvg[coldestDay]) coldestDay = i;
        }

        System.out.println("Hottest Day  : Day " + (hottestDay + 1) +" (Avg = " + dailyAvg[hottestDay] + " Celsius)");
        System.out.println("Coldest Day  : Day " + (coldestDay + 1) +" (Avg = " + dailyAvg[coldestDay] + " Celsius)");
    }
}

