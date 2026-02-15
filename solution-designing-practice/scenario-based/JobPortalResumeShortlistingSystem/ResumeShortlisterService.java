package JobPortalResumeShortlistingSystem;
import java.util.*;

// Handles resume ranking logic
public class ResumeShortlisterService {

	//rank resumes based on skill match
	public List<Resume> shortlist(List<Resume> resumes, Set<String> requiredSkills) throws InvalidResumeException {

		if (resumes == null || resumes.isEmpty()) {
			throw new InvalidResumeException("Resume list is empty");
		}

		//sort by matching skill count (descending)
		resumes.sort(new Comparator<Resume>() {
			@Override
			public int compare(Resume r1, Resume r2) {
				return Integer.compare(countMatch(r2, requiredSkills), countMatch(r1, requiredSkills));
			}
		});

		return resumes;
	}

	//count matching skills
	private int countMatch(Resume resume, Set<String> requiredSkills) {
		int count = 0;
		for (String skill : resume.getSkills()) {
			if (requiredSkills.contains(skill)) {
				count++;
			}
		}
		return count;
	}
}
