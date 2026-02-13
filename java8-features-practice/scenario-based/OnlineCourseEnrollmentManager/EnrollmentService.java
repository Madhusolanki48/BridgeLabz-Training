package OnlineCourseEnrollmentManager;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//business logic layer
public class EnrollmentService {

	private EnrollmentRepository repository = new EnrollmentRepository();

	// method to filter by course name
	public List<Enrollment> filterByCourse(String courseName) {
		return repository.findAll().stream().filter(e -> e.getCourseName().equalsIgnoreCase(courseName)) 
				.collect(Collectors.toList());
	}

	// filter by category
	public List<Enrollment> filterByCategory(String category) {
		return repository.findAll().stream().filter(e -> e.getCourseCategory().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}

	// group by course name
	public Map<String, List<Enrollment>> groupByCourse() {
		return repository.findAll().stream().collect(Collectors.groupingBy(Enrollment::getCourseName)); 
	}

	// count per category
	public Map<String, Long> countByCategory() {
		return repository.findAll().stream()
				.collect(Collectors.groupingBy(Enrollment::getCourseCategory, Collectors.counting()));
	}

	// sort by enrollment date
	public List<Enrollment> sortByDate() {
		return repository.findAll().stream().sorted(Comparator.comparing(Enrollment::getEnrollmentDate)) 
				.collect(Collectors.toList());
	}
}
