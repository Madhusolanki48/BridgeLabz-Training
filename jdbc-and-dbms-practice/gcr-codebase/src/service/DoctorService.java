package service;
import model.Doctor;
import repository.DoctorRepository;
import java.util.List;

public class DoctorService {

    private DoctorRepository repo = new DoctorRepository();
    // UC-2.1: method to add doctor
    public int addDoctor(Doctor d) {
    	if (repo.existsDoctor(d.getName(), d.getContact())) {
            return -1;
        }
        return repo.saveDoctor(d);
    }
    // UC-2.2 : method to update specialty
    public boolean updateSpecialty(int doctorId, int specialtyId) {
        return repo.updateSpecialty(doctorId, specialtyId);
    }
    // UC-2.3 : method to view doctor
    public List<Doctor> getDoctorsBySpecialty(String name) {
        return repo.getDoctorsBySpecialty(name);
    }
    // UC-2.4 : method to deactivate doctor
    public boolean deactivateDoctor(int doctorId) {
        return repo.deactivateDoctor(doctorId);
    }
}