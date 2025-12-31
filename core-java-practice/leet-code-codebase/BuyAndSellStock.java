package leet_code_codebase;
import java.util.Scanner;
//Leetcode Problem No.- 121
//Given an array of stock prices where prices[i] is the price on day i,
//find the maximum profit by buying on one day and selling on another day.
public class BuyAndSellStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of days: ");
        int number = sc.nextInt();
        int[] prices = new int[number];
        System.out.print("Enter stock prices:");
        for (int i = 0; i < number; i++) {
            prices[i] = sc.nextInt();
        }
        //method call
        int result = maxProfit(prices);
        //print output
        System.out.println("Maximum Profit: " + result);

    }
    //method to find max profit 
    public static int maxProfit(int[] prices) {
        int buy = prices[0];   // lowest price seen so far
        int profit = 0;        // best profit so far
        //start checking from day 1
        for (int i = 1; i < prices.length; i++) {
            //update buy price if a lower value is found
            if (prices[i] < buy) {
                buy = prices[i];
            }
            //check possible profit if sold today
            else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}

