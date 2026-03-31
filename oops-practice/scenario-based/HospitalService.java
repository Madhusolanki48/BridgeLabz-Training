package HospitalPatientManagementSystem;
import java.util.ArrayList;
import java.util.List;

public class HospitalService {
	private List<Patient> patients=new ArrayList<>();
	//Performing CRUD Operations
	//create patient
	public void addPatient(Patient p) {
		patients.add(p);
	}
	//read
	public void listPatients() {
		if (patients.isEmpty()) {
			System.out.println("No Patient Found!");
			return;
		}
		for (Patient p:patients) {
			p.displayPatientInfo();  
		}
	}
    public Patient getPatient(int id) {
        for (Patient p : patients) {
            if (p.getPatientId() == id)
                return p;
        }
        return null;
    }
    //update
    public void updatePatient(int id, String newName, int newAge) {
        Patient p = getPatient(id);
        if (p != null) {
            p.setPatientName(newName);
            p.setPatientAge(newAge);
            System.out.println("Patient updated successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }
    //delete
    public void deletePatient(int id) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientId() == id) {
                patients.remove(i);
                System.out.println("Patient deleted successfully.");
                return;
            }
        }
        System.out.println("Patient not found.");
    }
}
	

