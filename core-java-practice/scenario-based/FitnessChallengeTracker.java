package scenario_based;
import java.util.Scanner;
class FitnessChallengeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pushupsWeek = new int[7];
        int day = 1;
        //user input
        System.out.println("-----------Sandeep's Fitness Challenge Tracker-----------");
        System.out.println("Enter number of push-ups for each day or 0 for rest day (day-wise)\n");
        for (int i = 0; i < pushupsWeek.length; i++) {
            System.out.print("Total push-ups on Day " + day + " : ");
            pushupsWeek[i] = sc.nextInt();
            day++;
        }
        int totalPushups = 0;
        int activeDays = 0;
        for (int pushups : pushupsWeek) {
            if (pushups == 0)
            	continue; //skip rest day
            totalPushups += pushups;
            activeDays++;
        }
        double averagePushUps = 0;
        if (activeDays > 0) {
            averagePushUps = (double) totalPushups / activeDays;
        }
        System.out.println("\n----------Weekly Report----------");
        System.out.println("Total push-ups count in a week : " + totalPushups);
        System.out.printf("Number of Average push-ups on workout days : %.2f ", averagePushUps);

    }
}

