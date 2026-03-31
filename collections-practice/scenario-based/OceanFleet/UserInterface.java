package OceanFleet;
import java.util.*;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VesselUtil util = new VesselUtil();

		System.out.print("Enter the number of vessels to be added: "); //3 
		int n = Integer.parseInt(sc.nextLine());

		System.out.println("Enter vessel details:");
		//input example
		//V001:Sea King:25.5:Cargo
		//V002:Ocean Star:18.0:Tanker
		//V003:Wave Rider:22.3:Cruise
		for (int i = 0; i < n; i++) {
			String[] data = sc.nextLine().split(":");
			Vessel v = new Vessel(data[0], data[1], Double.parseDouble(data[2]), data[3]);
			util.addVesselPerformance(v);
		}

		System.out.print("Enter the Vessel Id to check speed: "); //V001 or V004
		String searchId = sc.nextLine();

		Vessel found = util.getVesselById(searchId);
		if (found != null) {
			System.out.println(found.getVesselId() + " | " + found.getVesselName() + " | " + found.getVesselType()
					+ " | " + found.getAverageSpeed() + " knots");
		} else {
			System.out.println("Vessel Id " + searchId + " not found");
		}

		System.out.println("High performance vessels are");
		for (Vessel v : util.getHighPerformanceVessels()) {
			System.out.println(v.getVesselId() + " | " + v.getVesselName() + " | " + v.getVesselType() + " | "
					+ v.getAverageSpeed() + " knots");
		}
		sc.close();
	}
}
