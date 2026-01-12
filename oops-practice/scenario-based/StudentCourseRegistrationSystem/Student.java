package StudentCourseRegistrationSystem;

import java.util.ArrayList;

//child class
public class Student extends Person {
	//attributes
	private ArrayList<Course> enrolledCourses;
	private ArrayList<GradeRecord> gradeList;

	//constructor
	public Student(int id, String name, String phone) {
		super(id, name, phone);
		enrolledCourses = new ArrayList<>();
		gradeList = new ArrayList<>();
	}

	//getter
	public ArrayList<Course> getEnrolledCourses() {
		return enrolledCourses;
	}

	public ArrayList<GradeRecord> getGradeList() {
		return gradeList;
	}

	//method to enroll course
	public void addCourse(Course course) {
		enrolledCourses.add(course);
	}

	//method to drop course
	public void removeCourse(int courseId) {
		boolean found = false;
		for (int i = 0; i < enrolledCourses.size(); i++) {
			if (enrolledCourses.get(i).getId() == courseId) {
				enrolledCourses.remove(i);
				System.out.println("Course Dropped Successfully!");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Course not found in enrolled list!");
		}
	}

	//method to show enrolled courses
	public void displayEnrolledCourses() {
		System.out.println("\n----- Enrolled Courses -----");
		if (enrolledCourses.size() == 0) {
			System.out.println("No courses enrolled yet!");
			return;
		}
		for (Course c : enrolledCourses) {
			System.out.println(c);
		}
	}

	//method to add grade
	public void addOrUpdateGrade(int courseId, String grade) {
		for (GradeRecord gr : gradeList) {
			if (gr.getCourseId() == courseId) {
				gr.setGrade(grade);
				System.out.println("Grade Updated Successfully!");
				return;
			}
		}
		gradeList.add(new GradeRecord(courseId, grade));
		System.out.println("Grade Assigned Successfully!");
	}

	//method to display grades
	public void displayGrades() {
		System.out.println("\n----- Grades -----");
		if (gradeList.size() == 0) {
			System.out.println("No grades assigned yet!");
			return;
		}
		for (GradeRecord gr : gradeList) {
			System.out.println(gr);
		}
	}
}
