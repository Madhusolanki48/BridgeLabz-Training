package repository;
import db.DBConnection;
import model.Patient;
import java.util.*;
import java.sql.*;

public class PatientRepository {

	//check if patient already exists (phone/email)
	public boolean existsByPhoneOrEmail(String phone, String email) {
		String sql = "SELECT COUNT(*) FROM patients WHERE phone=? OR email=?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, phone);
			ps.setString(2, email);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt(1) > 0; // true if exists
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//insert new patient
	public boolean save(Patient p) {

		String sql = "INSERT INTO patients(name,dob,phone,email,address,blood_group) VALUES(?,?,?,?,?,?)";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, p.getName());
			ps.setDate(2, p.getDob());
			ps.setString(3, p.getPhone());
			ps.setString(4, p.getEmail());
			ps.setString(5, p.getAddress());
			ps.setString(6, p.getBloodGroup());

			return ps.executeUpdate() > 0; // true if inserted

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// UC-1.2: update patient details using patient_id
	public boolean update(Patient p) {
		String sql = "UPDATE patients SET name=?, dob=?, phone=?, email=?, address=?, blood_group=? WHERE patient_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, p.getName());
			ps.setDate(2, p.getDob());
			ps.setString(3, p.getPhone());
			ps.setString(4, p.getEmail());
			ps.setString(5, p.getAddress());
			ps.setString(6, p.getBloodGroup());
			ps.setInt(7, p.getPatientId()); 
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//UC-1.3 : search patients by name using LIKE
	public List<Patient> searchByName(String keyword) {
		List<Patient> list = new ArrayList<>();
		String sql = "SELECT * FROM patients WHERE name LIKE ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Patient p = new Patient();
				p.setPatientId(rs.getInt("patient_id"));
				p.setName(rs.getString("name"));
				p.setPhone(rs.getString("phone"));
				p.setEmail(rs.getString("email"));

				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	//UC-1.4 : get visit history of a patient
	public void getVisitHistory(int patientId) {
		String sql = "SELECT visit_id, d.name AS doctor_name,v.diagnosis, v.visit_date FROM visits v JOIN appointments a ON v.appointment_id = a.appointment_id "+""
				+ "JOIN doctors d ON a.doctor_id = d.doctor_id WHERE a.patient_id=? ORDER BY v.visit_date DESC";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, patientId);
			ResultSet rs = ps.executeQuery();
			System.out.println("\n Visit History:");
			System.out.println("----------------------------------");
			boolean found = false;
			while (rs.next()) {
				found = true;

				System.out.println("Visit ID: " + rs.getInt("visit_id"));
				System.out.println("Doctor: " + rs.getString("doctor_name"));
				System.out.println("Diagnosis: " + rs.getString("diagnosis"));
				System.out.println("Date: " + rs.getTimestamp("visit_date"));
				System.out.println("----------------------------------");
			}

			if (!found) {
				System.out.println("No visit history found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}