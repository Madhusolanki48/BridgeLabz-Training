package FactoryRobotHazardAnalyzer;
import java.util.*;
public class Program {
	public static void main(String[] args) {
		System.out.println("----------Welcome to Factory Robot Hazard Analyzer-------------\n\n");
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("Enter Arm Precision (0.0 - 1.0):");
			double armPrecision=sc.nextDouble();
			System.out.println("Enter Worker Density (1 - 20):");
			int workerDensity=sc.nextInt();
			System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
			String machineryState=sc.next();
			RobotHazardAuditor auditor=new RobotHazardAuditor();
			double ans=auditor.CalculateHazardRisk(armPrecision, workerDensity, machineryState);
			System.out.println("Robot Hazard Risk Score:"+ans);
		}
		catch(RobotSafetyException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
