package leet_code_codebase;
import java.util.Scanner;
//Leetcode Problem No.-34
//Given gas available and travel cost between stations,
//find the starting station index from where the car can complete the circuit.Return -1 if not possible.
public class GasStation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of stations: ");
        int numberOfStations = sc.nextInt();
        int[] gas = new int[numberOfStations];
        int[] cost = new int[numberOfStations];
        System.out.print("Enter gas at each station:");
        for (int i = 0; i < numberOfStations; i++) {
            gas[i] = sc.nextInt();
        }
        System.out.print("Enter cost to go to next station:");
        for (int i = 0; i < numberOfStations; i++) {
            cost[i] = sc.nextInt();
        }
        //method call
        int result = canCompleteCircuit(gas, cost);
        if (result == -1)
            System.out.println("Circuit cannot be completed");
        else
            System.out.println("Start from station index: " + result);

    }
    //method to check from which station the car can complete the circuit
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        //check if total gas is enough overall
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost)
            return -1;   //impossible to complete circle
        int remainsGas = 0;
        int start = 0;
      
        for (int i = 0; i < gas.length; i++) {

            remainsGas += gas[i] - cost[i];
            //if gas becomes negative, reset start
            if (remainsGas < 0) {
                start = i + 1;
                remainsGas = 0;
            }
        }
        return start;  
    }
}
