package repository;
import db.DBConnection;
import model.Visit;
import model.Prescription;
import java.sql.*;
import java.util.*;

public class VisitRepository {
	// UC-4.1 Record visit + update appointment
	public int recordVisit(Visit v) {
		String visitSql = "INSERT INTO visits(appointment_id, diagnosis, notes) VALUES(?,?,?)";
		String updateSql = "UPDATE appointments SET status='COMPLETED' WHERE appointment_id=?";

		try (Connection conn = DBConnection.getConnection()) {

			conn.setAutoCommit(false);

			PreparedStatement ps1 = conn.prepareStatement(visitSql, Statement.RETURN_GENERATED_KEYS);
			ps1.setInt(1, v.getAppointmentId());
			ps1.setString(2, v.getDiagnosis());
			ps1.setString(3, v.getNotes());

			ps1.executeUpdate();

			ResultSet rs = ps1.getGeneratedKeys();
			int visitId = -1;

			if (rs.next()) {
				visitId = rs.getInt(1);
			}

			PreparedStatement ps2 = conn.prepareStatement(updateSql);
			ps2.setInt(1, v.getAppointmentId());
			ps2.executeUpdate();

			conn.commit();
			return visitId;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	//UC-4.3 Batch insert prescriptions
	public void addPrescriptions(List<Prescription> list) {
		String sql = "INSERT INTO prescriptions(visit_id, medicine_name, dosage, duration) VALUES(?,?,?,?)";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			for (Prescription p : list) {
				ps.setInt(1, p.getVisitId());
				ps.setString(2, p.getMedicineName());
				ps.setString(3, p.getDosage());
				ps.setString(4, p.getDuration());
				ps.addBatch();
			}

			ps.executeBatch(); //batch insert

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// UC-4.2 Medical history (JOIN)
	public List<String> getMedicalHistory(int patientId) {

		List<String> list = new ArrayList<>();

		String sql = """
				    SELECT v.visit_id, v.diagnosis, p.medicine_name, p.dosage, a.appointment_id
				    FROM visits v
				    JOIN appointments a ON v.appointment_id = a.appointment_id
				    JOIN prescriptions p ON v.visit_id = p.visit_id
				    WHERE a.patient_id = ?
				    ORDER BY v.visit_date DESC
				""";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, patientId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add("Visit ID: " + rs.getInt("visit_id") + " | Diagnosis: " + rs.getString("diagnosis")
						+ " | Medicine: " + rs.getString("medicine_name") + " | Dosage: " + rs.getString("dosage"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}