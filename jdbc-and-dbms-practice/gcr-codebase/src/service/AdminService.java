package service;
import repository.AdminRepository;
import model.Specialty;
import java.util.List;

public class AdminService {

    private AdminRepository repo = new AdminRepository();
    public boolean addSpecialty(String name) {
        return repo.addSpecialty(name);
    }

    public List<Specialty> getAllSpecialties() {
        return repo.getAllSpecialties();
    }
    public boolean updateSpecialty(int id, String name) {
        return repo.updateSpecialty(id, name);
    }

    public boolean deleteSpecialty(int id) {
        return repo.deleteSpecialty(id);
    }
    public List<String> getAuditLogs() {
        return repo.getAuditLogs();
    }
}