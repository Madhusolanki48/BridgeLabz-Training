package OnlineCourseEnrollmentManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//acts as in-memory database
public class EnrollmentRepository {

    private List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentRepository() {
        enrollments.add(new Enrollment("Maxwell", "Java", "Programming", LocalDate.of(2025, 5, 1)));
        enrollments.add(new Enrollment("Raven", "Python", "Programming", LocalDate.of(2025, 5, 3)));
        enrollments.add(new Enrollment("Andrew", "UI/UX", "Design", LocalDate.of(2025, 4, 28)));
        enrollments.add(new Enrollment("Samuel", "Java", "Programming", LocalDate.of(2025, 5, 2)));
        enrollments.add(new Enrollment("Retro", "Photoshop", "Design", LocalDate.of(2025, 4, 25)));
    }

    //return all enrollments
    public List<Enrollment> findAll() {
        return enrollments;
    }
}
