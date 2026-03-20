package service;
import model.Visit;
import model.Prescription;
import repository.VisitRepository;
import java.util.List;

public class VisitService {

	private VisitRepository repo = new VisitRepository();

	// UC-4.1
	public int recordVisit(Visit v) {
		return repo.recordVisit(v);
	}

	// UC-4.3
	public void addPrescriptions(List<Prescription> list) {
		repo.addPrescriptions(list);
	}

	// UC-4.2
	public List<String> getHistory(int patientId) {
		return repo.getMedicalHistory(patientId);
	}
}