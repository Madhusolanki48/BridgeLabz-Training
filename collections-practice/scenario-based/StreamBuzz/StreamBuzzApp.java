package StreamBuzz;
import java.util.*;

public class StreamBuzzApp {
	public static void main(String[] args) {
		Program app=new Program();
		Scanner sc=new Scanner(System.in);
		System.out.println("--------------  Welcome to StreamBuzz  ------------");
		boolean check=true;
		  do{
			  System.out.println("\n\nChoice 1 : Register Creator");
			  System.out.println("Choice 2 : Show Top Posts");
			  System.out.println("Choice 3 : Calculate Average Likes");
			  System.out.println("Choice 4 : Exit");
			  System.out.println("Enter your choice : ");
			  int choice=sc.nextInt();
			  switch(choice){
			  case 1:
				  System.out.print("Enter Creator Name : ");
				  String name=sc.nextLine();
				  System.out.println("Enter weekly likes(Week 1 to 4): ");
				  List<Double> likes=new ArrayList<>();
				  for(int i=0;i<4;i++) {
					  likes.add(sc.nextDouble());
				  }
				  app.registerCreator(new CreatorStats(name,likes));
				  System.out.println("Creator registered successfully.");
				  break;
			  case 2:
				  System.out.print("Enter like threshold : ");
				  double threshold=sc.nextDouble();
				  Map<String,Integer> map=app.getTopPostCounts(CreatorStats.engagementBoard, threshold);
				  if(map.isEmpty()) {
					  System.out.println("No top-performing posts this week");
					  break;
				  }
				  for(String str:map.keySet()) {
					  System.out.println(str+" - "+map.get(str));
				  }
				  break;
			  case 3:
				  double average=app.calculateAverageLikes();
				  System.out.println("Overall average weekly Likes : "+average);
				  break;
			  case 4:
				  check=false;
				  System.out.println("Exiting....");
				  System.out.println("Thank you for using Stream Buzz !");
				  break;
			  default:
				  System.out.println("Enter a valid choice");
		      } 
	      }while(check);
     }
}