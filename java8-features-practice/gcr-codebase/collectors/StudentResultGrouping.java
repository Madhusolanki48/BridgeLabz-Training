package collectors;
import java.util.*;
import java.util.stream.*;

class Student {
	String name;
	String grade;
    //constructor
	Student(String name, String grade) {
		this.name = name;
		this.grade = grade;
	}
    //getter method
	String getName() {
		return name;
	}

	String getGrade() {
		return grade;
	}
}
//main class
public class StudentResultGrouping {
	public static void main(String[] args) {
		List<Student> students = List.of(new Student("Amiley", "A"), new Student("Rimen", "B"), new Student("Nedrew", "A"),
				new Student("Raven", "B"));

		//group students by grade and collect names
		Map<String, List<String>> result = students.stream().collect(
				Collectors.groupingBy(Student::getGrade, Collectors.mapping(Student::getName, Collectors.toList())));

		System.out.println(result);
	}
}
