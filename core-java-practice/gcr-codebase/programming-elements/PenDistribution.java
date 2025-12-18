
public class PenDistribution {
	public static void main(String[] args) {
		int pens = 14;     //total pens
		int students = 3;  //total students
		int eachGet = pens/students;
		int remain = pens%students;
		System.out.println("The pen per student is "+eachGet+" and the remaining pen not distributed is "+remain);
	}

}
