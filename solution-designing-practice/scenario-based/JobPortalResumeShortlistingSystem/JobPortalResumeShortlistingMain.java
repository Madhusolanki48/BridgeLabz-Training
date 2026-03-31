package JobPortalResumeShortlistingSystem;

import java.util.*;

public class JobPortalResumeShortlistingMain {

	public static void main(String[] args) {

		// Required skills
		Set<String> requiredSkills = new HashSet<>(Arrays.asList("Java", "Spring", "SQL"));

		// Resume list
		List<Resume> resumes = new ArrayList<>();
		resumes.add(new Resume("Madhu", Set.of("Java", "SQL")));
		resumes.add(new Resume("Raven", Set.of("Java")));
		resumes.add(new Resume("Andrew", Set.of("Java", "Spring", "SQL")));

		ResumeShortlisterService service = new ResumeShortlisterService();

		try {
			List<Resume> ranked = service.shortlist(resumes, requiredSkills);

			// Print ranked resumes
			System.out.println("Ranked Resumes (Best Match First):");

			int rank = 1;
			for (Resume r : ranked) {
			    System.out.println(rank++ + ". " + r.getName());
			}

		} catch (InvalidResumeException e) {
			System.out.println(e.getMessage());
		}
	}
}
