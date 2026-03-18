package repository;
import db.DBConnection;
import model.Doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {
    //UC-2.1 : Add new doctor
	public int saveDoctor(Doctor d) {
	    String sql = "INSERT INTO doctors(name, contact, consultation_fee, specialty_id) VALUES(?,?,?,?)";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        ps.setString(1, d.getName());
	        ps.setString(2, d.getContact());
	        ps.setDouble(3, d.getConsultationFee());
	        ps.setInt(4, d.getSpecialtyId());

	        int rows = ps.executeUpdate();
	        if (rows > 0) {
	            ResultSet rs = ps.getGeneratedKeys();

	            if (rs.next()) {
	                return rs.getInt(1); 
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
    // Check if doctor already exists, prevents duplicate insert
    public boolean existsDoctor(String name, String contact) {
        String sql = "SELECT COUNT(*) FROM doctors WHERE name=? AND contact=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, contact);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0; // true if exists
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //UC-2.2 : Update doctor specialty using doctor_id
    public boolean updateSpecialty(int doctorId, int specialtyId) {

        String sql = "UPDATE doctors SET specialty_id=? WHERE doctor_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, specialtyId);
            ps.setInt(2, doctorId);

            return ps.executeUpdate() > 0; // true if updated

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //UC-2.3 : View doctors by specialty using JOIN
    public List<Doctor> getDoctorsBySpecialty(String specialtyName) {

        List<Doctor> list = new ArrayList<>();

        String sql = """
                SELECT DISTINCT d.doctor_id, d.name, d.contact, d.consultation_fee
                FROM doctors d
                JOIN specialties s ON d.specialty_id = s.specialty_id
                WHERE s.specialty_name = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, specialtyName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Doctor d = new Doctor();

                d.setDoctorId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setContact(rs.getString("contact"));
                d.setConsultationFee(rs.getDouble("consultation_fee"));
                list.add(d); // add to list
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    // UC-2.4 : Deactivate doctor 
    public boolean deactivateDoctor(int doctorId) {
        String sql = "UPDATE doctors SET is_active = false WHERE doctor_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            return ps.executeUpdate() > 0; // true if updated

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}