package stack_queue;
import java.util.*;
//Cicular Tour Problem
public class CircularTourProblem {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of petrol pumps: ");  //ex: {4, 6, 7, 4}
        int n = sc.nextInt();
        int[] petrol = new int[n];
        int[] distance = new int[n];
        System.out.print("Enter petrol available at each pump:");  //ex: {6, 5, 3, 5}
        for (int i = 0; i < n; i++) {
            petrol[i] = sc.nextInt();
        }

        System.out.print("Enter distance to next pump from each pump:");
        for (int i = 0; i < n; i++) {
        	distance[i] = sc.nextInt();
        }
        int startIndex = findStart(petrol, distance);
        if (startIndex == -1) {
            System.out.println("Circular tour is NOT possible.");
        } else {
            System.out.println("Starting Pump Index: " + startIndex);
        }
    }
    public static int findStart(int[] petrol, int[] dist) {
        int totalSurplus = 0;
        int currSurplus = 0;
        int start = 0;
        for (int i = 0; i < petrol.length; i++) {
            int gain = petrol[i] - dist[i];
            totalSurplus += gain;
            currSurplus += gain;
            //if we can't reach next pump, restart from next index
            if (currSurplus < 0) {
                start = i + 1;
                currSurplus = 0;
            }
        }

        return (totalSurplus >= 0) ? start : -1;
    }
}
