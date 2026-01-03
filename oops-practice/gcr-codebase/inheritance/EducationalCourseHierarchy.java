package inheritance;
//Multilevel Inheritance
//Sample Problem 2: Educational Course Hierarchy

class Course { //base class
	//attributes
	String courseName;
	int duration;

	Course(String courseName,int duration){
		this.courseName=courseName;
		this.duration=duration;
	}
}
//subclass
class OnlineCourse extends Course { //level 2
	String platform;
	boolean isRecorded;

	OnlineCourse(String name,int duration,String platform,boolean isRecorded){
		super(name,duration);
		this.platform=platform;
		this.isRecorded=isRecorded;
	}
}

class PaidOnlineCourse extends OnlineCourse { //level 3
	double fee;
	double discount;

	PaidOnlineCourse(String n,int d,String p,boolean r,double fee,double discount){
		super(n,d,p,r);
		this.fee=fee;
		this.discount=discount;
	}

	void showDetails(){
		System.out.println("Course : "+courseName);
		System.out.println("Duration : "+duration+" Days");
		System.out.println("Platform : "+platform);
		System.out.println("Fee : "+fee);
	}
}

public class EducationalCourseHierarchy {
	public static void main(String[] args) {
		PaidOnlineCourse course=new PaidOnlineCourse("DSA",30,"Coursera",true,5999,10);
		course.showDetails();
	}
}
