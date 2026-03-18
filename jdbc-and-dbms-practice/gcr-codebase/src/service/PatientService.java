package service;
import model.Patient;
import repository.PatientRepository;
import java.util.*;

public class PatientService {

    private PatientRepository repo = new PatientRepository();

    //register patient with validation
    public boolean registerPatient(Patient p) {

        //check duplicate
        if (repo.existsByPhoneOrEmail(p.getPhone(), p.getEmail())) {
            System.out.println("Patient already exists!");
            return false;
        }
        return repo.save(p);
    }

	// UC-1.2 : update patient
	public boolean updatePatient(Patient p) {
		return repo.update(p);
	}
	// UC-1.3 : search patient
	public List<Patient> searchPatient(String keyword) {
	    return repo.searchByName(keyword);
	}
	// UC-1.4 : view history
	public void viewVisitHistory(int patientId) {
	    repo.getVisitHistory(patientId);
	}
}