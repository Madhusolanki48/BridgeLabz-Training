
public class StudentFeeNDiscount {
	public static void main(String[] args) {
	 double fee = 125000;  //course fee
     double discountPercent = 10;  //discount rate
     double discountPrice = (fee * discountPercent) / 100;  //discount amount
     double payFee = fee - discountPrice;    //final fee
     System.out.println("The discount amount is INR " + discountPrice +
                        " and final discounted fee is INR " + payFee);
	}

}
