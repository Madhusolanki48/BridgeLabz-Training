
public class ProfitNLossCalc {
	public static void main(String[] args) {
		  int cp = 129;  //cost price
		  int sp = 191;  //selling price
		  //profit=selling price-cost price
	      int profit =sp-cp;
	      //profit percentage=profit/cost price*100
	      double profitPercent = (profit * 100)/cp;
	      System.out.println("The Cost Price is INR "+ cp +" and Selling Price is INR "+ sp);
	      System.out.println("The Profit is INR "+ profit +" and the Profit Percentage is " + profitPercent);     
	 
	}
}
